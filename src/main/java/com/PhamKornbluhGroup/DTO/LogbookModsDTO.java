package com.PhamKornbluhGroup.DTO;

import java.util.Arrays;

public class LogbookModsDTO {
    private int dbId;
    private int itemId;
    private String areaName;    // Called "name" in Dev Docs   // Description "area name" in Dev Docs
    private FactionDTO faction;
    private String[] mods;

    public LogbookModsDTO() {
    }
    public LogbookModsDTO(int dbId, int itemId, String areaName, FactionDTO faction, String[] mods) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.areaName = areaName;
        this.faction = faction;
        this.mods = mods;
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
    public String[] getMods() {
        return mods;
    }
    public void setMods(String[] mods) {
        this.mods = mods;
    }

    @Override
    public String toString() {
        return "LogbookModsDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", areaName='" + areaName + '\'' +
                ", faction=" + faction +
                ", mods=" + Arrays.toString(mods) +
                '}';
    }
}