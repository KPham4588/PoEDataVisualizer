package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemPropertyDTO;
import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemPropertyDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemPropertyDAO {

    private final static Logger ItemPropertyDAOLogger = LogManager.getLogger(ItemPropertyDAO.class);

    public ItemPropertyDTO getItemPropertyById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        System.out.println("Attempting to get ItemPropertyDTO object with ID " + id);
        ItemPropertyDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemPropertyDAOLogger.trace("Success!");
        }
        else {
            ItemPropertyDAOLogger.trace("Failure!");
        }
        return newNode;
    }

    public void insertItemProperty(ItemPropertyDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        System.out.println("Attempting to insert ItemPropertyDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        ArrayList<ItemPropertyValuesDTO> values = insertObject.getValues();
        for (ItemPropertyValuesDTO value : values) {
            value.setItemPropertyId(insertObject.getDbId());
        }
        insertObject.setValues(values);

        System.out.println("Attempting to insert crucible nodes.");
        ItemPropertyValuesDAO insertValues = new ItemPropertyValuesDAO();
        insertValues.insertItemPropertyValues(values);

        System.out.println("Attempt finished.");
    }

    public void insertItemProperty(ArrayList<ItemPropertyDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        System.out.println("Attempting to insert ItemPropertyDTO object in list.");
        for (ItemPropertyDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void updateItemProperty(ItemPropertyDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        System.out.println("Attempting to update ItemPropertyDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteItemPropertyById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        System.out.println("Attempting to delete ItemPropertyDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}
