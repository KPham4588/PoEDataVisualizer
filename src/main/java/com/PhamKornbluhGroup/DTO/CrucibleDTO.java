package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class CrucibleDTO {
    private int dbId;
    private int itemId;
    private String layout;                          // URL to an image of the tree layout
    private ArrayList<CrucibleNodeDTO> nodes; // the key is the string value of the node index

    @Override
    public String toString() {
        return "CrucibleDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", layout='" + layout + '\'' +
                ", nodes=" + nodes +
                '}';
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

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public ArrayList<CrucibleNodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<CrucibleNodeDTO> nodes) {
        this.nodes = nodes;
    }
}

