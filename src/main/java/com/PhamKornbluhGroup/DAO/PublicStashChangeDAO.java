package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IPublicStashChangeDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PublicStashChangeDAO {

    private final static Logger PublicStashChangeDAOLogger = LogManager.getLogger(PublicStashChangeDAO.class);

    public PublicStashChangeDTO getPublicStashChangeById(int id) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);
        System.out.println("Attempting to get PublicStashChangeDTO object with ID " + id);
        PublicStashChangeDTO stash = mapper.getEntityById(id);
        if (stash != null) {
            PublicStashChangeDAOLogger.trace("Success!");
        }
        else {
            PublicStashChangeDAOLogger.error("Failure!");
        }
        return stash;
    }

    public void insertPublicStashChange(PublicStashChangeDTO insertObject) {
        if (insertObject == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);

        System.out.println("Attempting to insert PublicStashChangeDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        ArrayList<ItemDTO> items = insertObject.getItems();
        for (ItemDTO node : items) {
            node.setPublicStashChangeId(insertObject.getDbId());
        }

        System.out.println("Attempting to insert items.");
        ItemDAO insertItems = new ItemDAO();
        insertItems.insertItems(items);

        System.out.println("Attempt finished.");
    }

    /**
     * @param insertObjects This is an ArrayList<PublicStashChangeDTO> that
     *                      gets inserted by the single saveEntity calls
     */
    public void insertPublicStashChanges(ArrayList<PublicStashChangeDTO> insertObjects) {
        if (insertObjects == null) {
            return;
        }

        System.out.println("Attempting to insert PublicStashChangeDTO objects in list.");
        for (PublicStashChangeDTO stash : insertObjects) {
            insertPublicStashChange(stash);
        }

        System.out.println("Finished inserting list of stashes.");
    }

    public void updatePublicStashChange(PublicStashChangeDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);
        System.out.println("Attempting to update PublicStashChangeDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deletePublicStashChangeById(int id) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);
        System.out.println("Attempting to delete PublicStashChangeDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }

    /**
     * @param itemName This is the name of the Path of Exile Item you want to search for
     * @param league   This is the name of the "Standard" or temporary leagues. Examples:
     *                 "Hardcore", "Standard", "Keepers"
     */
    public ArrayList<PublicStashChangeDTO> findByItemNameAndLeague(String itemName, String league) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);

        PublicStashChangeDAOLogger.trace("Attempting to get PublicStashChangeDTO objects that contain items named "
                + itemName + " and are in league " + league);

        ArrayList<PublicStashChangeDTO> stash = mapper.findStashesByItemNameAndLeague(itemName, league);
        if (stash != null) {
            PublicStashChangeDAOLogger.trace("Success!");
        }
        else {
            PublicStashChangeDAOLogger.error("Failure!");
        }
        return stash;
    }

    public ArrayList<PublicStashChangeDTO> findByCustomParameters(String accountName,
                                                                  String artFilename,
                                                                  String baseType,
                                                                  String colour,
                                                                  String flavourTextNote,
                                                                  String forum_note,
                                                                  String icon,
                                                                  String inventoryId,
                                                                  String league,
                                                                  String name,
                                                                  String note,
                                                                  String prophecyText,
                                                                  String rarity,
                                                                  String secDescrText,
                                                                  String stackSizeText,
                                                                  String typeLine,
                                                                  String abyssJewel,
                                                                  String cisRaceReward,
                                                                  String corrupted,
                                                                  String delve,
                                                                  String duplicated,
                                                                  String elder,
                                                                  String foreseeing,
                                                                  String fractured,
                                                                  String identified,
                                                                  String isRelic,
                                                                  String lockedToAccount,
                                                                  String lockedToCharacter,
                                                                  String memoryItem,
                                                                  String replica,
                                                                  String ruthless,
                                                                  String seaRaceReward,
                                                                  String searing,
                                                                  String shaper,
                                                                  String split,
                                                                  String support,
                                                                  String synthesised,
                                                                  String tangled,
                                                                  String thRaceReward,
                                                                  String unmodifiable,
                                                                  String veiled,
                                                                  String verified,
                                                                  String unmodifiableExceptChaos,
                                                                  String foilVariation,
                                                                  String ilvl,
                                                                  String itemLevel,
                                                                  String maxStackSize,
                                                                  String stackSize,
                                                                  String talismanTier,
                                                                  String socket) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);

        PublicStashChangeDAOLogger.trace("Attempting to get PublicStashChangeDTO objects with custom parameters");

        ArrayList<PublicStashChangeDTO> stash = mapper.findStashesByCustomParameters(accountName, artFilename, baseType,
                colour, flavourTextNote, forum_note, icon, inventoryId, league, name, note, prophecyText, rarity,
                secDescrText, stackSizeText, typeLine, abyssJewel, cisRaceReward, corrupted, delve, duplicated, elder,
                foreseeing, fractured, identified, isRelic, lockedToAccount, lockedToCharacter, memoryItem, replica,
                ruthless, seaRaceReward, searing, shaper, split, support, synthesised, tangled, thRaceReward,
                unmodifiable, veiled, verified, unmodifiableExceptChaos, foilVariation, ilvl, itemLevel, maxStackSize,
                stackSize, talismanTier, socket);

        if (stash != null) {
            PublicStashChangeDAOLogger.trace("Success!");
        }
        else {
            PublicStashChangeDAOLogger.error("Failure!");
        }
        return stash;
    }
}