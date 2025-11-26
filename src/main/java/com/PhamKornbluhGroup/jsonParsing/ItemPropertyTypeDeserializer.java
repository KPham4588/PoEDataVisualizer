package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemPropertyDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemPropertyTypeDeserializer extends JsonDeserializer<List<ItemPropertyDTO>> {

    @Override
    public List<ItemPropertyDTO> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        //b Return this
        List<ItemPropertyDTO> result = new ArrayList<>();

        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        //b The parent field name like "requirements", "properties", etc
        String parentKey = p.getParsingContext().getCurrentName();
        JsonNode nodeMayBeArray = mapper.readTree(p);

        //b Null
        if (nodeMayBeArray == null || nodeMayBeArray.isNull()) {
            return result;
        }
        //b Multiple Results
        else if (nodeMayBeArray.isArray()) {
            for (JsonNode node : nodeMayBeArray) {

                //b Assign ItemPropertyDTO fields automatically
                ItemPropertyDTO dto = mapper.treeToValue(node, ItemPropertyDTO.class);

                //b Get the pretty version of the property name from ParsingContext
                String propertyType = mapPropertyType(parentKey);
                dto.setPropertyType(propertyType);

                result.add(dto);
            }
        }
        //b One Result
        else if (nodeMayBeArray.isObject()) {
            ItemPropertyDTO dto = mapper.treeToValue(nodeMayBeArray, ItemPropertyDTO.class);
        }

        return result;
    }

    private String mapPropertyType(String parentKey) {
        String propertyType = switch (parentKey) {
            case "properties" -> "Properties";
            case "notable properties" -> "Notable Properties";
            case "requirements" -> "Requirements";
            case "additional properties" -> "Additional Properties";
            case "next level requirements" -> "Next Level Requirements";
            case "hybrid" -> "Hybrid";
            default -> "null";
        };
        return propertyType;
    }
}
