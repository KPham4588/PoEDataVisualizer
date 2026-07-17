package com.PhamKornbluhGroup.controllers;

import com.PhamKornbluhGroup.DAO.ItemDAO;
import com.PhamKornbluhGroup.DAO.PublicStashChangeDAO;
import com.PhamKornbluhGroup.DTO.FiltrationDTO.PriceDTO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import com.PhamKornbluhGroup.utilities.StashAndItemPriceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;


@RestController
@RequestMapping("/items")
public class ItemController {

private final static Logger itemControllerLogger = LogManager.getLogger(ItemController.class);

    @GetMapping("/getItems")
    public ItemDTO getItems(@RequestParam("id") int id) {

        ItemDAO dao = new ItemDAO();

        ItemDTO result = dao.getItemById(id);

        return result;
    }

    // Example: http://localhost:8080/items/getItemsByCustomParameters?itemName=Mageblood&league=Keepers
    @GetMapping("/getItemsByCustomParameters")
    public ArrayList<PublicStashChangeDTO> getItemsByCustomParameters(
                       @RequestParam(name = "accountName",             required = false) String accountName,
                       @RequestParam(name = "artFilename",             required = false) String artFilename,
                       @RequestParam(name = "baseType",                required = false) String baseType,
                       @RequestParam(name = "colour",                  required = false) String colour,
                       @RequestParam(name = "flavourTextNote",         required = false) String flavourTextNote,
                       @RequestParam(name = "forum_note",              required = false) String forum_note,
                       @RequestParam(name = "icon",                    required = false) String icon,
                       @RequestParam(name = "inventoryId",             required = false) String inventoryId,
                       @RequestParam(name = "league",                  required = false) String league,
                       @RequestParam(name = "name",                    required = false) String name,
                       @RequestParam(name = "note",                    required = false) String note,
                       @RequestParam(name = "prophecyText",            required = false) String prophecyText,
                       @RequestParam(name = "rarity",                  required = false) String rarity,
                       @RequestParam(name = "secDescrText",            required = false) String secDescrText,
                       @RequestParam(name = "stackSizeText",           required = false) String stackSizeText,
                       @RequestParam(name = "typeLine",                required = false) String typeLine,
                       @RequestParam(name = "abyssJewel",              required = false) String abyssJewel,
                       @RequestParam(name = "cisRaceReward",           required = false) String cisRaceReward,
                       @RequestParam(name = "corrupted",               required = false) String corrupted,
                       @RequestParam(name = "delve",                   required = false) String delve,
                       @RequestParam(name = "duplicated",              required = false) String duplicated,
                       @RequestParam(name = "elder",                   required = false) String elder,
                       @RequestParam(name = "foreseeing",              required = false) String foreseeing,
                       @RequestParam(name = "fractured",               required = false) String fractured,
                       @RequestParam(name = "identified",              required = false) String identified,
                       @RequestParam(name = "isRelic",                 required = false) String isRelic,
                       @RequestParam(name = "lockedToAccount",         required = false) String lockedToAccount,
                       @RequestParam(name = "lockedToCharacter",       required = false) String lockedToCharacter,
                       @RequestParam(name = "memoryItem",              required = false) String memoryItem,
                       @RequestParam(name = "replica",                 required = false) String replica,
                       @RequestParam(name = "ruthless",                required = false) String ruthless,
                       @RequestParam(name = "seaRaceReward",           required = false) String seaRaceReward,
                       @RequestParam(name = "searing",                 required = false) String searing,
                       @RequestParam(name = "shaper",                  required = false) String shaper,
                       @RequestParam(name = "split",                   required = false) String split,
                       @RequestParam(name = "support",                 required = false) String support,
                       @RequestParam(name = "synthesised",             required = false) String synthesised,
                       @RequestParam(name = "tangled",                 required = false) String tangled,
                       @RequestParam(name = "thRaceReward",            required = false) String thRaceReward,
                       @RequestParam(name = "unmodifiable",            required = false) String unmodifiable,
                       @RequestParam(name = "veiled",                  required = false) String veiled,
                       @RequestParam(name = "verified",                required = false) String verified,
                       @RequestParam(name = "unmodifiableExceptChaos", required = false) String unmodifiableExceptChaos,
                       @RequestParam(name = "foilVariation",           required = false) String foilVariation,
                       @RequestParam(name = "ilvl",                    required = false) String ilvl,
                       @RequestParam(name = "itemLevel",               required = false) String itemLevel,
                       @RequestParam(name = "maxStackSize",            required = false) String maxStackSize,
                       @RequestParam(name = "stackSize",               required = false) String stackSize,
                       @RequestParam(name = "talismanTier",            required = false) String talismanTier,
                       @RequestParam(name = "socket",                  required = false) String socket) {

        PublicStashChangeDAO dao = new PublicStashChangeDAO();
        return dao.findByCustomParameters(accountName, artFilename, baseType, colour, flavourTextNote, forum_note, icon,
                inventoryId, league, name, note, prophecyText, rarity, secDescrText, stackSizeText, typeLine,
                abyssJewel, cisRaceReward, corrupted, delve, duplicated, elder, foreseeing, fractured, identified,
                isRelic, lockedToAccount, lockedToCharacter, memoryItem, replica, ruthless, seaRaceReward, searing,
                shaper, split, support, synthesised, tangled, thRaceReward, unmodifiable, veiled, verified,
                unmodifiableExceptChaos, foilVariation, ilvl, itemLevel, maxStackSize, stackSize, talismanTier, socket);
    }


