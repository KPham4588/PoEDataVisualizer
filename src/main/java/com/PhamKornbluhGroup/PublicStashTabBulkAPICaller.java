package com.PhamKornbluhGroup;

import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class PublicStashTabBulkAPICaller {

    public APIResultData callAndPrintResults() {
        //b GGG Get URL
        HttpURLConnection connection = null;
        APIResultData resultData = new APIResultData();
        try {
            URL url = new URL("https://api.pathofexile.com/public-stash-tabs/pc");
            connection = (HttpURLConnection) url.openConnection();

            //b Configure connection
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", SecretsHelper.formatGGGBearerToken(SecretsHelper.getGGGBearerToken()));
            connection.setRequestProperty("User-Agent", SecretsHelper.formatGGGBearerTokenUserAgent(SecretsHelper.GGGBearerTokenUserAgent()));
            // TODO: Determine if the following 2 properties are needed
            // connection.setRequestProperty("Content-Type","application/json");

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
