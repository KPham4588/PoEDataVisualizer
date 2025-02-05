package com.PhamKornbluhGroup.DTO;

public class ItemDTO {
    // Level 2
    private boolean verified; // Ex: "false"
    private int w; // Ex: "1" //p NOTE: vertical location of item in stash. Maxes vary by tab-type
    private int h; // Ex: "3" //p NOTE: horizontal location of item in stash. Maxes vary by tab-type
    private String icon; // Ex: "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9PbmVIYW5kV2VhcG9ucy9XYW5kcy9XYW5kMyIsInciOjEsImgiOjMsInNjYWxlIjoxfV0/6322bd53f5/Wand3.png"
    private boolean support; // Ex: true //p NOTE: probably refers to whether this is a support gem
    private String league; // Ex: "Standard"
    private String id; // Ex: "d7e37c3a0f2cf27b17f6fc4acc80ae3f58dc97dbc8f47c1ba9f12b756804235e"
    private SocketsDTO[] sockets; //p NOTE: Presumably can have 0-6 sockets max, depending on the item
    private String name; // Ex: "Sol Needle",
    private String typeLine; // Ex: "Imbued Wand"
    private String baseType; // Ex: "Imbued Wand"
    private String rarity; // Ex: "Rare" //p NOTE: Enum should be possible for Grey/White/Magic/Rare/Unique and maybe one or two other rarities. Unsure if Shiny Reliquary Key stats are here
    private int ilvl; // Ex: 82 //p NOTE: Presumably max is 1-100
    private boolean identified; // Ex: true
    private String note; // Ex: "~price 10 exa"
    private PropertiesDTO[] properties;
    private RequirementsDTO[] requirements;
    private AdditionalPropertiesDTO[] additionalProperties;
    private NextLevelRequirementsDTO[] nextLevelRequirements;
    private String[] implicitMods; // Ex: "[ "17% increased Spell Damage" ]"
    private String secDescrText; // Ex: "Jump through the air, damaging and knocking back..."
    private String descrText; // Ex: "Place into an item socket of..."
    private String[] explicitMods; // Ex: "[ "61% increased Spell Damage", "24% increased Cold Damage", "+36% to Global Critical Strike Multiplier" ]"
    private String[] flavourText; // Ex: [ "The stone may yet bleed." ]
    private String[] craftedMods; // Ex: "[ "54% increased Spell Critical Strike Chance" ]"
    private int frameType; // Ex: 2
    private ExtendedDTO extended; //p NOTE: Unsure if an item can contain multiples of this
    private int x; // Ex: "11"
    private int y; // Ex: "6"
    private int inventoryId; // Ex: "Stash1"
    private String[] utilityMods; // Ex: [ "+1500 to Evasion Rating" ]
    private String[] socketedItems; // Ex: [] //TODO: could be String[], but could also be ItemDTO[]
}
