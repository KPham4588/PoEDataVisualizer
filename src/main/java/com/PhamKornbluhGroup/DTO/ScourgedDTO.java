package com.PhamKornbluhGroup.DTO;

public class ScourgedDTO {
    private int dbId;
    private int itemId;
    private long scourgedTier;     // Called "tier" in Dev Docs      // 1-3 for items, 1-10 for maps
    private long scourgedLevel;    // Called "level" in Dev Docs     // monster level required to progress  // Optional
    private long scourgedProgress; // Called "progress" in Dev Docs                                         // Optional
    private long scourgedTotal;    // Called "total" in Dev Docs                                            // Optional
}