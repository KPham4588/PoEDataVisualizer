package com.PhamKornbluhGroup;

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

    // TODO: make functionalities to actually get and store pageChangeId to pass in here
    public APIResultData getPublicStashData(String pageChangeId) {
        HttpURLConnection connection = null;
        APIResultData resultData = new APIResultData();

        try {
            connection = createAndOpenGETConnection(pageChangeId);

            //b Connect here. Disconnect happens in finally block
            connection.connect();

            resultData.initResultData(connection);
        }
        catch (Exception e) {
            GGGAPIHandlerLogger.error("{}{}", e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
        finally {
            try {
                connection.disconnect();
            }
            catch (Exception e) {
                GGGAPIHandlerLogger.error("Got exception when closing API connection. Error = {}", e.getMessage());
            }
        }
        return resultData;
    }
}
