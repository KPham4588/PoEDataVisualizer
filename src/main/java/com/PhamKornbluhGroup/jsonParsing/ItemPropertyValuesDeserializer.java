package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;


public class ItemPropertyValuesDeserializer extends ValueDeserializer<ItemPropertyValuesDTO> {
    public ItemPropertyValuesDeserializer() {
        super();
    }

    @Override
    public ItemPropertyValuesDTO deserialize(JsonParser jp, DeserializationContext ctxt) {
        // node is an array: ["27-50", 0]
        JsonNode node = jp.objectReadContext().readTree(jp);

        String value = node.get(0).asText();
        long valueType = node.get(1).asLong();

        ItemPropertyValuesDTO propertyValuesDTO = new ItemPropertyValuesDTO();
        propertyValuesDTO.setValue(value);
        propertyValuesDTO.setValueType(valueType);
        return propertyValuesDTO;
    }
}