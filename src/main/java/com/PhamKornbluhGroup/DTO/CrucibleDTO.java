package com.PhamKornbluhGroup.DTO;

import java.util.HashMap;

public class CrucibleDTO {
    private int dbId;
    private int itemId;
    private String layout;                          // URL to an image of the tree layout
    private HashMap<String, CrucibleNodeDTO> nodes; // the key is the string value of the node index
}