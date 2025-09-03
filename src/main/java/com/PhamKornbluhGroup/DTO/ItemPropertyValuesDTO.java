package com.PhamKornbluhGroup.DTO;

public class ItemPropertyValuesDTO {
    private int dbId;
    private int itemPropertyId;
    private String value;   // Called "0" in Dev Docs
    private long valueType; // Called "1" in Dev Docs

    public ItemPropertyValuesDTO() {
    }
    public ItemPropertyValuesDTO(int dbId, int itemPropertyId, String value, long valueType) {
        this.dbId = dbId;
        this.itemPropertyId = itemPropertyId;
        this.value = value;
        this.valueType = valueType;
    }

    public long getValueType() {
        return valueType;
    }
    public void setValueType(long valueType) {
        this.valueType = valueType;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getItemPropertyId() {
        return itemPropertyId;
    }
    public void setItemPropertyId(int itemPropertyId) {
        this.itemPropertyId = itemPropertyId;
    }
    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    @Override
    public String toString() {
        return "ItemPropertyValuesDTO{" +
                "dbId=" + dbId +
                ", itemPropertyId=" + itemPropertyId +
                ", value='" + value + '\'' +
                ", valueType=" + valueType +
                '}';
    }
}