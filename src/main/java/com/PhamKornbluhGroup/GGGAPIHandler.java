package com.PhamKornbluhGroup;

import com.PhamKornbluhGroup.DAO.ResultDAO;
import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.PhamKornbluhGroup.jsonParsing.JSONParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        if (numberOfResults <= 0 ) {
            String errorMessage = "Number of results must be 1 or more when calling GGGAPIHandler.saveNumberOfResultsToDB";
            GGGAPIHandlerLogger.error(errorMessage);
            throw new Exception(errorMessage);
        }

        String currentPageChangeId = pageChangeId;
        ResultDAO dao = new ResultDAO();
        for (int i = 0; i < numberOfResults; i++) {
            GGGAPIHandlerLogger.info(
                    "Calling handler.getPOEDataFromServer(currentPageChangeId) with currentPageChangeId of "
                    + "\""
                    + currentPageChangeId
                    + "\""
            );

            APIResultData apiResultData = this.getPOEDataFromServer(currentPageChangeId);

            //b Parse and Insert page
            ResultDTO resultDTO = JSONParser.parseAPIResultData(apiResultData);
            dao.insertResult(resultDTO);

            //b Update pageChangeId
            currentPageChangeId = resultDTO.getNextChangeId();
        }
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
}
