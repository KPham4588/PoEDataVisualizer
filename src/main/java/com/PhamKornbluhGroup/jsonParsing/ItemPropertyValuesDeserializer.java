package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ItemPropertyValuesDeserializer extends StdDeserializer<ItemPropertyValuesDTO> {

    public ItemPropertyValuesDeserializer() {
        this(null);
    }

    public ItemPropertyValuesDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ItemPropertyValuesDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        // node is an array: ["27-50", 0]
        JsonNode node = jp.getCodec().readTree(jp);

        String value = node.get(0).asText();
        long valueType = node.get(1).asLong();

        ItemPropertyValuesDTO propertyValuesDTO = new ItemPropertyValuesDTO();
        propertyValuesDTO.setValue(value);
        propertyValuesDTO.setValueType(valueType);
        return propertyValuesDTO;
    }

}
