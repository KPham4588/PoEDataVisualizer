package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JSONParser {

    public PublicStashChangeDTO traversePublicStashChange(String json) throws Exception {
        PublicStashChangeDTO currentPublicStashChange = new PublicStashChangeDTO();

        //p Set-up the top-level rootnode, and basic parsing
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        //p Iterate through key/value pairs on PublicStashChange
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> currentField = fieldsIterator.next();

            switch (currentField.getKey()) {
                case "id" -> currentPublicStashChange.setId(currentField.getValue().asText());
                case "public" -> currentPublicStashChange.setPublic(currentField.getValue().asBoolean());
                case "accountName" -> currentPublicStashChange.setAccountName(currentField.getValue().asText());
                case "stash" -> currentPublicStashChange.setStash(currentField.getValue().asText());
                case "stashType" -> currentPublicStashChange.setStashType(currentField.getValue().asText());
                case "league" -> currentPublicStashChange.setLeague(currentField.getValue().asText());
                case "items" -> traverseItems(currentPublicStashChange, currentField.getValue());
                default -> {}
            }
        }
        return currentPublicStashChange;
    }

    public PublicStashChangeDTO traverseItems(PublicStashChangeDTO publicStashChangeDTO, JsonNode jsonNode) {
        ArrayList<ItemDTO> itemList = new ArrayList<>();

        Iterator<JsonNode> items = jsonNode.elements();
        while (items.hasNext()) {
            JsonNode nextItem = items.next();

            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = nextItem.fields();
            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> currentField = fieldsIterator.next();
                System.out.println(currentField.getKey() + " = " + currentField.getValue());
            }
            Iterator<JsonNode> s = nextItem.elements();
            while (s.hasNext()) {
                System.out.println("has next has next");
                System.out.println(s.next().asText());
            }
        }

        return publicStashChangeDTO;
    }

}
