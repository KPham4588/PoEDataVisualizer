package com.PhamKornbluhGroup.TemporaryDTOFieldFinder;

import com.PhamKornbluhGroup.APIResultData;
import com.PhamKornbluhGroup.SecretsHelper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 Process #1
 #1 - Run the API, using changeID retrieved from file. Save to APIResults/APIResult1.txt
 (Check if File0 exists, if it does Check File1, and so on. Create a new one that doesnt exist yet)
 #2 - Update the changeID
 #3 - Repeat until APIresult100.txt is done
 #4 - Update the file with changeID from APIResult100.txt

 2707364413-2673472354-2598988668-2887209023-2794820282

 Process #2
 Step 1 - Create initial hashSet by grabbing from knownFields.txt file. If this step throws exception, initialize empty Hashset
 Step 2 - Make a new map, which will then take in all fields (Formatted with Level 0 --> Level 1 --> Level N)
 Step 3 - Start with APIResult1.txt, (handle via stream, to avoid memory overload??) Go breadth-first adding elements labeled in this format (Items). Later on (Items --> sockets).. Later on (Items --> sockets --> group). Add to new map
 Step 4 - Repeat for all 100 files
 Step 5 - Compare saved map against new map, printing the differences to another file (Check if File0 exists, if it does Check File1, and so on. Create a new one that doesnt exist yet)
 */
public class BulkAPIResultHandler {

    public void getAndSaveOnePOEApiResult() {
        this.getAndSavePOEDataToLocalFile("");
    }
    public void getAndSaveOnePOEApiResult(String changeId) {
        this.getAndSavePOEDataToLocalFile(changeId);
    }

    private void getAndSavePOEDataToLocalFile(String changeId) {
        HttpURLConnection connection = null;
        APIResultData resultData = new APIResultData();

        String pageChangeId = changeId;
        // If no specific changeId is passed in, get pageChangeId from local file
        if (pageChangeId.isBlank()) {
            pageChangeId = BulkAPIUtils.getChangeId();
        }

        try {
            //W START HERE
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
        BulkAPIUtils.saveAPIResults(resultData);
    }

}

