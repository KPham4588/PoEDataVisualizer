package com.PhamKornbluhGroup.DTO;

import java.util.HashMap;

public class RewardsDTO {
    private int dbId;
    private int itemId;
    private String label;
    private HashMap<String, Integer> rewards;
        // Key = A string representing the type of reward
        // Value = The amount
}