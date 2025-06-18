package com.PhamKornbluhGroup.DTO;

public class HybridDTO {
    private int dbId;
    private int itemId;
    private boolean isVaalGem;            // Optional
    private String baseTypeName;
    private ItemPropertyDTO[] properties; // Optional
    private String[] explicitMods;        // Optional
    private String secDescrText;          // Optional
}