package com.PhamKornbluhGroup.DTO2;

import java.util.HashMap;

public class CrucibleDTO {
    private String layout;                          // URL to an image of the tree layout
    private HashMap<String, CrucibleNodeDTO> nodes; // the key is the string value of the node index
}