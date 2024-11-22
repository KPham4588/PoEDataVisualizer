import java.io.FileWriter;
import java.net.*;
import java.net.URL;

public class runner {
    public static void main(String[] args) {
        //b GGG Get URL
        HttpURLConnection connection = null;
        APIResultData resultData = null;
        try {
            URL url = new URL("https://api.pathofexile.com/public-stash-tabs/pc");
            connection = (HttpURLConnection) url.openConnection();

            //b Configure connection
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + args[0]); // Command Line Arg

            //b Connect here. Disconnect happens in finally block
            connection.connect();

            resultData = new APIResultData(connection);
        }
        catch (Exception e) {
        }
        finally {
            connection.disconnect();
        }


        //b writer autocloses
        try (FileWriter writer = new FileWriter(args[1])) {
            writer.write(resultData.getContent());
        }
        catch (Exception e) {
        }


//
//        String fullContent = "";
//        while (reader.ready()) {
//            fullContent += reader.read();
//        }

        try {
            System.out.println("Response Code = " + resultData.getResponseCode());

        }
        catch (Exception e) {
            System.out.println("Response Code Error");
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Response Message = " + resultData.getResponseMessage());
        }
        catch (Exception e) {
            System.out.println("Response Message Error");
            System.out.println(e.getMessage());
        }

    }

}