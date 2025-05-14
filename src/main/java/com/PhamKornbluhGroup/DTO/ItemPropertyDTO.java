package com.PhamKornbluhGroup.DTO;

public class ItemPropertyDTO {
    private int dbID;
    private int itemID;
    private int hybridID;
    private String name;
    private ItemPropertyValuesDTO[] values;
    private DisplayMode displayMode;                        // Optional
    private double progress; // rounded to 2 decimal places // Optional
    private long type;                                      // Optional
    private String suffix;                                  // Optional
    private String icon;                                    // Optional
}