package com.PhamKornbluhGroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.util.Properties;

public class SecretsHelper {
    // If you need more information about configurations or implementing the sample
    // code, visit the AWS docs:
    // https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html

    public static String[] getFormattedGGGBearerToken() {
        //p For this method to work, the name of the secret must be the same as the secret's key
        String tokenName = "GGGBearerToken";
        String secret = getSecretsManagerSecret(tokenName);
        String formattedSecret = parseJsonToken(secret, tokenName);

        String[] keyValue = new String[] {"Authorization", formattedSecret};
        return keyValue;
    }

    public static String[] getFormattedGGGBearerTokenUserAgent() {
        //p For this method to work, the name of the secret must be the same as the secret's key
        String tokenName = "GGGBearerToken_User-Agent";
        String secret = getSecretsManagerSecret(tokenName);
        String formattedSecret = parseJsonToken(secret, tokenName);

        String[] keyValue = new String[] {"User-Agent", formattedSecret};
        return keyValue;
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
                                         // TODO: Determine if DefaultCredentialsProvider must be specified #2
                                         //.credentialsProvider(DefaultCredentialsProvider.create())
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
            // TODO: Add Logging
            // TODO: Specify which exceptions
            System.out.println(e.getMessage());
        }
        return parsedToken;
    }

    public static Properties getDBInformation() {
        // username, password, driver, and url are exact strings that will be used to match variables in the mybatisconfig.xml
        // If we change in one place, must change in the other place as well
        Properties props = new Properties();
        props.setProperty("username", getDBUserName());
        props.setProperty("password", getDBPassword());
        props.setProperty("driver", getDBDriver());
        props.setProperty("url", getDBURL());
        return props;
    }

    private static String getDBUserName() {
        String secretName = "rds!db-441d80e3-7441-46d3-a3dc-4c068869ffcb";
        String secret = getSecretsManagerSecret(secretName);
        return parseJsonToken(secret, "username");
    }

    private static String getDBPassword() {
        String secretName = "rds!db-441d80e3-7441-46d3-a3dc-4c068869ffcb";
        String secret = getSecretsManagerSecret(secretName);
        return parseJsonToken(secret, "password");
    }

    private static String getDBDriver() {
        String secretName = "poe-oracle_driver_and_url";
        String secret = getSecretsManagerSecret(secretName);
        return parseJsonToken(secret, "driver");
    }

    private static String getDBURL() {
        String secretName = "poe-oracle_driver_and_url";
        String secret = getSecretsManagerSecret(secretName);
        return parseJsonToken(secret, "url");
    }
}