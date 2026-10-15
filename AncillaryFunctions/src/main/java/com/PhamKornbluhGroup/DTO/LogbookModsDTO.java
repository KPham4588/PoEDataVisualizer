package com.PhamKornbluhGroup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class LogbookModsDTO {
    private int dbId;
    private int itemId;
    @JsonProperty("name")
    private String areaName;    // Called "name" in Dev Docs   // Description "area name" in Dev Docs
    private FactionDTO faction;
    private ArrayList<String> mods;

    public LogbookModsDTO() {
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
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public FactionDTO getFaction() {
        return faction;
    }
    public void setFaction(FactionDTO faction) {
        this.faction = faction;
    }
    public ArrayList<String> getMods() {
        return mods;
    }
    public void setMods(ArrayList<String> mods) {
        this.mods = mods;
    }

    @Override
    public String toString() {
        return "LogbookModsDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", areaName='" + areaName + '\'' +
                ", faction=" + faction +
                ", mods=" + mods +
                '}';
    }
}