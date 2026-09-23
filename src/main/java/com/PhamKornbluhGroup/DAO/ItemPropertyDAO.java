package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemPropertyDTO;
import com.PhamKornbluhGroup.DTO.ItemPropertyValuesDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemPropertyDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemPropertyDAO {

    private final static Logger ItemPropertyDAOLogger = LogManager.getLogger(ItemPropertyDAO.class);

    public void insertItemProperty(ItemPropertyDTO insertObject, SqlSession session) {
        if (insertObject == null) {
            return;
        }

        IItemPropertyDTO mapper = session.getMapper(IItemPropertyDTO.class);
        ItemPropertyDAOLogger.trace("Attempting to insert ItemPropertyDTO object.");
        mapper.saveEntity(insertObject);

        ArrayList<ItemPropertyValuesDTO> values = insertObject.getValues();
        for (ItemPropertyValuesDTO value : values) {
            value.setItemPropertyId(insertObject.getDbId());
        }
        insertObject.setValues(values);

        ItemPropertyDAOLogger.trace("Attempting to insert item property values.");
        ItemPropertyValuesDAO insertValues = new ItemPropertyValuesDAO();
        insertValues.insertItemPropertyValues(values, session);

        ItemPropertyDAOLogger.trace("Attempt finished.");
    }

    public void insertItemProperties(ArrayList<ItemPropertyDTO> insertObjects, SqlSession session) {
        if (insertObjects == null) {
            return;
        }

        ItemPropertyDAOLogger.trace("Attempting to insert ItemPropertyDTO objects in list.");
        for (ItemPropertyDTO node : insertObjects) {
            insertItemProperty(node, session);
        }
        ItemPropertyDAOLogger.trace("Attempt finished.");
    }
}
