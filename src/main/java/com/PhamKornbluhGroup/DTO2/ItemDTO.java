package com.PhamKornbluhGroup.DTO2;

import java.util.HashMap;

public class ItemDTO {
    private boolean verified;
    private long w;
    private long h;
    private String icon;
    private boolean support; // always true if present // Nullable
    private int stackSize; // Nullable
    private int maxStackSize; // Nullable
    private String stackSizeText; // Nullable
    private String league; // Nullable
    private String id; // a unique 64 digit hexadecimal string // Nullable
    private Object influences; // Nullable                             //w WHAT IS GOING ON HERE //r Are other influences missing? Conq? Warlord?
    private boolean elder; // always true if present // Nullable           //w Is this part of influences??
    private boolean shaper; // always true if present // Nullable          //w Is this part of influences??
    private boolean searing; // always true if present // Nullable         //w Is this part of influences??
    private boolean tangled; // always true if present // Nullable         //w Is this part of influences??
    private boolean abyssJewel; // always true if present // Nullable      //w Is this part of influences??
    private boolean delve; // always true if present // Nullable           //w Is this part of influences??
    private boolean fractured; // always true if present // Nullable       //w Is this part of influences??
    private boolean synthesised; // always true if present // Nullable     //w Is this part of influences??
    private ItemSocketDTO[] sockets; // Nullable
    private ItemDTO[] socketedItems; // Nullable
    private String name;
    private String typeLine;
    private String baseType;
    private String rarity;// Normal, Magic, Rare, or Unique // Nullable
    private boolean identified;
    private int itemLevel; // used for items that always display their item level // Nullable
    private int ilvl;
    private String note; // user-generated text // Nullable
    private String forum_note; // user-generated text // Nullable
    private boolean lockedToCharacter; // Nullable
    private boolean lockedToAccount; // always true if present // Nullable
    private boolean duplicated; // always true if present // Nullable
    private boolean split; // always true if present // Nullable
    private boolean corrupted; // always true if present // Nullable
    private boolean unmodifiable; // always true if present // Nullable
    private boolean cisRaceReward; // always true if present // Nullable
    private boolean seaRaceReward; // always true if present // Nullable
    private boolean thRaceReward; // always true if present // Nullable
    private ItemPropertyDTO[] properties; // Nullable
    private ItemPropertyDTO[] notableProperties; // Nullable
    private ItemPropertyDTO[] requirements; // Nullable
    private ItemPropertyDTO[] additionalProperties; // Nullable
    private ItemPropertyDTO[] nextLevelRequirements; // Nullable
    private int talismanTier; // Nullable
    private Object[] rewards; // Nullable                                          //w Create a RewardsDTO -- Parent RewardsDTO
    private String label;                                                              //b Field
    private HashMap<String, Integer> rewardsMap; //b Called rewards in Dev Docs // the key is a string representing the type of reward. The value is the amount //b Field
    private String secDescrText; // Nullable
    private String[] utilityMods; // Nullable
    private Object[] logbookMods; // Nullable                                                      //w LogbookModsDTO
    private String areaName; // Called name in Dev Docs                                                //b Field
    private Object faction;                                                                            //b Field //w FactionDTO
    private String factionId; // Called faction in Dev Docs - Faction1, Faction2, Faction3, or Faction4              //p Sub-Field
    private String factionName; // Called name in Dev Docs                                                           //p Sub-Field
    private String[] mods;                                                                             //b Field
    private String[] enchantMods; // Nullable
    private String[] scourgeMods; // Nullable
    private String[] implicitMods; // Nullable
    private Object[] ultimatumMods; // Nullable                  //w UltimatumDTO
    private String type; // text used to display ultimatum icons     //b Field
    private long tier;                                               //b Field
    private String[] explicitMods; // Nullable
    private String[] craftedMods; // Nullable
    private String[] fracturedMods; // Nullable
    private String[] crucibleMods; // only allocated mods are included // Nullable
    private String[] cosmeticMods; // Nullable
    private String[] veiledMods; // random video identifier // Nullable
    private boolean veiled; // always true if present // Nullable
    private String descrText; // Nullable
    private String[] flavourText; // Nullable
    private Object[] flavourTextParsed; // Can be either an array of Strings or Objects // Nullable
    private String flavourTextNote; // user-generated text // Nullable
    private String prophecyText; // Nullable
    private boolean isRelic; // always true if present // Nullable
    private int foilVariation; // Nullable
    private boolean replica; // always true if present // Nullable
    private boolean foreseeing; // always true if present // Nullable
    private Object incubatedItem; // Nullable                                                        //w IncubatedItemDTO
    private String incubatedItemName; // Called name in Dev Docs                                       //b Field
    private long incubatedItemLevel; // called level in Dev Docs // monster level required to progress //b Field
    private long progress;                                                                             //b Field
    private long total;                                                                                //b Field
    private Object scourged; // Nullable                                                                              //w ScourgedDTO
    private long scourgedTier; // Not "scourged" in Dev Docs Name // 1-3 for items, 1-10 for maps                         //b Field
    private long scourgedLevel; // Not "scourged" in Dev Docs Name // monster level required to progress // Nullable      //b Field
    private long scourgedProgress; // Not "scourged" in Dev Docs Name // Nullable                                         //b Field
    private long scourgedTotal; // Not "scourged" in Dev Docs Name // Nullable                                            //b Field
    private Object crucible; // Nullable                                                                 //w CrucibleDTO
    private String layout; // URL to an image of the tree layout                                             //b Field
    private HashMap<String, CrucibleNodeDTO> nodes; // the key is the string value of the node index         //b Field
    private boolean ruthless; // always true if present // Nullable
    private FrameType frameType; // Nullable
    private String artFilename; // Nullable
    private Object hybrid; // Nullable                                                              //w HybridDTO
    private boolean isVaalGem; // Nullable                                                              //b Field
    private String baseTypeName;                                                                        //b Field
    private ItemPropertyDTO[] properties; // Nullable                                                   //b Field
    private String[] explicitMods; // Nullable                                                          //b Field
    private String secDescrText; // Nullable                                                            //b Field
    private Object extended; // only present in the Public Stash API //Nullable   //w ExtendedDTO
    private long prefixes; // Nullable                                                //b Field
    private long suffixes; // Nullable                                                //b Field
    private long x; // Nullable
    private long y; // Nullable
    private String inventoryId; // Nullable
    private long socket; // Nullable
    private String colour; // S, D, I, or G // Nullable
}
