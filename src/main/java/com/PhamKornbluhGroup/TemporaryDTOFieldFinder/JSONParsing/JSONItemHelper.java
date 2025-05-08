package com.PhamKornbluhGroup.TemporaryDTOFieldFinder.JSONParsing;

import com.fasterxml.jackson.core.JsonToken;

import java.util.ArrayList;

class JSONItemHelper {
    private int index = -1;
    private ArrayList<String> elements = new ArrayList<>();

    JSONItemHelper() {
        for (int i = 0; i < 50; i++) {
            elements.add("");
        }
    }

    void handleToken(JsonToken token, String name) {
        switch (token) {
            //b JsonToken.START_OBJECT (Moving 1 layer deeper)
            case START_OBJECT -> {
                index++;
            }
            //b JsonToken.END_OBJECT (Moving 1 layer higher)
            case END_OBJECT -> {
                elements.set(index, "");
                index--;
            }
            //b Updating current level with new value
            case FIELD_NAME -> {
                elements.set(index, name);
            }
        }
    }

    String getFieldPath() {
        StringBuilder builder = new StringBuilder();

        builder.append(elements.get(0));
        for (int i = 1; i < elements.size(); i++) {
            String element = elements.get(i);

            if (!element.isBlank()) {
                builder.append(" --> ");
                builder.append(element);
            }
        }
        return builder.toString();
    }
}
