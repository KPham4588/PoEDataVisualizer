package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import tools.jackson.core.JacksonException;

public class ItemPropertyValuesDeserializer extends tools.jackson.databind.ValueDeserializer<ItemPropertyValuesDTO> {

    public ItemPropertyValuesDeserializer() {
        this(null);
    }

    @Override
    public ItemPropertyValuesDTO deserialize(tools.jackson.core.JsonParser p, tools.jackson.databind.DeserializationContext ctxt) throws JacksonException {
        return null;
    }

    public ItemPropertyValuesDeserializer(Class<?> vc) {
        super();
    }

    /*
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
    */
}
