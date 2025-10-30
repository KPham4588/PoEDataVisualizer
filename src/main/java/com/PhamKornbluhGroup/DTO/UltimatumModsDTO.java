package com.PhamKornbluhGroup.DTO;

public class UltimatumModsDTO {
    private int dbId;
    private int itemId;
    private String type; // text used to display ultimatum icons
    private long tier;

    public UltimatumModsDTO() {
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getTier() {
        return tier;
    }
    public void setTier(long tier) {
        this.tier = tier;
    }
}