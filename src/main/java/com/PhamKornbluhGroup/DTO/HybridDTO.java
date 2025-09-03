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

    public HybridDTO() {
    }
    public HybridDTO(int dbId, int itemId, boolean isVaalGem, String baseTypeName, ArrayList<ItemPropertyDTO> properties, ArrayList<String> explicitMods, String secDescrText) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.isVaalGem = isVaalGem;
        this.baseTypeName = baseTypeName;
        this.properties = properties;
        this.explicitMods = explicitMods;
        this.secDescrText = secDescrText;
    }

    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public boolean isVaalGem() {
        return isVaalGem;
    }
    public void setVaalGem(boolean vaalGem) {
        isVaalGem = vaalGem;
    }
    public String getBaseTypeName() {
        return baseTypeName;
    }
    public void setBaseTypeName(String baseTypeName) {
        this.baseTypeName = baseTypeName;
    }
    public ArrayList<ItemPropertyDTO> getProperties() {
        return properties;
    }
    public void setProperties(ArrayList<ItemPropertyDTO> properties) {
        this.properties = properties;
    }
    public ArrayList<String> getExplicitMods() {
        return explicitMods;
    }
    public void setExplicitMods(ArrayList<String> explicitMods) {
        this.explicitMods = explicitMods;
    }
    public String getSecDescrText() {
        return secDescrText;
    }
    public void setSecDescrText(String secDescrText) {
        this.secDescrText = secDescrText;
    }

    @Override
    public String toString() {
        return "HybridDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", isVaalGem=" + isVaalGem +
                ", baseTypeName='" + baseTypeName + '\'' +
                ", properties=" + properties +
                ", explicitMods=" + explicitMods +
                ", secDescrText='" + secDescrText + '\'' +
                '}';
    }
}