    private class ChartData {
        double value;
        Long timeStamp;

        public ChartData() {
        }

        public void setValue(double value) {
            this.value = value;
        }

        public void setTimeStamp(Long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public double getValue() {
            return value;
        }

        public Long getTimeStamp() {
            return timeStamp;
        }

        @Override
        public String toString() {
            return "ChartData{" +
                    "value=" + value +
                    ", timeStamp=" + timeStamp +
                    '}';
        }
    }

     @GetMapping("/getItemsAsChartDataByCustomParametersAsCostInChaos")
     public ArrayList<ChartData> getItemsAsChartDataByCustomParametersAsCostInChaos(
             @RequestParam(name = "accountName",             required = false) String accountName,
             @RequestParam(name = "artFilename",             required = false) String artFilename,
             @RequestParam(name = "baseType",                required = false) String baseType,
             @RequestParam(name = "colour",                  required = false) String colour,
             @RequestParam(name = "flavourTextNote",         required = false) String flavourTextNote,
             @RequestParam(name = "forum_note",              required = false) String forum_note,
             @RequestParam(name = "icon",                    required = false) String icon,
             @RequestParam(name = "inventoryId",             required = false) String inventoryId,
             @RequestParam(name = "league",                  required = false) String league,
             @RequestParam(name = "name",                    required = false) String name,
             @RequestParam(name = "note",                    required = false) String note,
             @RequestParam(name = "prophecyText",            required = false) String prophecyText,
             @RequestParam(name = "rarity",                  required = false) String rarity,
             @RequestParam(name = "secDescrText",            required = false) String secDescrText,
             @RequestParam(name = "stackSizeText",           required = false) String stackSizeText,
             @RequestParam(name = "typeLine",                required = false) String typeLine,
             @RequestParam(name = "abyssJewel",              required = false) String abyssJewel,
             @RequestParam(name = "cisRaceReward",           required = false) String cisRaceReward,
             @RequestParam(name = "corrupted",               required = false) String corrupted,
             @RequestParam(name = "delve",                   required = false) String delve,
             @RequestParam(name = "duplicated",              required = false) String duplicated,
             @RequestParam(name = "elder",                   required = false) String elder,
             @RequestParam(name = "foreseeing",              required = false) String foreseeing,
             @RequestParam(name = "fractured",               required = false) String fractured,
             @RequestParam(name = "identified",              required = false) String identified,
             @RequestParam(name = "isRelic",                 required = false) String isRelic,
             @RequestParam(name = "lockedToAccount",         required = false) String lockedToAccount,
             @RequestParam(name = "lockedToCharacter",       required = false) String lockedToCharacter,
             @RequestParam(name = "memoryItem",              required = false) String memoryItem,
             @RequestParam(name = "replica",                 required = false) String replica,
             @RequestParam(name = "ruthless",                required = false) String ruthless,
             @RequestParam(name = "seaRaceReward",           required = false) String seaRaceReward,
             @RequestParam(name = "searing",                 required = false) String searing,
             @RequestParam(name = "shaper",                  required = false) String shaper,
             @RequestParam(name = "split",                   required = false) String split,
             @RequestParam(name = "support",                 required = false) String support,
             @RequestParam(name = "synthesised",             required = false) String synthesised,
             @RequestParam(name = "tangled",                 required = false) String tangled,
             @RequestParam(name = "thRaceReward",            required = false) String thRaceReward,
             @RequestParam(name = "unmodifiable",            required = false) String unmodifiable,
             @RequestParam(name = "veiled",                  required = false) String veiled,
             @RequestParam(name = "verified",                required = false) String verified,
             @RequestParam(name = "unmodifiableExceptChaos", required = false) String unmodifiableExceptChaos,
             @RequestParam(name = "foilVariation",           required = false) String foilVariation,
             @RequestParam(name = "ilvl",                    required = false) String ilvl,
             @RequestParam(name = "itemLevel",               required = false) String itemLevel,
             @RequestParam(name = "maxStackSize",            required = false) String maxStackSize,
             @RequestParam(name = "stackSize",               required = false) String stackSize,
             @RequestParam(name = "talismanTier",            required = false) String talismanTier,
             @RequestParam(name = "socket",                  required = false) String socket) {
        ArrayList<ChartData> chartDataArrayList = new ArrayList<>();

        // Make a list of relevant objects
         PublicStashChangeDAO dao = new PublicStashChangeDAO();
         ArrayList<PublicStashChangeDTO> publicStashChangeDTOS = dao.findByCustomParameters(accountName, artFilename,
                 baseType, colour, flavourTextNote, forum_note, icon, inventoryId, league, name, note, prophecyText,
                 rarity, secDescrText, stackSizeText, typeLine, abyssJewel, cisRaceReward, corrupted, delve, duplicated,
                 elder, foreseeing, fractured, identified, isRelic, lockedToAccount, lockedToCharacter, memoryItem,
                 replica, ruthless, seaRaceReward, searing, shaper, split, support, synthesised, tangled, thRaceReward,
                 unmodifiable, veiled, verified, unmodifiableExceptChaos, foilVariation, ilvl, itemLevel, maxStackSize,
                 stackSize, talismanTier, socket);

         // Go through the list converting relevant objects into ChartData format
         // ChartData is the format expected by "Lightweight Charts" on the front-end
         for (PublicStashChangeDTO currentStash : publicStashChangeDTOS) {

             // When querying for Magebloods in Kalandra league for example, you might get a list of
             // 5 publicStashChangeDTOs. But there might be 2 Magebloods in each of them, so grab all items
             // from each tab. for each one, see if it has a valid sale price
             ArrayList<ItemDTO> itemsInCurrentStash = currentStash.getItems();
             for (ItemDTO currentItem : itemsInCurrentStash) {
                 itemControllerLogger.error("currentItem");
                 itemControllerLogger.error(currentItem.toString());


                 PriceDTO parsedItem = StashAndItemPriceParser.parseItemPrice(currentStash, currentItem);

                 itemControllerLogger.error("parsedItem");
                 itemControllerLogger.error(parsedItem.toString());

                 itemControllerLogger.error("parsedItem is valid?");
                 itemControllerLogger.error(parsedItem.isPriceValid());

                 if (parsedItem.isPriceValid()) {
                     ChartData data = new ChartData();
                     data.setValue(parsedItem.calculatePriceInChaos());
                     itemControllerLogger.error("parsedItem.calculatePriceInChaos()");
                     itemControllerLogger.error(parsedItem.calculatePriceInChaos());

                     //data.setTimestamp(currentItem.getTimestamp());
                     // TODO: Once we've added timestamp to the objects in DB, we can use real data instead of this fake data
                     Long randomTimestamp = new Random().nextLong(1577836800000L, 1577837400000L);
                     data.setTimeStamp(randomTimestamp);

                     chartDataArrayList.add(data);
                 }
             }
         }


         itemControllerLogger.error("About to return chartDataArrayList");
         itemControllerLogger.error(chartDataArrayList);
         itemControllerLogger.error("About to return chartDataArrayList as String");
         itemControllerLogger.error(chartDataArrayList.toString());

         return chartDataArrayList;
     }
}
