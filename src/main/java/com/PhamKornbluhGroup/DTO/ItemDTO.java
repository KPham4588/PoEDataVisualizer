package com.PhamKornbluhGroup.DTO;

import java.util.ArrayList;

public class ItemDTO {
    private int dbId; // PK

    private String artFilename;         // Optional
    private String baseType;
    private String colour;              // Optional  // S, D, I, or G
    private String descrText;           // Optional
    private String flavourTextNote;     // Optional  // user-generated text
    //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
    //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
    //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
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

    public ItemDTO() {
    }

    public ItemDTO(int dbId, String artFilename, String baseType, String colour, String descrText,
                   String flavourTextNote, String forum_note, String icon, String id, String inventoryId, String league,
                   String name, String note, String prophecyText, String rarity, String secDescrText,
                   String stackSizeText, String typeLine, boolean abyssJewel, boolean cisRaceReward, boolean corrupted,
                   boolean delve, boolean duplicated, boolean elder, boolean foreseeing, boolean fractured,
                   boolean identified, boolean isRelic, boolean lockedToAccount, boolean lockedToCharacter,
                   boolean replica, boolean ruthless, boolean seaRaceReward, boolean searing, boolean shaper,
                   boolean split, boolean support, boolean synthesised, boolean tangled, boolean thRaceReward,
                   boolean unmodifiable, boolean veiled, boolean verified, int foilVariation, int ilvl, int itemLevel,
                   int maxStackSize, int parentItemId, int publicStashChangeId, int stackSize, int talismanTier, long h,
                   long socket, long w, long x, long y, CrucibleDTO crucible, ExtendedDTO extended, FrameType frameType,
                   HybridDTO hybrid, IncubatedItemDTO incubatedItem, Object influences, ScourgedDTO scourged,
                   ArrayList<String> cosmeticMods, ArrayList<String> craftedMods, ArrayList<String> crucibleMods,
                   ArrayList<String> enchantMods, ArrayList<String> explicitMods, ArrayList<String> flavourText,
                   ArrayList<String> fracturedMods, ArrayList<String> implicitMods, ArrayList<String> scourgeMods,
                   ArrayList<String> utilityMods, ArrayList<String> veiledMods, ArrayList<ItemDTO> socketedItems,
                   ArrayList<ItemPropertyDTO> additionalProperties, ArrayList<ItemPropertyDTO> nextLevelRequirements,
                   ArrayList<ItemPropertyDTO> notableProperties, ArrayList<ItemPropertyDTO> properties,
                   ArrayList<ItemPropertyDTO> requirements, ArrayList<ItemSocketDTO> sockets,
                   ArrayList<LogbookModsDTO> logbookMods, ArrayList<Object> flavourTextParsed,
                   ArrayList<RewardsDTO> rewards, ArrayList<UltimatumModsDTO> ultimatumMods) {
        this.dbId = dbId;
        this.artFilename = artFilename;
        this.baseType = baseType;
        this.colour = colour;
        this.descrText = descrText;
        this.flavourTextNote = flavourTextNote;
        this.forum_note = forum_note;
        this.icon = icon;
        this.id = id;
        this.inventoryId = inventoryId;
        this.league = league;
        this.name = name;
        this.note = note;
        this.prophecyText = prophecyText;
        this.rarity = rarity;
        this.secDescrText = secDescrText;
        this.stackSizeText = stackSizeText;
        this.typeLine = typeLine;
        this.abyssJewel = abyssJewel;
        this.cisRaceReward = cisRaceReward;
        this.corrupted = corrupted;
        this.delve = delve;
        this.duplicated = duplicated;
        this.elder = elder;
        this.foreseeing = foreseeing;
        this.fractured = fractured;
        this.identified = identified;
        this.isRelic = isRelic;
        this.lockedToAccount = lockedToAccount;
        this.lockedToCharacter = lockedToCharacter;
        this.replica = replica;
        this.ruthless = ruthless;
        this.seaRaceReward = seaRaceReward;
        this.searing = searing;
        this.shaper = shaper;
        this.split = split;
        this.support = support;
        this.synthesised = synthesised;
        this.tangled = tangled;
        this.thRaceReward = thRaceReward;
        this.unmodifiable = unmodifiable;
        this.veiled = veiled;
        this.verified = verified;
        this.foilVariation = foilVariation;
        this.ilvl = ilvl;
        this.itemLevel = itemLevel;
        this.maxStackSize = maxStackSize;
        this.parentItemId = parentItemId;
        this.publicStashChangeId = publicStashChangeId;
        this.stackSize = stackSize;
        this.talismanTier = talismanTier;
        this.h = h;
        this.socket = socket;
        this.w = w;
        this.x = x;
        this.y = y;
        this.crucible = crucible;
        this.extended = extended;
        this.frameType = frameType;
        this.hybrid = hybrid;
        this.incubatedItem = incubatedItem;
        this.influences = influences;
        this.scourged = scourged;
        this.cosmeticMods = cosmeticMods;
        this.craftedMods = craftedMods;
        this.crucibleMods = crucibleMods;
        this.enchantMods = enchantMods;
        this.explicitMods = explicitMods;
        this.flavourText = flavourText;
        this.fracturedMods = fracturedMods;
        this.implicitMods = implicitMods;
        this.scourgeMods = scourgeMods;
        this.utilityMods = utilityMods;
        this.veiledMods = veiledMods;
        this.socketedItems = socketedItems;
        this.additionalProperties = additionalProperties;
        this.nextLevelRequirements = nextLevelRequirements;
        this.notableProperties = notableProperties;
        this.properties = properties;
        this.requirements = requirements;
        this.sockets = sockets;
        this.logbookMods = logbookMods;
        this.flavourTextParsed = flavourTextParsed;
        this.rewards = rewards;
        this.ultimatumMods = ultimatumMods;
    }

