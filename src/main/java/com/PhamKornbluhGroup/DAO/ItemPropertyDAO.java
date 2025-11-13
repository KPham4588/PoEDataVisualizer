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

        System.out.println("Attempting to insert item property values.");
        ItemPropertyValuesDAO insertValues = new ItemPropertyValuesDAO();
        insertValues.insertItemPropertyValues(values);

        System.out.println("Attempt finished.");
    }

    public void insertItemProperties(ArrayList<ItemPropertyDTO> insertObjects) {
        System.out.println("Attempting to insert ItemPropertyDTO objects in list.");
        for (ItemPropertyDTO node : insertObjects) {
            insertItemProperty(node);
        }
        System.out.println("Attempt finished.");
    }
}
