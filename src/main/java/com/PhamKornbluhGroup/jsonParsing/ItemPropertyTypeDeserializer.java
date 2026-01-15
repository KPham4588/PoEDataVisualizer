package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemPropertyDTO;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ItemPropertyTypeDeserializer extends ValueDeserializer<List<ItemPropertyDTO>> {

    @Override
    public List<ItemPropertyDTO> deserialize(JsonParser p, DeserializationContext ctxt) {

        ObjectMapper mapper = (ObjectMapper) p.objectReadContext();

        JsonNode node = mapper.readTree(p);

        // TODO: see if this works in an equivalent way to p.getParsingContext.GetCurrentName()
        String parentKey = p.currentName();

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
