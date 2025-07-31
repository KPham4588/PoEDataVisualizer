package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ItemPropertyDTO {
    private int dbId;

    // this DTO is the child of two different DTOs,
    // so only one out of itemID and hybridID will be populated for an entry
    // and the other will be blank or filled with a default
    private int itemId;
    private int hybridId;
    private String name;
    private ArrayList<ItemPropertyValuesDTO> values;
    private DisplayMode displayMode;                        // Optional
    private double progress; // rounded to 2 decimal places // Optional
    private long type;                                      // Optional
    private String suffix;                                  // Optional
    private String icon;                                    // Optional
}