package com.PhamKornbluhGroup.DTO;

import com.PhamKornbluhGroup.jsonParsing.ItemPropertyValuesDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

public class ItemPropertyDTO {
    private int dbId;

    // this DTO is the child of two different DTOs,
    // so only one out of itemID and hybridID will be populated for an entry
    // and the other will be blank or filled with a default
    private int itemId;
    private int hybridId;
    private String name;
    @JsonDeserialize(contentUsing = ItemPropertyValuesDeserializer.class)
    private ArrayList<ItemPropertyValuesDTO> values;
    private DisplayMode displayMode;                        // Optional
    private double progress; // rounded to 2 decimal places // Optional
    private long type;                                      // Optional
    private String suffix;                                  // Optional
    private String icon;                                    // Optional
    private String propertyType; // This isn't in the documentation. We have this to avoid multiple ItemProperty tables

    public ItemPropertyDTO() {
    }
    public ItemPropertyDTO(int dbId, int itemId, int hybridId, String name, ArrayList<ItemPropertyValuesDTO> values,
                           DisplayMode displayMode, double progress, long type, String suffix, String icon,
                           String propertyType) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.hybridId = hybridId;
        this.name = name;
        this.values = values;
        this.displayMode = displayMode;
        this.progress = progress;
        this.type = type;
        this.suffix = suffix;
        this.icon = icon;
        this.propertyType = propertyType;
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
    public int getHybridId() {
        return hybridId;
    }
    public void setHybridId(int hybridId) {
        this.hybridId = hybridId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<ItemPropertyValuesDTO> getValues() {
        return values;
    }
    public void setValues(ArrayList<ItemPropertyValuesDTO> values) {
        this.values = values;
    }
    public DisplayMode getDisplayMode() {
        return displayMode;
    }
    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
    }
    public double getProgress() {
        return progress;
    }
    public void setProgress(double progress) {
        this.progress = progress;
    }
    public long getType() {
        return type;
    }
    public void setType(long type) {
        this.type = type;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "ItemPropertyDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", hybridId=" + hybridId +
                ", name='" + name + '\'' +
                ", values=" + values +
                ", displayMode=" + displayMode +
                ", progress=" + progress +
                ", type=" + type +
                ", suffix='" + suffix + '\'' +
                ", icon='" + icon + '\'' +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}