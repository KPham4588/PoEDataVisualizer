package com.PhamKornbluhGroup.utilities;

import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ChangeIdService {
    private final String _changeIdUrl;

    public ChangeIdService(String _changeIdUrl) {
        this._changeIdUrl = _changeIdUrl;
    }

    public String getLatestChangeId() {
        try {
            String rawChangeIdBody = getChangeId();
            return extractChangeId(rawChangeIdBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getChangeId() throws IOException {
        URL url = new URL(_changeIdUrl);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        StringBuilder urlContent = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            urlContent.append(inputLine);
        }
        String stringToDeserialize = urlContent.toString();

        in.close();
        return stringToDeserialize;
    }

    private String extractChangeId(String rawChangeIdBody) {
        ObjectMapper mapper = new ObjectMapper();
        ChangeIdModel changeIdModel = mapper.readValue(rawChangeIdBody, ChangeIdModel.class);

        return changeIdModel.psapi;
    }

    private record ChangeIdModel (String psapi, String forum) { }
}
