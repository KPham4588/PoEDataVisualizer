package com.PhamKornbluhGroup.controllers;

import com.PhamKornbluhGroup.DAO.ItemDAO;
import com.PhamKornbluhGroup.DAO.PublicStashChangeDAO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping("/getItems")
    public ItemDTO getItems(@RequestParam("id") int id) {

        ItemDAO dao = new ItemDAO();

        ItemDTO result = dao.getItemById(id);

        return result;
    }

    // Example: http://localhost:8080/items/getItemsByNameAndLeague?itemName=Mageblood&league=Keepers
    @GetMapping("/getItemsByNameAndLeague")
    public ArrayList<PublicStashChangeDTO> getItemsByNameAndLeague(@RequestParam(name = "itemName") String itemName,
                                                                   @RequestParam(name = "league")   String league) {
        PublicStashChangeDAO dao = new PublicStashChangeDAO();
        return dao.findByItemNameAndLeague(itemName, league);
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
}
