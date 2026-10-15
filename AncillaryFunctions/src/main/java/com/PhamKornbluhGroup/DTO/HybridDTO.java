package com.PhamKornbluhGroup.DTO;

import com.PhamKornbluhGroup.jsonParsing.ItemPropertyTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

public class HybridDTO {
    private int dbId;
    private int itemId;
    @JsonProperty("isVaalGem")
    private boolean isVaalGem;            // Optional
    private String baseTypeName;
    @JsonDeserialize(using = ItemPropertyTypeDeserializer.class)
    private ArrayList<ItemPropertyDTO> properties; // Optional
    private ArrayList<String> explicitMods;        // Optional
    private String secDescrText;          // Optional

    public HybridDTO() {
        this.properties = new ArrayList<>();
        this.explicitMods = new ArrayList<>();
        this.secDescrText = "";
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
}
