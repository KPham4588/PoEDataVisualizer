import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public final class APIResultData {
    private int responseCode;
    private String responseMessage;
    private String encoding;
    private String content;

    APIResultData(HttpURLConnection connection) {
        StringBuilder builder = new StringBuilder();
        //b responseStream autocloses
        //b reader autocloses
        try (InputStream responseStream = (InputStream) connection.getContent();
             BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8));) {
            this.responseCode = connection.getResponseCode();
            this.responseMessage = connection.getResponseMessage();
            this.encoding = connection.getContentEncoding();

            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            this.content = builder.toString();
        }
        catch (Exception e) {
        }
    }

    public int getResponseCode() {
        return responseCode;
    }
    private void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
    private void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getEncoding() {
        return encoding;
    }
    private void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getContent() {
        return content;
    }
    private void setContent(String content) {
        this.content = content;
    }
}
