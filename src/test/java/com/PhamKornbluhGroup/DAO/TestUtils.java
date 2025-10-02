package com.PhamKornbluhGroup.DAO;
import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import com.PhamKornbluhGroup.DTO.DisplayMode;
import com.PhamKornbluhGroup.DTO.FactionId;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;

import com.PhamKornbluhGroup.DTO.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class TestUtils {

    //@Test
    public void fakeInsertAndGetResult() {
        ResultDAO dao = new ResultDAO();

        System.out.println("Attempting to insert ResultDTO object.");

        ResultDTO sampleResult = createMockResult();

        System.out.println(dao.getResultById(sampleResult.getDbId()));

        dao.deleteResultById(sampleResult.getDbId());

        System.out.println("Inserted and deleted without exceptions.");
    }

    public static ResultDTO createMockResult() {
        ArrayList<PublicStashChangeDTO> stashes = new ArrayList<>();
        stashes.add(createMockPublicStashChange());
        ResultDTO result = new ResultDTO();
        result.setDbId(1);
        result.setNextChangeId("1");
        result.setStashes(stashes);

        return result;
    }

    public static PublicStashChangeDTO createMockPublicStashChange() {
        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(createMockItem());
        PublicStashChangeDTO stash = new PublicStashChangeDTO();
        stash.setDbId(1);
        stash.setResultId(1);
        stash.setId("string id");
        stash.setPublic(true);
        stash.setAccountName("String accountName");
        stash.setStash("String stash");
        stash.setStashType("type");
        stash.setLeague("String league");
        stash.setItems(items);

        return stash;
    }

    public static ItemDTO createMockItem() {
        CrucibleDTO crucible = createMockCrucible();
        ExtendedDTO extended = createMockExtended();
        FrameType frameType = FrameType.EIGHT;
        HybridDTO hybrid = createMockHybrid();
        IncubatedItemDTO incubatedItem = createMockIncubatedItem();

        InfluencesDTO influences = new InfluencesDTO();
        influences.setCrusader(true);
        influences.setElder(true);

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

        ItemDTO item = new ItemDTO();
        item.setDbId(1);
        item.setArtFilename("String artFilename");
        item.setBaseType("String baseType");
        item.setColour("String colour");
        item.setDescrText("String descrTextNote");
        item.setFlavourTextNote("String flavourTextNote");
        item.setForum_note("String forum_note");
        item.setIcon("String icon");
        item.setId("String id");
        item.setInventoryId("String inventoryId");
        item.setLeague("String league");
        item.setName("String name");
        item.setNote("String note");
        item.setProphecyText("String prophecyText");
        item.setRarity("String rarity");
        item.setSecDescrText("String secDescrText");
        item.setStackSizeText("String stackSizeText");
        item.setTypeLine("String typeLine");
        item.setAbyssJewel(true);
        item.setCisRaceReward(true);
        item.setCorrupted(true);
        item.setDelve(true);
        item.setDuplicated(true);
        item.setElder(true);
        item.setForeseeing(true);
        item.setFractured(true);
        item.setIdentified(true);
        item.setRelic(true);
        item.setLockedToAccount(true);
        item.setLockedToCharacter(true);
        item.setReplica(true);
        item.setRuthless(true);
        item.setSeaRaceReward(true);
        item.setSearing(true);
        item.setShaper(true);
        item.setSplit(true);
        item.setSupport(true);
        item.setSynthesised(true);
        item.setTangled(true);
        item.setThRaceReward(true);
        item.setUnmodifiable(true);
        item.setVeiled(true);
        item.setVerified(true);
        item.setFoilVariation(1);
        item.setIlvl(1);
        item.setItemLevel(1);
        item.setMaxStackSize(1);
        item.setParentItemId(1);
        item.setPublicStashChangeId(1);
        item.setStackSize(1);
        item.setTalismanTier(1);
        item.setH(1);
        item.setSocket(1);
        item.setW(1);
        item.setX(1);
        item.setY(1);
        item.setCrucible(crucible);
        item.setExtended(extended);
        item.setFrameType(frameType);
        item.setHybrid(hybrid);
        item.setIncubatedItem(incubatedItem);
        item.setInfluences(influences);
        item.setScourged(scourged);
        item.setCosmeticMods(cosmeticMods);
        item.setCraftedMods(craftedMods);
        item.setCrucibleMods(crucibleMods);
        item.setEnchantMods(enchantMods);
        item.setExplicitMods(explicitMods);
        item.setFlavourText(flavourText);
        item.setFracturedMods(fracturedMods);
        item.setImplicitMods(implicitMods);
        item.setScourgeMods(scourgeMods);
        item.setUtilityMods(utilityMods);
        item.setVeiledMods(veiledMods);
        item.setSocketedItems(socketedItems);
        item.setAdditionalProperties(additionalProperties);
        item.setNextLevelRequirements(nextLevelRequirements);
        item.setNotableProperties(notableProperties);
        item.setProperties(properties);
        item.setRequirements(requirements);
        item.setSockets(sockets);
        item.setLogbookMods(logbookMods);
        item.setFlavourTextParsed(flavourTextParsed);
        item.setRewards(rewards);
        item.setUltimatumMods(ultimatumMods);

        return item;
    }

    public static Object createMockFlavourTextParsed() {
        var flavourTextParsed = new Object() {
            public String text = "yay";
        };
        return flavourTextParsed;
    }

    public static ItemSocketDTO createMockItemSocket() {
        ItemSocketDTO socket = new ItemSocketDTO();
        socket.setDbId(1);
        socket.setItemId(0);
        socket.setGroup(123);
        socket.setAttr("st");
        socket.setsColour("st");

        return socket;
    }

    public static ItemPropertyDTO createMockProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();
        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("hybrid property");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(displayMode);
        itemProperty.setProgress(123);
        itemProperty.setType(123);
        itemProperty.setSuffix("sufferix");
        itemProperty.setIcon("sample icon");
        itemProperty.setPropertyType("propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setValueType(1);
        itemPropertyValues.setValue("item property");
        itemPropertyValues.setItemPropertyId(1);
        itemPropertyValues.setDbId(1);

        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockNotableProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockNotablePropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();
        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("hybrid property");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(displayMode);
        itemProperty.setProgress(123);
        itemProperty.setType(123);
        itemProperty.setSuffix("sufferix");
        itemProperty.setIcon("sample icon");
        itemProperty.setPropertyType("propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockNotablePropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setValueType(123);
        itemPropertyValues.setValue("item property");
        itemPropertyValues.setItemPropertyId(1);
        itemPropertyValues.setDbId(1);

        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockRequirements() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockRequirementsItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();
        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("hybrid property");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(displayMode);
        itemProperty.setProgress(123);
        itemProperty.setType(123);
        itemProperty.setSuffix("sufferix");
        itemProperty.setIcon("sample icon");
        itemProperty.setPropertyType("propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockRequirementsItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setValueType(123);
        itemPropertyValues.setValue("item");
        itemPropertyValues.setItemPropertyId(1);
        itemPropertyValues.setDbId(1);

        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockAdditionalProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockAdditionalPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();
        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("hybrid property");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(displayMode);
        itemProperty.setProgress(123);
        itemProperty.setType(123);
        itemProperty.setSuffix("sufferix");
        itemProperty.setIcon("sample icon");
        itemProperty.setPropertyType("propertyType");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockAdditionalPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setValueType(123);
        itemPropertyValues.setValue("va");
        itemPropertyValues.setItemPropertyId(2);
        itemPropertyValues.setDbId(2);

        return itemPropertyValues;
    }

    public static ItemPropertyDTO createMockNextLevelRequirements() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockNextLevelRequirementsItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();
        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("hybrid property");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(DisplayMode.ZERO);
        itemProperty.setProgress(12D);
        itemProperty.setType(12L);
        itemProperty.setSuffix("suffer");
        itemProperty.setIcon("icon");
        itemProperty.setPropertyType("type");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockNextLevelRequirementsItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setValueType(2L);
        itemPropertyValues.setValue("item property");
        itemPropertyValues.setItemPropertyId(2);
        itemPropertyValues.setDbId(2);

        return itemPropertyValues;
    }

    public static RewardsDTO createMockRewards() {
        ArrayList<RewardsCollectionDTO> rewardsCollection = new ArrayList<>();
        rewardsCollection.add(createMockRewardsCollection());
        RewardsDTO rewards = new RewardsDTO();
        rewards.setDbId(1);
        rewards.setItemId(1);
        rewards.setLabel("String label");
        rewards.setRewards(rewardsCollection);

        return rewards;
    }

    public static RewardsCollectionDTO createMockRewardsCollection() {
        RewardsCollectionDTO rewardsCollection = new RewardsCollectionDTO();
        rewardsCollection.setRewardsId(0);
        rewardsCollection.setRewardsAmount(10);
        rewardsCollection.setRewardsType("flasks");

        return rewardsCollection;
    }

    public static LogbookModsDTO createMockLogbookMods() {
        FactionDTO faction = createMockLogbookModsFaction();

        ArrayList<String> mods = new ArrayList<>();
        mods.add("mod1");

        LogbookModsDTO logbookMods = new LogbookModsDTO();
        logbookMods.setDbId(1);
        logbookMods.setItemId(1);
        logbookMods.setAreaName("String areaName");
        logbookMods.setFaction(faction);
        logbookMods.setMods(mods);

        return logbookMods;
    }

    public static FactionDTO createMockLogbookModsFaction() {
        FactionId id = FactionId.FACTION1;
        FactionDTO faction = new FactionDTO();
        faction.setDbId(1);
        faction.setLogbookModsId(1);
        faction.setFactionId(id);
        faction.setFactionName("String factionName");

        return faction;
    }

    public static UltimatumModsDTO createMockUltimatumMods() {
        UltimatumModsDTO ultimatumMods = new UltimatumModsDTO();
        ultimatumMods.setDbId(1);
        ultimatumMods.setItemId(1);
        ultimatumMods.setType("String type");
        ultimatumMods.setTier(1L);

        return ultimatumMods;
    }

    public static IncubatedItemDTO createMockIncubatedItem() {
        IncubatedItemDTO incubatedItem = new IncubatedItemDTO();
        incubatedItem.setDbId(1);
        incubatedItem.setItemId(1);
        incubatedItem.setIncubatedItemName("String incubatedItemName");
        incubatedItem.setIncubatedItemLevel(1);
        incubatedItem.setProgress(1);
        incubatedItem.setTotal(1);

        return incubatedItem;
    }

    public static ScourgedDTO createMockScourged() {
        ScourgedDTO scourged = new ScourgedDTO();
        scourged.setDbId(1);
        scourged.setItemId(1);
        scourged.setScourgedTier(1L);
        scourged.setScourgedLevel(1L);
        scourged.setScourgedProgress(1L);
        scourged.setScourgedTotal(1L);

        return scourged;
    }

    public static CrucibleDTO createMockCrucible() {
        ArrayList<CrucibleNodeDTO> nodes = new ArrayList<>();
        nodes.add(createMockCrucibleNode());

        CrucibleDTO crucible = new CrucibleDTO();
        crucible.setDbId(1);
        crucible.setItemId(1);
        crucible.setLayout("String layout");
        crucible.setNodes(nodes);

        return crucible;
    }

    public static CrucibleNodeDTO createMockCrucibleNode() {
        ArrayList<String> out = new ArrayList<>();
        out.add("hey");

        CrucibleNodeDTO node = new CrucibleNodeDTO();
        node.setDbId(1);
        node.setCrucibleId(1);
        node.setSkill(1L);
        node.setTier(1L);
        node.setIcon("icon");
        node.setAllocated(false);
        node.setNotable(false);
        node.setReward(false);
        node.setReminderText("render");
        node.setOrbit(0L);
        node.setOrbitIndex(0L);
        node.setCrucibleNodeIndex("string crucibleNodeIndex");

        node.setOut(out);
        node.setIn(out);
        node.setStats(out);

        return node;
    }

    public static HybridDTO createMockHybrid() {
        ArrayList<ItemPropertyDTO> itemProperties = new ArrayList<>();
        itemProperties.add(createMockHybridProperties());

        ArrayList<String> explicitMods = new ArrayList<>();
        explicitMods.add("mod");

        HybridDTO hybrid = new HybridDTO();

        hybrid.setDbId(1);
        hybrid.setItemId(1);
        hybrid.setVaalGem(true);
        hybrid.setBaseTypeName("base");
        hybrid.setProperties(itemProperties);
        hybrid.setExplicitMods(explicitMods);
        hybrid.setSecDescrText("sec");

        return hybrid;
    }

    public static ItemPropertyDTO createMockHybridProperties() {
        ArrayList<ItemPropertyValuesDTO> values = new ArrayList<>();
        values.add(createMockHybridPropertiesItemPropertyValues());

        DisplayMode displayMode = DisplayMode.ONE;

        ItemPropertyDTO itemProperty = new ItemPropertyDTO();

        itemProperty.setDbId(1);
        itemProperty.setItemId(0);
        itemProperty.setHybridId(0);
        itemProperty.setName("name");
        itemProperty.setValues(values);
        itemProperty.setDisplayMode(displayMode);
        itemProperty.setProgress(1);
        itemProperty.setType(1);
        itemProperty.setSuffix("suffix");
        itemProperty.setIcon("icon");
        itemProperty.setPropertyType("type");

        return itemProperty;
    }

    public static ItemPropertyValuesDTO createMockHybridPropertiesItemPropertyValues() {
        ItemPropertyValuesDTO itemPropertyValues = new ItemPropertyValuesDTO();
        itemPropertyValues.setDbId(1);
        itemPropertyValues.setItemPropertyId(1);
        itemPropertyValues.setValue("value");
        itemPropertyValues.setValueType(1);

        return itemPropertyValues;
    }

    public static ExtendedDTO createMockExtended() {
        ArrayList<String> subcategories = new ArrayList<String>(
                Arrays.asList(
                        "test subcategory 1",
                        "test subcategory 2"
                ));
        ExtendedDTO extended = new ExtendedDTO();
        extended.setDbId(1);
        extended.setItemId(1);
        extended.setCategory("test category");
        extended.setSubcategories(subcategories);
        extended.setPrefixes(123);
        extended.setSuffixes(123);

        return extended;
    }
}