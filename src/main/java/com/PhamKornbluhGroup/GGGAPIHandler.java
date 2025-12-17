package com.PhamKornbluhGroup;

import com.PhamKornbluhGroup.DAO.ResultDAO;
import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.PhamKornbluhGroup.jsonParsing.JSONParser;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class GGGAPIHandler {

    private final static Logger GGGAPIHandlerLogger = LogManager.getLogger(GGGAPIHandler.class);

    private HttpURLConnection createAndOpenGETConnection(String pageChangeId) throws IOException {
        String requestURL = String.format("https://api.pathofexile.com/public-stash-tabs?id=%s", pageChangeId);

        URL url = new URL(requestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        String[] gggBearerToken = SecretsHelper.getFormattedGGGBearerToken();
        connection.setRequestProperty(gggBearerToken[0], gggBearerToken[1]);

        String[] gggUserAgent = SecretsHelper.getFormattedGGGBearerTokenUserAgent();
        connection.setRequestProperty(gggUserAgent[0], gggUserAgent[1]);

        return connection;
    }

    public void saveNumberOfResultsToDB(int numberOfResults, String pageChangeId) throws Exception {
        if (numberOfResults < 0 ) {
            String errorMessage = "Number of results must be 1 or more when calling GGGAPIHandler.saveNumberOfResultsToDB";
            GGGAPIHandlerLogger.error(errorMessage);
            throw new Exception(errorMessage);
        }

        //b Use GGGAPIHandler to get an APIResultData w/ pageChangeId
        GGGAPIHandler handler = new GGGAPIHandler();

        String currentPageChangeId = pageChangeId;
        ResultDAO dao = new ResultDAO();
        for (int i = 0; i < numberOfResults; i++) {

            GGGAPIHandlerLogger.trace(
                    "Calling handler.getPOEDataFromServer(currentPageChangeId) with currentPageChangeId of "
                    + "\""
                    + currentPageChangeId
                    + "\""
            );
            APIResultData apiResultData = handler.getPOEDataFromServer(currentPageChangeId);

            if (apiResultData == null) {
                String errorMessage =
                        """
                        call to handler.getPOEDataFromServer() returned null data
                        at page change number %d with pageChangeId of %s
                        """;
                GGGAPIHandlerLogger.error(String.format(errorMessage, i, currentPageChangeId));
                throw new FileNotFoundException(String.format(errorMessage, i, currentPageChangeId));
            }

            //b Parse and Insert page
            ResultDTO resultDTO = JSONParser.parseAPIResultData(apiResultData);
            dao.insertResult(resultDTO);

            //b Update pageChangeId
            currentPageChangeId = resultDTO.getNextChangeId();
        }


        SqlSession pool = SessionPool.getSession();
        GGGAPIHandlerLogger.trace("Committing SessionPool in GGGAPIHandler.saveNumberOfResultsToDB");
        pool.commit();
        GGGAPIHandlerLogger.trace("Closing SessionPool in GGGAPIHandler.saveNumberOfResultsToDB");
        SessionPool.close(pool);
        GGGAPIHandlerLogger.trace("SessionPool is now closed in GGGAPIHandler.saveNumberOfResultsToDB");
        GGGAPIHandlerLogger.trace("Final pageChangeId = " + currentPageChangeId);
    }

    private APIResultData getPOEDataFromServer(String pageChangeId) {
        HttpURLConnection connection = null;
        APIResultData resultData = new APIResultData();

        try {
            connection = createAndOpenGETConnection(pageChangeId);

            //b Connect here. Disconnect happens in finally block
            connection.connect();

            resultData.initResultData(connection);
        }
        catch (Exception e) {
            GGGAPIHandlerLogger.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        finally {
            try {
                connection.disconnect();
            }
            catch (Exception e) {
                GGGAPIHandlerLogger.error("Got exception when closing API connection. Error = " + e.getMessage());
            }
        }
        return resultData;
    }

    public void writeAPIResultToLocalFile(APIResultData resultData, File fileLocation) {
        /*The following is how I've been calling this
         *         //b writer auto-closes
         *         File fileLocation = new File("C:\\Users\\Public\\Documents\\APIResult.txt");
         *         this.writeAPIResultToLocalFile(resultData, fileLocation);
         */
        try (FileWriter writer = new FileWriter(fileLocation)) {
            writer.write(resultData.getContent());
        }
        catch (Exception e) {
            System.out.println("Failure to write API Result Data. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
    }
}
