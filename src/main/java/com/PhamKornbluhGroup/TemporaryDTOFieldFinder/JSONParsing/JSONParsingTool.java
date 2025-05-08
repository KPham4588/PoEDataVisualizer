package com.PhamKornbluhGroup.TemporaryDTOFieldFinder.JSONParsing;

import com.PhamKornbluhGroup.APIResultData;
import com.PhamKornbluhGroup.TemporaryDTOFieldFinder.BulkAPIUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class JSONParsingTool {
    private HashSet<String> currentJsonFields = new HashSet<>();

    public void traverseJson(APIResultData apiResultData) throws Exception {
        String json = apiResultData.getContent();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        JSONItemHelper helper = new JSONItemHelper();

        HashMap<String, String[]> fieldsAndValues = new HashMap<>();

        try (JsonParser parser = rootNode.traverse()) {
            JsonToken currentToken;
            String currentValue = "";

            /*
             * Tokens we care about are:
             *      START_OBJECT
             *      END_OBJECT
             *      FIELD_NAME
             */
            while ((currentToken = parser.nextToken()) != null) {
                String currentName = parser.currentName();
                if (currentName != null && !currentName.isBlank() && !currentName.isEmpty()
                        && !currentName.equalsIgnoreCase("items"))
                {
                    if (currentToken.name().equalsIgnoreCase("START_OBJECT"))
                    {
                        while (!currentToken.name().equalsIgnoreCase("FIELD_NAME"))
                        {
                            currentValue += parser.getValueAsString();
                        }
                    }
                    else if (currentToken.name().equalsIgnoreCase("START_ARRAY"))
                    {
                        while (!currentToken.name().equalsIgnoreCase("FIELD_NAME"))
                        {
                            currentValue += parser.getValueAsString();
                        }
                    }
                }

                helper.handleToken(currentToken, currentName);

                String newFieldPath = helper.getFieldPath();
                if (!newFieldPath.isBlank()) {
                    fieldsAndValues.put(newFieldPath, new String[]{ currentToken.name(), currentValue});
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception in traverseJSON method of JSONParsingTool");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        for (String i : fieldsAndValues.keySet()) {
            System.out.println("key: " + i + " value: " + Arrays.toString(fieldsAndValues.get(i)));
        }
        //BulkAPIUtils.compareKnownFieldsAndUpdate(currentJsonFields, apiResultData.getPageChangeID());
        currentJsonFields.clear();

    }

    public void printElements() {
        for (String result : currentJsonFields) {
            System.out.println(result);
        }
    }
}
