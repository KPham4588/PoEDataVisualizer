package com.PhamKornbluhGroup.DTO;

import java.util.Arrays;

public class ExtendedDTO {
    private int dbId;
    private int itemId;
    private String category;        // Deprecated   // Optional
    // this may need to become an Arraylist<String> to work
    private String[] subcategories; // Deprecated   // Optional
    private long prefixes;                          // Optional
    private long suffixes;                          // Optional

    @Override
    public String toString() {
        return "ExtendedDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", category='" + category + '\'' +
                ", subcategories=" + Arrays.toString(subcategories) +
                ", prefixes=" + prefixes +
                ", suffixes=" + suffixes +
                '}';
    }
}