package com.PhamKornbluhGroup.DTO;

import java.util.HashMap;

public class CrucibleDTO {
    private int dbId;
    private int itemId;
    private String layout;                          // URL to an image of the tree layout
//    private HashMap<String, CrucibleNodeDTO> nodes; // the key is the string value of the node index

    //p Temporarily simplifying things for ResultMap creation by pretending each CrucibleDTO
    //p has a single CrucibleNodeDTO attached
    private CrucibleNodeDTO node;

    @Override
    public String toString() {
        return "CrucibleDTO{" +
                "dbId=" + dbId +
                ", itemId=" + itemId +
                ", layout='" + layout + '\'' +
                ", node=" + node +
                '}';
    }
}