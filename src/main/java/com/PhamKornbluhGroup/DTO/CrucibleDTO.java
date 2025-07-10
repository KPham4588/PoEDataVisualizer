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
}