package com.PhamKornbluhGroup.DTO;

public class CrucibleNodeDTO {
    private int dbId;
    private int crucibleId;
    private long skill;          // mod hash                                       // Optional
    private long tier;           // mod tier                                       // Optional
    private String icon;                                                           // Optional
    private boolean allocated;   // always true if present                         // Optional
    private boolean isNotable;   // always true if present                         // Optional
    private boolean isReward;    // always true if present                         // Optional
    private String stats;        // stat descriptions                              // Optional
    private String reminderText;                                                   // Optional
    private long orbit;          // the column this node occupies                  // Optional
    private long orbitIndex;     // the node's position within the column          // Optional
    private String out;          // node identifiers of nodes this one connects to
    private String in;           // node identifiers of nodes connected to this one
}