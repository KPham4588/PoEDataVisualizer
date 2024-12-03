package com.PhamKornbluhGroup;

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

    public APIResultData() {
    }

    public void initResultData(HttpURLConnection connection) {
        StringBuilder builder = new StringBuilder();
        //b responseStream autocloses
        //b reader autocloses
        try (InputStream responseStream = (InputStream) connection.getContent(); // TODO: see if better --> connection.getInputStream()
             BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8));) {
            this.responseCode = connection.getResponseCode();
            this.responseMessage = connection.getResponseMessage();
            this.encoding = connection.getContentEncoding();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            this.content = builder.toString();
        }
        catch (Exception e) {
            System.out.println("Failure in initResultData for APIResultData object. Message = " + e.getMessage());
            // TODO - Add logging & fix Exception to multi-catch block of all possible exceptions
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
