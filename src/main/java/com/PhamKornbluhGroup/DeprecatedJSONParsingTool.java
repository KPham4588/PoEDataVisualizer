package com.PhamKornbluhGroup;

import java.util.HashSet;

public class DeprecatedJSONParsingTool {
    private HashSet<String> currentJsonFields = new HashSet<>();

    public void printElements() {
        for (String result : currentJsonFields) {
            System.out.println(result);
        }
    }
}
