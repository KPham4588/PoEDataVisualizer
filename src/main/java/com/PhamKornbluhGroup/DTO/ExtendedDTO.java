package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ExtendedDTO {
    private int dbId;
    private int itemId;
    private String category;                 // Deprecated  // Optional
    private ArrayList<String> subcategories; // Deprecated  // Optional
    private long prefixes;                                  // Optional
    private long suffixes;                                  // Optional

    @Override
    public String toString() {
        return "ExtendedDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", category='" + category + '\'' +
                ", subcategories=" + subcategories +
                ", prefixes=" + prefixes +
                ", suffixes=" + suffixes +
                '}';
    }
}