    public int getDbId() {
        return dbId;
    }
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    public String getArtFilename() {
        return artFilename;
    }
    public void setArtFilename(String artFilename) {
        this.artFilename = artFilename;
    }
    public String getBaseType() {
        return baseType;
    }
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getDescrText() {
        return descrText;
    }
    public void setDescrText(String descrText) {
        this.descrText = descrText;
    }
    public String getFlavourTextNote() {
        return flavourTextNote;
    }
    public void setFlavourTextNote(String flavourTextNote) {
        this.flavourTextNote = flavourTextNote;
    }
    public String getForum_note() {
        return forum_note;
    }
    public void setForum_note(String forum_note) {
        this.forum_note = forum_note;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getLeague() {
        return league;
    }
    public void setLeague(String league) {
        this.league = league;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getProphecyText() {
        return prophecyText;
    }
    public void setProphecyText(String prophecyText) {
        this.prophecyText = prophecyText;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getSecDescrText() {
        return secDescrText;
    }
    public void setSecDescrText(String secDescrText) {
        this.secDescrText = secDescrText;
    }
    public String getStackSizeText() {
        return stackSizeText;
    }
    public void setStackSizeText(String stackSizeText) {
        this.stackSizeText = stackSizeText;
    }
    public String getTypeLine() {
        return typeLine;
    }
    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }
    public boolean isAbyssJewel() {
        return abyssJewel;
    }
    public void setAbyssJewel(boolean abyssJewel) {
        this.abyssJewel = abyssJewel;
    }
    public boolean isCisRaceReward() {
        return cisRaceReward;
    }
    public void setCisRaceReward(boolean cisRaceReward) {
        this.cisRaceReward = cisRaceReward;
    }
    public boolean isCorrupted() {
        return corrupted;
    }
    public void setCorrupted(boolean corrupted) {
        this.corrupted = corrupted;
    }
    public boolean isDelve() {
        return delve;
    }
    public void setDelve(boolean delve) {
        this.delve = delve;
    }
    public boolean isDuplicated() {
        return duplicated;
    }
    public void setDuplicated(boolean duplicated) {
        this.duplicated = duplicated;
    }
    public boolean isElder() {
        return elder;
    }
    public void setElder(boolean elder) {
        this.elder = elder;
    }
    public boolean isForeseeing() {
        return foreseeing;
    }
    public void setForeseeing(boolean foreseeing) {
        this.foreseeing = foreseeing;
    }
    public boolean isFractured() {
        return fractured;
    }
    public void setFractured(boolean fractured) {
        this.fractured = fractured;
    }
    public boolean isIdentified() {
        return identified;
    }
    public void setIdentified(boolean identified) {
        this.identified = identified;
    }
    public boolean isRelic() {
        return isRelic;
    }
    public void setRelic(boolean relic) {
        isRelic = relic;
    }
    public boolean isLockedToAccount() {
        return lockedToAccount;
    }
    public void setLockedToAccount(boolean lockedToAccount) {
        this.lockedToAccount = lockedToAccount;
    }
    public boolean isLockedToCharacter() {
        return lockedToCharacter;
    }
    public void setLockedToCharacter(boolean lockedToCharacter) {
        this.lockedToCharacter = lockedToCharacter;
    }
    public boolean isReplica() {
        return replica;
    }
    public void setReplica(boolean replica) {
        this.replica = replica;
    }
    public boolean isRuthless() {
        return ruthless;
    }
    public void setRuthless(boolean ruthless) {
        this.ruthless = ruthless;
    }
    public boolean isSeaRaceReward() {
        return seaRaceReward;
    }
    public void setSeaRaceReward(boolean seaRaceReward) {
        this.seaRaceReward = seaRaceReward;
    }
    public boolean isSearing() {
        return searing;
    }
    public void setSearing(boolean searing) {
        this.searing = searing;
    }
    public boolean isShaper() {
        return shaper;
    }
    public void setShaper(boolean shaper) {
        this.shaper = shaper;
    }
    public boolean isSplit() {
        return split;
    }
    public void setSplit(boolean split) {
        this.split = split;
    }
    public boolean isSupport() {
        return support;
    }
    public void setSupport(boolean support) {
        this.support = support;
    }
    public boolean isSynthesised() {
        return synthesised;
    }
    public void setSynthesised(boolean synthesised) {
        this.synthesised = synthesised;
    }
    public boolean isTangled() {
        return tangled;
    }
    public void setTangled(boolean tangled) {
        this.tangled = tangled;
    }
    public boolean isThRaceReward() {
        return thRaceReward;
    }
    public void setThRaceReward(boolean thRaceReward) {
        this.thRaceReward = thRaceReward;
    }
    public boolean isUnmodifiable() {
        return unmodifiable;
    }
    public void setUnmodifiable(boolean unmodifiable) {
        this.unmodifiable = unmodifiable;
    }
    public boolean isVeiled() {
        return veiled;
    }
    public void setVeiled(boolean veiled) {
        this.veiled = veiled;
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public int getFoilVariation() {
        return foilVariation;
    }
    public void setFoilVariation(int foilVariation) {
        this.foilVariation = foilVariation;
    }
    public int getIlvl() {
        return ilvl;
    }
    public void setIlvl(int ilvl) {
        this.ilvl = ilvl;
    }
    public int getItemLevel() {
        return itemLevel;
    }
    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }
    public int getMaxStackSize() {
        return maxStackSize;
    }
    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }
    public int getParentItemId() {
        return parentItemId;
    }
    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }
    public int getPublicStashChangeId() {
        return publicStashChangeId;
    }
    public void setPublicStashChangeId(int publicStashChangeId) {
        this.publicStashChangeId = publicStashChangeId;
    }
    public int getStackSize() {
        return stackSize;
    }
    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }
    public int getTalismanTier() {
        return talismanTier;
    }
    public void setTalismanTier(int talismanTier) {
        this.talismanTier = talismanTier;
    }
    public long getH() {
        return h;
    }
    public void setH(long h) {
        this.h = h;
    }
    public long getSocket() {
        return socket;
    }
    public void setSocket(long socket) {
        this.socket = socket;
    }
    public long getW() {
        return w;
    }
    public void setW(long w) {
        this.w = w;
    }
    public long getX() {
        return x;
    }
    public void setX(long x) {
        this.x = x;
    }
    public long getY() {
        return y;
    }
    public void setY(long y) {
        this.y = y;
    }
    public CrucibleDTO getCrucible() {
        return crucible;
    }
    public void setCrucible(CrucibleDTO crucible) {
        this.crucible = crucible;
    }
    public ExtendedDTO getExtended() {
        return extended;
    }
    public void setExtended(ExtendedDTO extended) {
        this.extended = extended;
    }
    public FrameType getFrameType() {
        return frameType;
    }
    public void setFrameType(FrameType frameType) {
        this.frameType = frameType;
    }
    public HybridDTO getHybrid() {
        return hybrid;
    }
    public void setHybrid(HybridDTO hybrid) {
        this.hybrid = hybrid;
    }
    public IncubatedItemDTO getIncubatedItem() {
        return incubatedItem;
    }
    public void setIncubatedItem(IncubatedItemDTO incubatedItem) {
        this.incubatedItem = incubatedItem;
    }
    public Object getInfluences() {
        return influences;
    }
    public void setInfluences(Object influences) {
        this.influences = influences;
    }
    public ScourgedDTO getScourged() {
        return scourged;
    }
    public void setScourged(ScourgedDTO scourged) {
        this.scourged = scourged;
    }
    public ArrayList<String> getCosmeticMods() {
        return cosmeticMods;
    }
    public void setCosmeticMods(ArrayList<String> cosmeticMods) {
        this.cosmeticMods = cosmeticMods;
    }
    public ArrayList<String> getCraftedMods() {
        return craftedMods;
    }
    public void setCraftedMods(ArrayList<String> craftedMods) {
        this.craftedMods = craftedMods;
    }
    public ArrayList<String> getCrucibleMods() {
        return crucibleMods;
    }
    public void setCrucibleMods(ArrayList<String> crucibleMods) {
        this.crucibleMods = crucibleMods;
    }
    public ArrayList<String> getEnchantMods() {
        return enchantMods;
    }
    public void setEnchantMods(ArrayList<String> enchantMods) {
        this.enchantMods = enchantMods;
    }
    public ArrayList<String> getExplicitMods() {
        return explicitMods;
    }
    public void setExplicitMods(ArrayList<String> explicitMods) {
        this.explicitMods = explicitMods;
    }
    public ArrayList<String> getFlavourText() {
        return flavourText;
    }
    public void setFlavourText(ArrayList<String> flavourText) {
        this.flavourText = flavourText;
    }
    public ArrayList<String> getFracturedMods() {
        return fracturedMods;
    }
    public void setFracturedMods(ArrayList<String> fracturedMods) {
        this.fracturedMods = fracturedMods;
    }
    public ArrayList<String> getImplicitMods() {
        return implicitMods;
    }
    public void setImplicitMods(ArrayList<String> implicitMods) {
        this.implicitMods = implicitMods;
    }
    public ArrayList<String> getScourgeMods() {
        return scourgeMods;
    }
    public void setScourgeMods(ArrayList<String> scourgeMods) {
        this.scourgeMods = scourgeMods;
    }
    public ArrayList<String> getUtilityMods() {
        return utilityMods;
    }
    public void setUtilityMods(ArrayList<String> utilityMods) {
        this.utilityMods = utilityMods;
    }
    public ArrayList<String> getVeiledMods() {
        return veiledMods;
    }
    public void setVeiledMods(ArrayList<String> veiledMods) {
        this.veiledMods = veiledMods;
    }
    public ArrayList<ItemDTO> getSocketedItems() {
        return socketedItems;
    }
    public void setSocketedItems(ArrayList<ItemDTO> socketedItems) {
        this.socketedItems = socketedItems;
    }
    public ArrayList<ItemPropertyDTO> getAdditionalProperties() {
        return additionalProperties;
    }
    public void setAdditionalProperties(ArrayList<ItemPropertyDTO> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    public ArrayList<ItemPropertyDTO> getNextLevelRequirements() {
        return nextLevelRequirements;
    }
    public void setNextLevelRequirements(ArrayList<ItemPropertyDTO> nextLevelRequirements) {
        this.nextLevelRequirements = nextLevelRequirements;
    }
    public ArrayList<ItemPropertyDTO> getNotableProperties() {
        return notableProperties;
    }
    public void setNotableProperties(ArrayList<ItemPropertyDTO> notableProperties) {
        this.notableProperties = notableProperties;
    }
    public ArrayList<ItemPropertyDTO> getProperties() {
        return properties;
    }
    public void setProperties(ArrayList<ItemPropertyDTO> properties) {
        this.properties = properties;
    }
    public ArrayList<ItemPropertyDTO> getRequirements() {
        return requirements;
    }
    public void setRequirements(ArrayList<ItemPropertyDTO> requirements) {
        this.requirements = requirements;
    }
    public ArrayList<ItemSocketDTO> getSockets() {
        return sockets;
    }
    public void setSockets(ArrayList<ItemSocketDTO> sockets) {
        this.sockets = sockets;
    }
    public ArrayList<LogbookModsDTO> getLogbookMods() {
        return logbookMods;
    }
    public void setLogbookMods(ArrayList<LogbookModsDTO> logbookMods) {
        this.logbookMods = logbookMods;
    }
    public ArrayList<Object> getFlavourTextParsed() {
        return flavourTextParsed;
    }
    public void setFlavourTextParsed(ArrayList<Object> flavourTextParsed) {
        this.flavourTextParsed = flavourTextParsed;
    }
    public ArrayList<RewardsDTO> getRewards() {
        return rewards;
    }
    public void setRewards(ArrayList<RewardsDTO> rewards) {
        this.rewards = rewards;
    }
    public ArrayList<UltimatumModsDTO> getUltimatumMods() {
        return ultimatumMods;
    }
    public void setUltimatumMods(ArrayList<UltimatumModsDTO> ultimatumMods) {
        this.ultimatumMods = ultimatumMods;
    }

    @Override
    public String toString() {
        return "\r\n" +
                "ItemDTO{" +
                "dbId=" + dbId +
                ", artFilename='" + artFilename + '\'' +
                ", baseType='" + baseType + '\'' +
                ", colour='" + colour + '\'' +
                ", flavourTextNote='" + flavourTextNote + '\'' +
                ", forum_note='" + forum_note + '\'' +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", league='" + league + '\'' +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", prophecyText='" + prophecyText + '\'' +
                ", rarity='" + rarity + '\'' +
                ", secDescrText='" + secDescrText + '\'' +
                ", stackSizeText='" + stackSizeText + '\'' +
                ", typeLine='" + typeLine + '\'' +
                ", abyssJewel=" + abyssJewel +
                ", cisRaceReward=" + cisRaceReward +
                ", corrupted=" + corrupted +
                ", delve=" + delve +
                ", duplicated=" + duplicated +
                ", elder=" + elder +
                ", foreseeing=" + foreseeing +
                ", fractured=" + fractured +
                ", identified=" + identified +
                ", isRelic=" + isRelic +
                ", lockedToAccount=" + lockedToAccount +
                ", lockedToCharacter=" + lockedToCharacter +
                ", replica=" + replica +
                ", ruthless=" + ruthless +
                ", seaRaceReward=" + seaRaceReward +
                ", searing=" + searing +
                ", shaper=" + shaper +
                ", split=" + split +
                ", support=" + support +
                ", synthesised=" + synthesised +
                ", tangled=" + tangled +
                ", thRaceReward=" + thRaceReward +
                ", unmodifiable=" + unmodifiable +
                ", veiled=" + veiled +
                ", verified=" + verified +
                ", foilVariation=" + foilVariation +
                ", ilvl=" + ilvl +
                ", itemLevel=" + itemLevel +
                ", maxStackSize=" + maxStackSize +
                ", parentItemId=" + parentItemId +
                ", publicStashChangeId=" + publicStashChangeId +
                ", stackSize=" + stackSize +
                ", talismanTier=" + talismanTier +
                ", h=" + h +
                ", socket=" + socket +
                ", w=" + w +
                ", x=" + x +
                ", y=" + y +
                ", crucible=" + crucible +
                ", extended=" + extended +
                ", frameType=" + frameType +
                ", hybrid=" + hybrid +
                ", incubatedItem=" + incubatedItem +
                ", influences=" + influences +
                ", scourged=" + scourged +
                ", cosmeticMods=" + cosmeticMods +
                ", craftedMods=" + craftedMods +
                ", crucibleMods=" + crucibleMods +
                ", descrText=" + descrText +
                ", enchantMods=" + enchantMods +
                ", explicitMods=" + explicitMods +
                ", flavourText=" + flavourText +
                ", fracturedMods=" + fracturedMods +
                ", implicitMods=" + implicitMods +
                ", scourgeMods=" + scourgeMods +
                ", utilityMods=" + utilityMods +
                ", veiledMods=" + veiledMods +
                ", socketedItems=" + socketedItems +
                ", additionalProperties=" + additionalProperties +
                ", nextLevelRequirements=" + nextLevelRequirements +
                ", notableProperties=" + notableProperties +
                ", properties=" + properties +
                ", requirements=" + requirements +
                ", sockets=" + sockets +
                ", logbookMods=" + logbookMods +
                ", flavourTextParsed=" + flavourTextParsed +
                ", rewards=" + rewards +
                ", ultimatumMods=" + ultimatumMods +
                '}';
    }
}