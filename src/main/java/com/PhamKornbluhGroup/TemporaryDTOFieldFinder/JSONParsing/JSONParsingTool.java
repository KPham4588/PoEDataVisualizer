package com.PhamKornbluhGroup.TemporaryDTOFieldFinder.JSONParsing;

import com.PhamKornbluhGroup.APIResultData;
import com.PhamKornbluhGroup.TemporaryDTOFieldFinder.BulkAPIUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;

public class JSONParsingTool {
    private HashSet<String> currentJsonFields = new HashSet<>();

    public void traverseJson(APIResultData apiResultData) throws Exception {
        String json = apiResultData.getContent();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        JSONItemHelper helper = new JSONItemHelper();

        try (JsonParser parser = rootNode.traverse()) {
            JsonToken currentToken;
            /**
             * Tokens we care about are:
             *      START_OBJECT
             *      END_OBJECT
             *      FIELD_NAME
             */
            while ((currentToken = parser.nextToken()) != null) {
                String currentName = parser.currentName();
                helper.handleToken(currentToken, currentName);

                String newFieldPath = helper.getFieldPath();
                if (!newFieldPath.isBlank()) {
                    currentJsonFields.add(newFieldPath);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception in traverseJSON method of JSONParsingTool");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        BulkAPIUtils.compareKnownFieldsAndUpdate(currentJsonFields, apiResultData.getPageChangeID());
    }

    public void printElements() {
        for (String result : currentJsonFields) {
            System.out.println(result);
        }
    }
}
