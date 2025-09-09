package com.PhamKornbluhGroup.jsonParsing;

import com.PhamKornbluhGroup.DTO.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JSONParser {

    public PublicStashChangeDTO traversePublicStashChange(String json) throws Exception {
        PublicStashChangeDTO currentPublicStashChange = new PublicStashChangeDTO();

        //p Set-up the top-level rootnode, and basic parsing
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);

        //p Iterate through key/value pairs on PublicStashChange
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> currentField = fieldsIterator.next();

            //p Correctly match the field name with the appropriate setter
            switch (currentField.getKey()) {
                case "id" -> currentPublicStashChange.setId(currentField.getValue().asText());
                case "public" -> currentPublicStashChange.setPublic(currentField.getValue().asBoolean());
                case "accountName" -> currentPublicStashChange.setAccountName(currentField.getValue().asText());
                case "stash" -> currentPublicStashChange.setStash(currentField.getValue().asText());
                case "stashType" -> currentPublicStashChange.setStashType(currentField.getValue().asText());
                case "league" -> currentPublicStashChange.setLeague(currentField.getValue().asText());
                //p When the field name is "items" the value is an array of objects, so call downstream method
                case "items" -> {
                    ArrayList<ItemDTO> items = traverseItems(currentField.getValue());
                    currentPublicStashChange.setItems(items);
                }
                default -> {}
            }
        }
        return currentPublicStashChange;
    }

    public ArrayList<ItemDTO> traverseItems(JsonNode jsonNode) {
        ArrayList<ItemDTO> itemList = new ArrayList<>();

        //p Use an iterator to grab 1 item at a time
        Iterator<JsonNode> itemsIterator = jsonNode.elements();
        while (itemsIterator.hasNext()) {
            JsonNode nextItemNode = itemsIterator.next();

            //p Set the value of "nextItem" with "traverseSingleItem" method and add to itemList
            ItemDTO nextItem = traverseSingleItem(nextItemNode);
            itemList.add(nextItem);
        }
        return itemList;
    }

    private ItemDTO traverseSingleItem(JsonNode nextItem) {
        ItemDTO resultItem = new ItemDTO();

        //p Iterate through key/value pairs on an individual item
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = nextItem.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> currentField = fieldsIterator.next();

            //p Correctly match the field name with the appropriate setter
            switch (currentField.getKey()) {
                //p Type = Strings
                case "artFilename" -> resultItem.setArtFilename(currentField.getValue().asText());
                case "baseType" -> resultItem.setBaseType(currentField.getValue().asText());
                case "colour" -> resultItem.setColour(currentField.getValue().asText());
                case "flavourTextNote" -> resultItem.setFlavourTextNote(currentField.getValue().asText());
                //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
                //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
                //r forum_note DOES NOT FIT STANDARD NAMING CONVENTIONS
                case "forum_note" -> resultItem.setForum_note(currentField.getValue().asText());
                case "icon" -> resultItem.setIcon(currentField.getValue().asText());
                case "id" -> resultItem.setId(currentField.getValue().asText());
                case "inventoryId" -> resultItem.setInventoryId(currentField.getValue().asText());
                case "league" -> resultItem.setLeague(currentField.getValue().asText());
                case "name" -> resultItem.setName(currentField.getValue().asText());
                case "note" -> resultItem.setNote(currentField.getValue().asText());
                case "prophecyText" -> resultItem.setProphecyText(currentField.getValue().asText());
                case "rarity" -> resultItem.setRarity(currentField.getValue().asText());
                case "secDescrText" -> resultItem.setSecDescrText(currentField.getValue().asText());
                case "stackSizeText" -> resultItem.setStackSizeText(currentField.getValue().asText());
                case "typeLine" -> resultItem.setTypeLine(currentField.getValue().asText());

                //p Type = booleans
                case "abyssJewel" -> resultItem.setAbyssJewel(currentField.getValue().asBoolean());
                case "cisRaceReward" -> resultItem.setCisRaceReward(currentField.getValue().asBoolean());
                case "corrupted" -> resultItem.setCorrupted(currentField.getValue().asBoolean());
                case "delve" -> resultItem.setDelve(currentField.getValue().asBoolean());
                case "duplicated" -> resultItem.setDuplicated(currentField.getValue().asBoolean());
                case "elder" -> resultItem.setElder(currentField.getValue().asBoolean());
                case "foreseeing" -> resultItem.setForeseeing(currentField.getValue().asBoolean());
                case "fractured" -> resultItem.setFractured(currentField.getValue().asBoolean());
                case "identified" -> resultItem.setIdentified(currentField.getValue().asBoolean());
                case "isRelic" -> resultItem.setRelic(currentField.getValue().asBoolean());
                case "lockedToAccount" -> resultItem.setLockedToAccount(currentField.getValue().asBoolean());
                case "lockedToCharacter" -> resultItem.setLockedToCharacter(currentField.getValue().asBoolean());
                case "replica" -> resultItem.setReplica(currentField.getValue().asBoolean());
                case "ruthless" -> resultItem.setRuthless(currentField.getValue().asBoolean());
                case "seaRaceReward" -> resultItem.setSeaRaceReward(currentField.getValue().asBoolean());
                case "searing" -> resultItem.setSearing(currentField.getValue().asBoolean());
                case "shaper" -> resultItem.setShaper(currentField.getValue().asBoolean());
                case "split" -> resultItem.setSplit(currentField.getValue().asBoolean());
                case "support" -> resultItem.setSupport(currentField.getValue().asBoolean());
                case "synthesised" -> resultItem.setSynthesised(currentField.getValue().asBoolean());
                case "tangled" -> resultItem.setTangled(currentField.getValue().asBoolean());
                case "thRaceReward" -> resultItem.setThRaceReward(currentField.getValue().asBoolean());
                case "unmodifiable" -> resultItem.setUnmodifiable(currentField.getValue().asBoolean());
                case "veiled" -> resultItem.setVeiled(currentField.getValue().asBoolean());
                case "verified" -> resultItem.setVerified(currentField.getValue().asBoolean());

                //p Type = ints
                case "foilVariation" -> resultItem.setFoilVariation(currentField.getValue().asInt());
                case "ilvl" -> resultItem.setIlvl(currentField.getValue().asInt());
                case "itemLevel" -> resultItem.setItemLevel(currentField.getValue().asInt());
                case "maxStackSize" -> resultItem.setMaxStackSize(currentField.getValue().asInt());
                case "parentItemId" -> resultItem.setParentItemId(currentField.getValue().asInt());
                case "publicStashChangeId" -> resultItem.setPublicStashChangeId(currentField.getValue().asInt());
                case "stackSize" -> resultItem.setStackSize(currentField.getValue().asInt());
                case "talismanTier" -> resultItem.setTalismanTier(currentField.getValue().asInt());

                //p Type = longs
                case "h" -> resultItem.setH(currentField.getValue().asLong());
                case "socket" -> resultItem.setSocket(currentField.getValue().asLong());
                case "w" -> resultItem.setW(currentField.getValue().asLong());
                case "x" -> resultItem.setX(currentField.getValue().asLong());
                case "y" -> resultItem.setY(currentField.getValue().asLong());

                //p Type = Custom Classes
                case "crucible" -> {
                    CrucibleDTO crucible = traverseCrucible(currentField.getValue());
                    resultItem.setCrucible(crucible);
                }
                case "extended" -> {
                    ExtendedDTO extended = traverseExtended(currentField.getValue());
                    resultItem.setExtended(extended);
                }
                case "frameType" -> {
                    FrameType frameType = traverseFrameType(currentField.getValue());
                    resultItem.setFrameType(frameType);
                }
                case "hybrid" -> {
                    HybridDTO hybrid = traverseHybrid(currentField.getValue());
                    resultItem.setHybrid(hybrid);
                }
                case "incubatedItem" -> {
                    IncubatedItemDTO incubatedItem = traverseIncubatedItem(currentField.getValue());
                    resultItem.setIncubatedItem(incubatedItem);
                }
                case "influences" -> {
                    Object influences = traverseInfluences(currentField.getValue());
                    resultItem.setInfluences(influences);
                }
                case "scourged" -> {
                    ScourgedDTO scourged = traverseScourged(currentField.getValue());
                    resultItem.setScourged(scourged);
                }
                /* STILL NEED TO ADD ALL OF THE FOLLOWING
                    ArrayList<String> cosmeticMods;
                    ArrayList<String> craftedMods;
                    ArrayList<String> crucibleMods;
                    ArrayList<String> descrText;
                    ArrayList<String> enchantMods;
                    ArrayList<String> explicitMods;
                    ArrayList<String> flavourText;
                    ArrayList<String> fracturedMods;
                    ArrayList<String> implicitMods;
                    ArrayList<String> scourgeMods;
                    ArrayList<String> utilityMods;
                    ArrayList<String> veiledMods;

                    ArrayList<ItemDTO> socketedItems;
                    ArrayList<ItemPropertyDTO> additionalProperties;
                    ArrayList<ItemPropertyDTO> nextLevelRequirements;
                    ArrayList<ItemPropertyDTO> notableProperties;
                    ArrayList<ItemPropertyDTO> properties;
                    ArrayList<ItemPropertyDTO> requirements;
                    ArrayList<ItemSocketDTO> sockets;
                    ArrayList<LogbookModsDTO> logbookMods;
                    ArrayList<Object> flavourTextParsed;
                    ArrayList<RewardsDTO> rewards;
                    ArrayList<UltimatumModsDTO> ultimatumMods;
                */
            }
        }

        return resultItem;
    }

    private CrucibleDTO traverseCrucible(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private ExtendedDTO traverseExtended(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private FrameType traverseFrameType(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private HybridDTO traverseHybrid(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private IncubatedItemDTO traverseIncubatedItem(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private Object traverseInfluences(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }

    private ScourgedDTO traverseScourged(JsonNode value) {
        //R IMPLEMENTATION NEEDED
        return null;
    }
}
