package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemDAO {

    private final static Logger ItemDAOLogger = LogManager.getLogger(ItemDAO.class);

    public ItemDTO getItemById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to get ItemDTO object with ID " + id);
        ItemDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemDAOLogger.trace("ItemDTO get = Success!");
        }
        else {
            ItemDAOLogger.error("ItemDTO get = Failure!");
        }
        return newNode;
    }

    public void insertItemById(ArrayList<ItemDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to insert ItemDTO object in list.");
        for (ItemDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        ItemDAOLogger.trace("ItemDTO Insert Attempt finished.");
    }
}
