package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ItemDTO {
    private int dbId; // PK

    private String artFilename;         // Optional
    private String baseType;
    private String colour;              // Optional  // S, D, I, or G
    private String flavourTextNote;     // Optional  // user-generated text
    private String forum_note;          // Optional  // user-generated text
    private String icon;
    private String id;                  // Optional  // a unique 64 digit hexadecimal string
    private String inventoryId;         // Optional
    private String league;              // Optional
    private String name;
    private String note;                // Optional  // user-generated text
    private String prophecyText;        // Optional
    private String rarity;              // Optional  // Normal, Magic, Rare, or Unique
    private String secDescrText;        // Optional
    private String stackSizeText;       // Optional
    private String typeLine;
    private boolean abyssJewel;         // Optional  // always true if present    //w Is this part of influences??
    private boolean cisRaceReward;      // Optional  // always true if present
    private boolean corrupted;          // Optional  // always true if present
    private boolean delve;              // Optional  // always true if present    //w Is this part of influences??
    private boolean duplicated;         // Optional  // always true if present
    private boolean elder;              // Optional  // always true if present    //w Is this part of influences??
    private boolean foreseeing;         // Optional  // always true if present
    private boolean fractured;          // Optional  // always true if present    //w Is this part of influences??
    private boolean identified;
    private boolean isRelic;            // Optional  // always true if present
    private boolean lockedToAccount;    // Optional  // always true if present
    private boolean lockedToCharacter;  // Optional
    private boolean replica;            // Optional  // always true if present
    private boolean ruthless;           // Optional  // always true if present
    private boolean seaRaceReward;      // Optional  // always true if present
    private boolean searing;            // Optional  // always true if present   //w Is this part of influences??
    private boolean shaper;             // Optional  // always true if present   //w Is this part of influences??
    private boolean split;              // Optional  // always true if present
    private boolean support;            // Optional  // always true if present
    private boolean synthesised;        // Optional  // always true if present   //w Is this part of influences??
    private boolean tangled;            // Optional  // always true if present   //w Is this part of influences??
    private boolean thRaceReward;       // Optional  // always true if present
    private boolean unmodifiable;       // Optional  // always true if present
    private boolean veiled;             // Optional  // always true if present
    private boolean verified;
    private int foilVariation;          // Optional
    private int ilvl;
    private int itemLevel;              // Optional // used for items that always display their item level
    private int maxStackSize;           // Optional
    private int parentItemId;
    private int publicStashChangeId;
    private int stackSize;             // Optional
    private int talismanTier;          // Optional
    private long h;
    private long socket;               // Optional
    private long w;
    private long x;                    // Optional
    private long y;                    // Optional

    private CrucibleDTO crucible;            // Optional
    private ExtendedDTO extended;            // Optional  // only present in the Public Stash API
    private FrameType frameType;             // Optional
    private HybridDTO hybrid;                // Optional
    private IncubatedItemDTO incubatedItem;  // Optional
    private Object influences; // Optional   //w WHAT IS GOING ON HERE //p Are other conqueror influences missing? Warlord? Redeemer? Hunter? Crusader?
    private ScourgedDTO scourged;                                            // Optional

    // Sorted by type (and alphabetical)
    private ArrayList<String> cosmeticMods;   // Optional
    private ArrayList<String> craftedMods;    // Optional
    private ArrayList<String> crucibleMods;   // Optional  // only allocated mods are included
    private ArrayList<String> descrText;      // Optional
    private ArrayList<String> enchantMods;    // Optional
    private ArrayList<String> explicitMods;   // Optional
    private ArrayList<String> flavourText;    // Optional
    private ArrayList<String> fracturedMods;  // Optional
    private ArrayList<String> implicitMods;   // Optional
    private ArrayList<String> scourgeMods;    // Optional
    private ArrayList<String> utilityMods;    // Optional
    private ArrayList<String> veiledMods;     // Optional  // random video identifier

    // Complex Object List
    private ArrayList<ItemDTO> socketedItems;                  // Optional
    private ArrayList<ItemPropertyDTO> additionalProperties;   // Optional
    private ArrayList<ItemPropertyDTO> nextLevelRequirements;  // Optional
    private ArrayList<ItemPropertyDTO> notableProperties;      // Optional
    private ArrayList<ItemPropertyDTO> properties;             // Optional
    private ArrayList<ItemPropertyDTO> requirements;           // Optional
    private ArrayList<ItemSocketDTO> sockets;                  // Optional
    private ArrayList<LogbookModsDTO> logbookMods;             // Optional
    private ArrayList<Object> flavourTextParsed;               // Optional //p Can be either an array of Strings or Objects
    private ArrayList<RewardsDTO> rewards;                     // Optional
    private ArrayList<UltimatumModsDTO> ultimatumMods;         // Optional
}