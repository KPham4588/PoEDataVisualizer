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

        ObjectMapper mapper = (ObjectMapper) p.getCodec();

        JsonNode node = mapper.readTree(p);

        String parentKey = p.getParsingContext().getCurrentName();

        List<ItemPropertyDTO> list = new ArrayList<>();

        if (node.isArray()) {
            for (JsonNode child : node) {
                ItemPropertyDTO dto = mapper.treeToValue(child, ItemPropertyDTO.class);
                dto.setPropertyType(mapPropertyType(parentKey));
                list.add(dto);
            }
        } else if (node.isObject()) {
            ItemPropertyDTO dto = mapper.treeToValue(node, ItemPropertyDTO.class);
            dto.setPropertyType(mapPropertyType(parentKey));
            list.add(dto);
        }

        return list;
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
