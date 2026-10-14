package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemPropertyValuesDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemPropertyValuesDAO {

    private final static Logger ItemPropertyValuesDAOLogger = LogManager.getLogger(ItemPropertyValuesDAO.class);

    public ItemPropertyValuesDTO getItemPropertyValuesById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        ItemPropertyValuesDAOLogger.trace("Attempting to get ItemPropertyValuesDTO object with ID {}", id);
        ItemPropertyValuesDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemPropertyValuesDAOLogger.trace("getItemPropertyValuesById Success!");
        }
        else {
            ItemPropertyValuesDAOLogger.trace("getItemPropertyValuesById Failure!");
        }
        return newNode;
    }

    // TODO: Figure out if we really need this. Do we ever insert one itemPropertyValues object at a time?
    //  or does it always come in the form of an ArrayList<ItemPropertyValuesDTO>
    public void insertItemPropertyValues(ItemPropertyValuesDTO insertObject, SqlSession session) {
        if (insertObject == null) {
            return;
        }

        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        ItemPropertyValuesDAOLogger.trace("Attempting to insert ItemPropertyValuesDTO object.");
        mapper.saveEntity(insertObject);

        ItemPropertyValuesDAOLogger.trace("insertItemPropertyValues Attempt finished.");
    }

    public void insertItemPropertyValues(ArrayList<ItemPropertyValuesDTO> insertObjects, SqlSession session) {
        if (insertObjects == null) {
            return;
        }

        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        ItemPropertyValuesDAOLogger.trace("Attempting to insert ItemPropertyValuesDTO object in list.");
        for (ItemPropertyValuesDTO node : insertObjects) {
            mapper.saveEntity(node);
        }

        ItemPropertyValuesDAOLogger.trace("insertItemPropertyValues Attempt finished.");
    }

    public void updateItemPropertyValues(ItemPropertyValuesDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        ItemPropertyValuesDAOLogger.trace("Attempting to update ItemPropertyValuesDTO entry.");
        mapper.updateEntity(updateObject);

        ItemPropertyValuesDAOLogger.trace("updateItemPropertyValues Attempt finished.");
    }

    public void deleteItemPropertyValuesById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        ItemPropertyValuesDAOLogger.trace("Attempting to delete ItemPropertyValuesDTO object with ID " + id);
        mapper.removeEntity(id);

        ItemPropertyValuesDAOLogger.trace("Attempt finished.");
    }
}
