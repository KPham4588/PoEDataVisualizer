package com.PhamKornbluhGroup.utilities;

import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ChangeIdService {
    private final String changeIdUrl;

    public ChangeIdService(String changeIdUrl) {
        this.changeIdUrl = changeIdUrl;
    }

    public String fetchLatestPageChangeId() {
        try {
            String rawChangeIdBody = fetchChangeId();
            return extractChangeId(rawChangeIdBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String fetchChangeId() throws IOException {
        URL url = new URL(changeIdUrl);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            StringBuilder urlContent = new StringBuilder();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                urlContent.append(inputLine);
            }
            String apiResult = urlContent.toString();

            return apiResult;
        }
    }

    private String extractChangeId(String rawChangeIdBody) {
        ObjectMapper mapper = new ObjectMapper();
        ChangeIdModel changeIdModel = mapper.readValue(rawChangeIdBody, ChangeIdModel.class);

        return changeIdModel.psapi;
    }

    // We only use "psapi" - public stash api - it is the latest page change ID for the API
    // forum is included for completeness to completely map what we get from the GGG URL
    private record ChangeIdModel (String psapi, String forum) { }
}
