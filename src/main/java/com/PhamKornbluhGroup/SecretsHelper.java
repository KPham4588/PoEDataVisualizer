package com.PhamKornbluhGroup;

// TODO: Determine if DefaultCredentialsProvider must be specified #1
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

public class SecretsHelper {
    // If you need more information about configurations or implementing the sample
    // code, visit the AWS docs:
    // https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html

    public static String GetGGGBearerTokenFromSecretsManager() {
        // call getAWSSecret with the proper secret name
        return "";
    }

    private static String getGGGBearerToken() {
        String tokenName = "GGGBearerToken";
        Region region = Region.of("us-east-1");

        //b Create a token request object
        GetSecretValueRequest tokenRequest =
                GetSecretValueRequest.builder()
                                     .secretId(tokenName)
                                     .build();

        //b Create a client which can send the token request to AWS.
        // Try-With-Resources Auto-Closes the client
        try (SecretsManagerClient requestClient =
                     SecretsManagerClient.builder()
                                         .region(region)
                                         // TODO: Determine if DefaultCredentialsProvider must be specified #2
                                         //.credentialsProvider(DefaultCredentialsProvider.create())
                                         .build()) {


            //b Send the token request to AWS through the client
            GetSecretValueResponse getSecretValueResponse = requestClient.getSecretValue(tokenRequest);

            //b Retrieve the secret token value
                //b Attempt #1 - Get String
            String secret = getSecretValueResponse.secretString();
                //b Attempt #2 - If String is null, get using binary array
            if (secret == null) {
                byte[] secretBinary = getSecretValueResponse.secretBinary().asByteArray();
                secret = new String(secretBinary);
            }
            return secret;
        }
        catch (SecretsManagerException e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            System.err.println("Error retrieving the secret: " + e.awsErrorDetails().errorMessage());
        }
        return "TOKEN_DEFAULT_RETURN";
    }
}