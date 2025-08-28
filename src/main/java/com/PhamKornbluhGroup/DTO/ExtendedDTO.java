package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ExtendedDTO {
    private int dbId;
    private int itemId;
    private String category;                 // Deprecated  // Optional
    private ArrayList<String> subcategories; // Deprecated  // Optional
    private long prefixes;                                  // Optional
    private long suffixes;                                  // Optional

    @Override
    public String toString() {
        return "ExtendedDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", category='" + category + '\'' +
                ", subcategories=" + subcategories +
                ", prefixes=" + prefixes +
                ", suffixes=" + suffixes +
                '}';
    }

    public ExtendedDTO() {
    }

    public ExtendedDTO(int dbId, int itemId, String category, ArrayList<String> subcategories, long prefixes, long suffixes) {
        this.dbId = dbId;
        this.itemId = itemId;
        this.category = category;
        this.subcategories = subcategories;
        this.prefixes = prefixes;
        this.suffixes = suffixes;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(ArrayList<String> subcategories) {
        this.subcategories = subcategories;
    }

    public long getPrefixes() {
        return prefixes;
    }

    public void setPrefixes(long prefixes) {
        this.prefixes = prefixes;
    }

    public long getSuffixes() {
        return suffixes;
    }

    public void setSuffixes(long suffixes) {
        this.suffixes = suffixes;
    }
}