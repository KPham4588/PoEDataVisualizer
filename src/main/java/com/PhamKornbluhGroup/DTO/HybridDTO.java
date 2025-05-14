package com.PhamKornbluhGroup.DTO;

public class HybridDTO {
    private int dbID;
    private int itemID;
    private boolean isVaalGem;            // Optional
    private String baseTypeName;
    private ItemPropertyDTO[] properties; // Optional
    private String[] explicitMods;        // Optional
    private String secDescrText;          // Optional
}