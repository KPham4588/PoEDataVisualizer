package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtendedDTO {
    private int dbId;
    private int itemId;
    private String category;        // Deprecated   // Optional
    // this may need to become an Arraylist<String> to work
//    private String[] subcategories; // Deprecated   // Optional
    private ArrayList<String> subcategories; // Deprecated   // Optional
    private long prefixes;                          // Optional
    private long suffixes;                          // Optional

    @Override
    public String toString() {
        System.out.println("Subcategories coming below");
        for (String subcategories : subcategories) {
            System.out.println(subcategories);
        }
        System.out.println("End of subcategories");
        System.out.println();
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