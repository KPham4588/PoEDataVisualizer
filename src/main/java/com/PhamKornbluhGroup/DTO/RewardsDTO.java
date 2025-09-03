package com.PhamKornbluhGroup.DTO;

import java.util.HashMap;

public class RewardsDTO {
    private int dbId;
    private int itemId;
    private String label;
    private HashMap<String, Integer> rewards;
        // Key = A string representing the type of reward
        // Value = The amount

    public RewardsDTO() {
    }
    public RewardsDTO(int dbId, int itemId, String label, HashMap<String, Integer> rewards) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.label = label;
        this.rewards = rewards;
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
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public HashMap<String, Integer> getRewards() {
        return rewards;
    }
    public void setRewards(HashMap<String, Integer> rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "RewardsDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", label='" + label + '\'' +
                ", rewards=" + rewards +
                '}';
    }
}