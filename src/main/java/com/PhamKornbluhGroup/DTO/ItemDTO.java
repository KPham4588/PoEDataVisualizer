package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ItemDTO {
    private int dbId;
    private int publicStashChangeId;
    private int parentItemId;
    private boolean verified;
    private long w;
    private long h;
    private String icon;
    private boolean support;     // always true if present     // Optional
    private int stackSize;                                     // Optional
    private int maxStackSize;                                  // Optional
    private String stackSizeText;                              // Optional
    private String league;                                     // Optional
    private String id; // a unique 64 digit hexadecimal string // Optional
    private Object influences;                                 // Optional   //w WHAT IS GOING ON HERE //p Are other conqueror influences missing? Warlord? Redeemer? Hunter? Crusader?
    private boolean elder;       // always true if present     // Optional   //w Is this part of influences??
    private boolean shaper;      // always true if present     // Optional   //w Is this part of influences??
    private boolean searing;     // always true if present     // Optional   //w Is this part of influences??
    private boolean tangled;     // always true if present     // Optional   //w Is this part of influences??
    private boolean abyssJewel;  // always true if present     // Optional   //w Is this part of influences??
    private boolean delve;       // always true if present     // Optional   //w Is this part of influences??
    private boolean fractured;   // always true if present     // Optional   //w Is this part of influences??
    private boolean synthesised; // always true if present     // Optional   //w Is this part of influences??
    private ArrayList<ItemSocketDTO> sockets;                  // Optional
    private ArrayList<ItemDTO> socketedItems;                  // Optional
    private String name;
    private String typeLine;
    private String baseType;
    private String rarity;       // Normal, Magic, Rare, or Unique // Optional
    private boolean identified;
    private int itemLevel;       // used for items that always display their item level // Optional
    private int ilvl;
    private String note;             // user-generated text        // Optional
    private String forum_note;       // user-generated text        // Optional
    private boolean lockedToCharacter;                             // Optional
    private boolean lockedToAccount; // always true if present     // Optional
    private boolean duplicated;      // always true if present     // Optional
    private boolean split;           // always true if present     // Optional
    private boolean corrupted;       // always true if present     // Optional
    private boolean unmodifiable;    // always true if present     // Optional
    private boolean cisRaceReward;   // always true if present     // Optional
    private boolean seaRaceReward;   // always true if present     // Optional
    private boolean thRaceReward;    // always true if present     // Optional
    private ArrayList<ItemPropertyDTO> properties;                 // Optional
    private ArrayList<ItemPropertyDTO> notableProperties;          // Optional
    private ArrayList<ItemPropertyDTO> requirements;               // Optional
    private ArrayList<ItemPropertyDTO> additionalProperties;       // Optional
    private ArrayList<ItemPropertyDTO> nextLevelRequirements;      // Optional
    private int talismanTier;                                      // Optional
    private ArrayList<RewardsDTO> rewards;                         // Optional
    private String secDescrText;                                   // Optional
    private ArrayList<String> utilityMods;                         // Optional
    private ArrayList<LogbookModsDTO> logbookMods;                 // Optional
    private ArrayList<String> enchantMods;                         // Optional
    private ArrayList<String> scourgeMods;                         // Optional
    private ArrayList<String> implicitMods;                        // Optional
    private ArrayList<UltimatumModsDTO> ultimatumMods;             // Optional
    private ArrayList<String> explicitMods;                        // Optional
    private ArrayList<String> craftedMods;                         // Optional
    private ArrayList<String> fracturedMods;                                     // Optional
    private ArrayList<String> crucibleMods;  // only allocated mods are included // Optional
    private ArrayList<String> cosmeticMods;                                      // Optional
    private ArrayList<String> veiledMods;    // random video identifier          // Optional
    private boolean veiled;         // always true if present                    // Optional
    private ArrayList<String> descrText;                                         // Optional
    private ArrayList<String> flavourText;                                       // Optional
    private ArrayList<Object> flavourTextParsed; //p Can be either an array of Strings or Objects // Optional
    private String flavourTextNote; // user-generated text         // Optional
    private String prophecyText;                                   // Optional
    private boolean isRelic;        // always true if present      // Optional
    private int foilVariation;                                     // Optional
    private boolean replica;        // always true if present      // Optional
    private boolean foreseeing;     // always true if present      // Optional
    private IncubatedItemDTO incubatedItem;                        // Optional
    private ScourgedDTO scourged;                                  // Optional
    private CrucibleDTO crucible;                                  // Optional
    private boolean ruthless;       // always true if present      // Optional
    private FrameType frameType;                                   // Optional
    private String artFilename;                                    // Optional
    private HybridDTO hybrid;                                      // Optional
    private ExtendedDTO extended;   // only present in the Public Stash API   // Optional
    private long x;                                                // Optional
    private long y;                                                // Optional
    private String inventoryId;                                    // Optional
    private long socket;                                           // Optional
    private String colour;          // S, D, I, or G               // Optional
}