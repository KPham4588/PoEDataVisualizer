package com.PhamKornbluhGroup.TemporaryDTOFieldFinder.JSONParsing;

import com.PhamKornbluhGroup.APIResultData;
import com.PhamKornbluhGroup.TemporaryDTOFieldFinder.BulkAPIUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;

public class JSONParsingTool {
    private HashSet<String> knownNodes = new HashSet<>();
    private boolean initialized = false;

    //b Tokens:
    //p JsonToken.START_OBJECT (Denotes the beginning of our element)
    //p START_OBJECT / END_OBJECT
    //p START_ARRAY / END_ARRAY
    //b FIELD_NAME
    //b VALUE_STRING (Type)
    //r NULL at the end

    public void init() {
        try {
            BulkAPIUtils.getKnownFields();
            this.knownNodes = (HashSet<String>) BulkAPIUtils.knownFields.clone();
            System.out.println("INITIALIZATION SUCCESS");
        }
        catch (Exception e) {
            System.out.println("Failure to get knownFields, called from JSONParsingTool");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

    }

    public void traverseJson(APIResultData apiResultData) throws Exception {
        String json = apiResultData.getContent();
        if (!initialized) {
            init();
            initialized = true;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        JSONItemHelper helper = new JSONItemHelper();

        try (JsonParser parser = rootNode.traverse()) {
            JsonToken currentToken;
            while ((currentToken = parser.nextToken()) != null) {
                String currentName = parser.currentName();
                helper.handleToken(currentToken, currentName);

                String newFieldPath = helper.getFieldPath();
                if (!newFieldPath.isBlank()) {
                    knownNodes.add(newFieldPath);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception in traverseJSON method of JSONParsingTool");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        BulkAPIUtils.compareKnownFieldsAndUpdate(knownNodes, apiResultData.getPageChangeID());
    }

    public void printElements() {
        for (String result : knownNodes) {
            System.out.println(result);
        }
    }
}
