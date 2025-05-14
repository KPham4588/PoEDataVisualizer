package com.PhamKornbluhGroup.DTO;

public class ItemPropertyDTO {
    private int dbID;

    // this DTO is the child of two different DTOs,
    // so only one out of itemID and hybridID will be populated for an entry
    // and the other will be blank or filled with a default
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