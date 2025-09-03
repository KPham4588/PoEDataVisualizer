package com.PhamKornbluhGroup.DTO;

public class ItemSocketDTO {
    private int dbId;
    private int itemId;
    private long group;
    private String attr;    // PoE1 only; S, D, I, G, A, or DV    // Optional
    private String sColour; // PoE1 only; R, G, B, W, A, or DV    // Optional

    public ItemSocketDTO() {
    }
    public ItemSocketDTO(int dbId, int itemId, long group, String attr, String sColour) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.group = group;
        this.attr = attr;
        this.sColour = sColour;
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
    public long getGroup() {
        return group;
    }
    public void setGroup(long group) {
        this.group = group;
    }
    public String getAttr() {
        return attr;
    }
    public void setAttr(String attr) {
        this.attr = attr;
    }
    public String getsColour() {
        return sColour;
    }

    public void setsColour(String sColour) {
        this.sColour = sColour;
    }

    @Override
    public String toString() {
        return "ItemSocketDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", group=" + group +
                ", attr='" + attr + '\'' +
                ", sColour='" + sColour + '\'' +
                '}';
    }
}