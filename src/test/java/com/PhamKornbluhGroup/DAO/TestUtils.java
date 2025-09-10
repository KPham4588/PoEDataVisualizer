package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class TestUtils {

    public static ResultDTO createMockResult() {
        ArrayList<PublicStashChangeDTO> stashes = new ArrayList<>();
        stashes.add(createMockPublicStashChange());
        ResultDTO result = new ResultDTO(1, "String nextChangeId", stashes);

        return result;
    }

    public static PublicStashChangeDTO createMockPublicStashChange() {
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(createMockItem());
        PublicStashChangeDTO stash = new PublicStashChangeDTO(1, 1, "String id", true, "String accountName",
                "String stash", "String stashType", "String league", items);

        return stash;
    }

    public static ItemDTO createMockItem() {
        CrucibleDTO crucible = createMockCrucible();
        ExtendedDTO extended = createMockExtended();
        FrameType frameType = FrameType.EIGHT;
        HybridDTO hybrid = createMockHybrid();
        IncubatedItemDTO incubatedItem = createMockIncubatedItem();
        var influences = new Object() {
            public String influence = "Crusader";
        };

        ScourgedDTO scourged = createMockScourged();

        ArrayList<String> cosmeticMods = new ArrayList<>();
        cosmeticMods.add(0, "Shiny");
        cosmeticMods.add(1, "Foil");

        ArrayList<String> craftedMods = new ArrayList<>();
        cosmeticMods.add(0, "Heya");
        cosmeticMods.add(1, "It's a crafted mod");

        ArrayList<String> crucibleMods = new ArrayList<>();
        cosmeticMods.add(0, "Heya");
        cosmeticMods.add(1, "It's a crucible mod");

        ArrayList<String> descrText = new ArrayList<>();
        descrText.add(0, "Heya");
        descrText.add(1, "It's a descr text");

        ArrayList<String> enchantMods = new ArrayList<>();
        enchantMods.add(0, "Heya");
        enchantMods.add(1, "It's a enchant mod");

        ArrayList<String> explicitMods = new ArrayList<>();
        explicitMods.add(0, "Heya");
        explicitMods.add(1, "It's an explicit mod");

        ArrayList<String> flavourText = new ArrayList<>();
        flavourText.add(0, "Heya");
        flavourText.add(1, "It's a flavour mod");

        ArrayList<String> fracturedMods = new ArrayList<>();
        fracturedMods.add(0, "Heya");
        fracturedMods.add(1, "It's a fractured mod");

        ArrayList<String> implicitMods = new ArrayList<>();
        implicitMods.add(0, "Heya");
        implicitMods.add(1, "It's a implicit mod");

        ArrayList<String> scourgeMods = new ArrayList<>();
        scourgeMods.add(0, "Heya");
        scourgeMods.add(1, "It's a scourge mod");

        ArrayList<String> utilityMods = new ArrayList<>();
        utilityMods.add(0, "Heya");
        utilityMods.add(1, "It's a utility mod");

        ArrayList<String> veiledMods = new ArrayList<>();
        veiledMods.add(0, "Heya");
        veiledMods.add(1, "It's a veiled mod");

        ArrayList<ItemDTO> socketedItems = new ArrayList<>();

        ArrayList<ItemPropertyDTO> additionalProperties = new ArrayList<>();
        additionalProperties.add(createMockAdditionalProperties());

        ArrayList<ItemPropertyDTO> nextLevelRequirements = new ArrayList<>();
        nextLevelRequirements.add(createMockNextLevelRequirements());

        ArrayList<ItemPropertyDTO> notableProperties = new ArrayList<>();
        notableProperties.add(createMockNotableProperties());

        ArrayList<ItemPropertyDTO> properties = new ArrayList<>();
        properties.add(createMockProperties());

        ArrayList<ItemPropertyDTO> requirements = new ArrayList<>();
        requirements.add(createMockRequirements());

        ArrayList<ItemSocketDTO> sockets = new ArrayList<>();
        sockets.add(createMockItemSocket());

        ArrayList<LogbookModsDTO> logbookMods = new ArrayList<>();
        logbookMods.add(createMockLogbookMods());

        ArrayList<Object> flavourTextParsed = new ArrayList<>();
        flavourTextParsed.add(createMockFlavourTextParsed());

        ArrayList<RewardsDTO> rewards = new ArrayList<>();
        rewards.add(createMockRewards());

        ArrayList<UltimatumModsDTO> ultimatumMods = new ArrayList<>();
        ultimatumMods.add(createMockUltimatumMods());

        ItemDTO item = new ItemDTO(1, "String artFilename", "String baseType", "String colour",
                "String flavourTextNote", "String forum_note", "String icon", "String id",
                "String inventoryId", "String league", "String name", "String note",
                "String prophecyText", "String rarity", "String secDescrText",
                "String stackSizeText", "String typeLine", true, true,
                true, true, true, true, true, true, true,
                true, true, true, true, true, true,
                true, true, true, true, true, true, true,
                true, true, true, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, crucible, extended, frameType,
                hybrid, incubatedItem, influences, scourged, cosmeticMods, craftedMods, crucibleMods, descrText,
                enchantMods, explicitMods, flavourText, fracturedMods, implicitMods, scourgeMods, utilityMods,
                veiledMods, socketedItems, additionalProperties, nextLevelRequirements, notableProperties, properties,
                requirements, sockets, logbookMods, flavourTextParsed, rewards, ultimatumMods);

        return item;
    }

    public static Object createMockFlavourTextParsed() {
        var flavourTextParsed = new Object() {
            public String text = "yay";
        };
        return flavourTextParsed;
    }

    public static ItemSocketDTO createMockItemSocket() {
        ItemSocketDTO socket = new ItemSocketDTO(1, 1, 123, "String attr", "String sColour");
        return socket;
    }

    public static ItemPropertyDTO createMockProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                2, 2, "item property", 123);
        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockNotableProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockNotablePropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockNotablePropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                2, 2, "item property", 123);
        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockRequirements() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockRequirementsItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockRequirementsItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                2, 2, "item property", 123);
        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockAdditionalProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockAdditionalPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockAdditionalPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                2, 2, "item property", 123);
        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockNextLevelRequirements() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockNextLevelRequirementsItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockNextLevelRequirementsItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                2, 2, "item property", 123);
        return itemPropertyValues;
    }

    public static RewardsDTO createMockRewards() {
        HashMap<String, Integer> rewardsHashmap = new HashMap<>();
        rewardsHashmap.put("reward1", 1);
        RewardsDTO rewards = new RewardsDTO(1, 1, "String label", rewardsHashmap);
        return rewards;
    }

    public static LogbookModsDTO createMockLogbookMods() {

        FactionDTO faction = createMockLogbookModsFaction();

        String[] mods = new String[] {
                "mod1"
        };

        LogbookModsDTO logbookMods = new LogbookModsDTO(1, 1, "String areaName", faction, mods);

        return logbookMods;
    }

    public static FactionDTO createMockLogbookModsFaction() {
        FactionId id = FactionId.FACTION1;
        FactionDTO faction = new FactionDTO(1, 1, id, "String factionName");

        return faction;
    }

    public static UltimatumModsDTO createMockUltimatumMods() {
        UltimatumModsDTO ultimatumMods = new UltimatumModsDTO(1, 1, "String type", 1);

        return ultimatumMods;
    }

    public static IncubatedItemDTO createMockIncubatedItem() {
        IncubatedItemDTO incubatedItem = new IncubatedItemDTO(1, 1, "String incubatedItemName", 1,
        1, 1);
        return incubatedItem;
    }

    public static ScourgedDTO createMockScourged() {
        ScourgedDTO scourged = new ScourgedDTO(1, 1, 1, 1, 1, 1);
        return scourged;
    }

    public static CrucibleDTO createMockCrucible() {
        ArrayList<CrucibleNodeDTO> nodes = new ArrayList<>();
        nodes.add(createMockCrucibleNode());

        CrucibleDTO crucible = new CrucibleDTO(1, 1, "String layout",
                nodes);

        return crucible;
    }

    public static CrucibleNodeDTO createMockCrucibleNode() {
        CrucibleNodeDTO node = new CrucibleNodeDTO(1, 1, 123, 1, "iconing", true,
        true, false, "stats", "rreminder", 1,
        1, "String out", "String in", "tring crucibleNodeIndex");

        return node;
    }

    public static HybridDTO createMockHybrid() {
        ArrayList<ItemPropertyDTO> itemProperties = new ArrayList<>();
        itemProperties.add(createMockHybridProperties());

        ArrayList<String> explicitMods = new ArrayList<>();
        explicitMods.add("mod");

        HybridDTO hybrid = new HybridDTO(
                1, 1, false, "String baseTypeName",
                itemProperties, explicitMods, "secDescrText");

        return hybrid;
    }

    public static ItemPropertyDTO createMockHybridProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockHybridPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO(1, -1, 1, "hybrid property", values,
                displayMode, 123, 123, "sufferix", "sample icon",
                "propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockHybridPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO(
                1, 1, "item property", 123);
        return itemPropertyValues;
    }

    public static ExtendedDTO createMockExtended() {
        ArrayList<String> subcategories = new ArrayList<String>(
                Arrays.asList(
                        "test subcategory 1",
                        "test subcategory 2"
                ));
        ExtendedDTO extended = new ExtendedDTO(1, 1, "test category", subcategories, 12345, 12345);

        return extended;
    }
}