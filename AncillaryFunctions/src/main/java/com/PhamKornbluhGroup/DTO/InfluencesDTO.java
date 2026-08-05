package com.PhamKornbluhGroup.DTO;

public class InfluencesDTO {
    private int dbId;
    private int itemId;
    private boolean crusader; // optional
    private boolean shaper;   // optional
    private boolean elder;    // optional
    private boolean hunter;   // optional
    private boolean redeemer; // optional
    private boolean warlord;  // optional

    public InfluencesDTO() {
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
    public boolean isShaper() {
        return shaper;
    }
    public void setShaper(boolean shaper) {
        this.shaper = shaper;
    }
    public boolean isElder() {
        return elder;
    }
    public void setElder(boolean elder) {
        this.elder = elder;
    }
    public boolean isHunter() {
        return hunter;
    }
    public void setHunter(boolean hunter) {
        this.hunter = hunter;
    }
    public boolean isCrusader() {
        return crusader;
    }
    public void setCrusader(boolean crusader) {
        this.crusader = crusader;
    }
    public boolean isRedeemer() {
        return redeemer;
    }
    public void setRedeemer(boolean redeemer) {
        this.redeemer = redeemer;
    }
    public boolean isWarlord() {
        return warlord;
    }
    public void setWarlord(boolean warlord) {
        this.warlord = warlord;
    }

    @Override
    public String toString() {
        return "InfluencesDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", shaper=" + shaper +
                ", elder=" + elder +
                ", hunter=" + hunter +
                ", crusader=" + crusader +
                ", redeemer=" + redeemer +
                ", warlord=" + warlord +
                '}';
    }
}
