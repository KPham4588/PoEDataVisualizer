package com.PhamKornbluhGroup;

import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class GGGAPIHandler {

    public APIResultData getAndSaveOnePOEAPIResult() throws Exception {
        APIResultData data = this.getAndSavePOEDataToLocalFile("");
        return data;
    }

    public APIResultData getAndSaveOnePOEAPIResult(String changeId) throws Exception {
        APIResultData data = this.getAndSavePOEDataToLocalFile(changeId);
        return data;
    }
    
    private APIResultData getAndSavePOEDataToLocalFile(String changeId) {
        HttpURLConnection connection = null;
        APIResultData resultData = new APIResultData();

        String pageChangeId = changeId;

        try {
            String requestURL = String.format("https://api.pathofexile.com/public-stash-tabs?id=%s", pageChangeId);

            URL url = new URL(requestURL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            String[] gggBearerToken = SecretsHelper.getFormattedGGGBearerToken();
            connection.setRequestProperty(gggBearerToken[0], gggBearerToken[1]);

            String[] gggUserAgent = SecretsHelper.getFormattedGGGBearerTokenUserAgent();
            connection.setRequestProperty(gggUserAgent[0], gggUserAgent[1]);
            
            //b Connect here. Disconnect happens in finally block
            connection.connect();

            resultData.initResultData(connection);
        }
        catch (Exception e) {
            // TODO: Add Logging
            System.out.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        finally {
            try {
                connection.disconnect();
            }
            catch (Exception e) {
                // TODO: Add Logging
                System.out.println("Got exception when closing API connection. Error = " + e.getMessage());
            }
        }

        //b writer auto-closes
        this.writeResults(resultData);

        return resultData;
    }

    private void writeResults(APIResultData resultData) {
        // TODO: Fix hard-coded filepath
        try (FileWriter writer = new FileWriter("C:\\Users\\Public\\Documents\\APIResult.txt")) {
            writer.write(resultData.getContent());
        }
        catch (Exception e) {
            System.out.println("Failure to write API Result Data. Error Message = " + e.getMessage());
            System.out.println("Full Message = " + Arrays.toString(e.getStackTrace()));
        }
    }
}
