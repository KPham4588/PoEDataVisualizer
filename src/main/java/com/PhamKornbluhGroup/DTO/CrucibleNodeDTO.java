package com.PhamKornbluhGroup.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CrucibleNodeDTO {
    private int dbId;
    private int crucibleId;
    private long skill;          // mod hash                                       // Optional
    private long tier;           // mod tier                                       // Optional
    private String icon;                                                           // Optional
    private boolean allocated;   // always true if present                         // Optional
    @JsonProperty("isNotable")
    private boolean isNotable;   // always true if present                         // Optional
    @JsonProperty("isReward")
    private boolean isReward;    // always true if present                         // Optional
    private String reminderText;                                                   // Optional
    private long orbit;          // the column this node occupies                  // Optional
    private long orbitIndex;     // the node's position within the column          // Optional
    private String crucibleNodeIndex; // In documentation, this is the key for the "nodes" hashmap, and is the string value of the node index
    private ArrayList<String> out;          // node identifiers of nodes this one connects to
    private ArrayList<String> in;           // node identifiers of nodes connected to this one
    private ArrayList<String> stats;  // stat descriptions                         // Optional

    public CrucibleNodeDTO() {
    }

    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    public int getCrucibleId() {
        return crucibleId;
    }
    public void setCrucibleId(int crucibleId) {
        this.crucibleId = crucibleId;
    }
    public long getSkill() {
        return skill;
    }
    public void setSkill(long skill) {
        this.skill = skill;
    }
    public long getTier() {
        return tier;
    }
    public void setTier(long tier) {
        this.tier = tier;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public boolean isAllocated() {
        return allocated;
    }
    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }
    public boolean isNotable() {
        return isNotable;
    }
    public void setNotable(boolean notable) {
        isNotable = notable;
    }
    public boolean isReward() {
        return isReward;
    }
    public void setReward(boolean reward) {
        isReward = reward;
    }
    public String getReminderText() {
        return reminderText;
    }
    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }
    public long getOrbit() {
        return orbit;
    }
    public void setOrbit(long orbit) {
        this.orbit = orbit;
    }
    public long getOrbitIndex() {
        return orbitIndex;
    }
    public void setOrbitIndex(long orbitIndex) {
        this.orbitIndex = orbitIndex;
    }
    public String getCrucibleNodeIndex() {
        return crucibleNodeIndex;
    }
    public void setCrucibleNodeIndex(String crucibleNodeIndex) {
        this.crucibleNodeIndex = crucibleNodeIndex;
    }
    public ArrayList<String> getOut() {
        return out;
    }
    public void setOut(ArrayList<String> out) {
        this.out = out;
    }
    public ArrayList<String> getIn() {
        return in;
    }
    public void setIn(ArrayList<String> in) {
        this.in = in;
    }
    public ArrayList<String> getStats() {
        return stats;
    }
    public void setStats(ArrayList<String> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "CrucibleNodeDTO{" +
                "dbId=" + dbId +
                ", crucibleId=" + crucibleId +
                ", skill=" + skill +
                ", tier=" + tier +
                ", icon='" + icon + '\'' +
                ", allocated=" + allocated +
                ", isNotable=" + isNotable +
                ", isReward=" + isReward +
                ", reminderText='" + reminderText + '\'' +
                ", orbit=" + orbit +
                ", orbitIndex=" + orbitIndex +
                ", out='" + out + '\'' +
                ", in='" + in + '\'' +
                ", crucibleNodeIndex='" + crucibleNodeIndex + '\'' +
                ", stats=" + stats +
                '}';
    }
}