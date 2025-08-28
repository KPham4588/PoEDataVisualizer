package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class HybridDTO {
    private int dbId;
    private int itemId;
    private boolean isVaalGem;            // Optional
    private String baseTypeName;
    private ArrayList<ItemPropertyDTO> properties; // Optional
    private ArrayList<String> explicitMods;        // Optional
    private String secDescrText;          // Optional
}