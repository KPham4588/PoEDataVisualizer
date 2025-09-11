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
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);

        System.out.println("Attempting to insert PublicStashChangeDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        ArrayList<ItemDTO> items = insertObject.getItems();
        for (ItemDTO node : items) {
            node.setPublicStashChangeId(insertObject.getDbId());
        }
        insertObject.setItems(items);

        System.out.println("Attempting to insert items.");
        ItemDAO insertItems = new ItemDAO();
        insertItems.insertItemById(items);

        System.out.println("Attempt finished.");
    }

    public void insertPublicStashChanges(ArrayList<PublicStashChangeDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IPublicStashChangeDTO mapper = session.getMapper(IPublicStashChangeDTO.class);
        System.out.println("Attempting to insert PublicStashChangeDTO object in list.");
        for (PublicStashChangeDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        System.out.println("Attempt finished.");
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
}