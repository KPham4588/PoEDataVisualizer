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
        System.out.println("Attempting to get ItemPropertyValuesDTO object with ID " + id);
        ItemPropertyValuesDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemPropertyValuesDAOLogger.trace("Success!");
        }
        else {
            ItemPropertyValuesDAOLogger.trace("Failure!");
        }
        return newNode;
    }

    public void insertItemPropertyValues(ItemPropertyValuesDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        System.out.println("Attempting to insert ItemPropertyValuesDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void insertItemPropertyValues(ArrayList<ItemPropertyValuesDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        System.out.println("Attempting to insert ItemPropertyValuesDTO object in list.");
        for (ItemPropertyValuesDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void updateItemPropertyValues(ItemPropertyValuesDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        System.out.println("Attempting to update ItemPropertyValuesDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteItemPropertyValuesById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyValuesDTO mapper = session.getMapper(IItemPropertyValuesDTO.class);
        System.out.println("Attempting to delete ItemPropertyValuesDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}
