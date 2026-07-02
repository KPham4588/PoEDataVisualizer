package com.PhamKornbluhGroup;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

public class SecretsHelper {

    public static String[] getFormattedGGGBearerToken() {
        //p For this method to work, the name of the secret must be the same as the secret's key
        String tokenName = "GGGBearerToken";
        String secret = getSecretsManagerSecret(tokenName);
        String formattedSecret = parseJsonToken(secret, tokenName);

        return new String[] {"Authorization", formattedSecret};
    }

    public static String[] getFormattedGGGBearerTokenUserAgent() {
        //p For this method to work, the name of the secret must be the same as the secret's key
        String tokenName = "GGGBearerToken_User-Agent";
        String secret = getSecretsManagerSecret(tokenName);
        String formattedSecret = parseJsonToken(secret, tokenName);

        return new String[] {"User-Agent", formattedSecret};
    }

    private static String getSecretsManagerSecret(String tokenName) {
        Region region = Region.of("us-east-1");

        GetSecretValueRequest tokenRequest =
                GetSecretValueRequest.builder()
                                     .secretId(tokenName)
                                     .build();

        // Try-With-Resources Auto-Closes the client
        try (SecretsManagerClient requestClient =
                     SecretsManagerClient.builder()
                                         .region(region)
                                         .build()) {

            GetSecretValueResponse getSecretValueResponse = requestClient.getSecretValue(tokenRequest);

            //b Attempt #1 - Get String
            String secret = getSecretValueResponse.secretString();
            //b Attempt #2 - If String is null, get using binary array
            if (secret == null) {
                byte[] secretBinary = getSecretValueResponse.secretBinary().asByteArray();
                secret = new String(secretBinary);
            }
            return secret;
        }
        catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            System.err.println("Error retrieving the secret: " + e.getMessage());
        }
        return "TOKEN_DEFAULT_RETURN";
    }

    private static String parseJsonToken(String jsonToken, String key) {
        String parsedToken = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonToken);
            parsedToken = node.get(key).asText();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return parsedToken;
    }
}
