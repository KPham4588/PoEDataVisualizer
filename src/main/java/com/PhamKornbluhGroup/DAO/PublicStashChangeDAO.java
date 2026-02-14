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
     *
     * @param league This is the name of the "Standard" or temporary leagues. Examples:
     *               "Hardcore", "Standard", "Keepers"
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

    /**
     * @param itemName This is the name of the Path of Exile Item you want to search for
     *
     * @param league This is the name of the "Standard" or temporary leagues. Examples:
     *               "Hardcore", "Standard", "Keepers"
     */
    public ArrayList<PublicStashChangeDTO> findByCustomParameters(String itemName, String league) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);

        PublicStashChangeDAOLogger.trace("Attempting to get PublicStashChangeDTO objects with custom parameters");

        ArrayList<PublicStashChangeDTO> stash = mapper.findStashesByCustomParameters(itemName, league);
        if (stash != null) {
            PublicStashChangeDAOLogger.trace("Success!");
        }
        else {
            PublicStashChangeDAOLogger.error("Failure!");
        }
        return stash;
    }
}