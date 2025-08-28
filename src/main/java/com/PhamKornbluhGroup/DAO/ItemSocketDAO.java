package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ItemSocketDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemSocketDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemSocketDAO {

    private final static Logger ItemSocketDAOLogger = LogManager.getLogger(ItemSocketDAO.class);

    public ItemSocketDTO getItemSocketById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemSocketDTO mapper = session.getMapper(IItemSocketDTO.class);
        ItemSocketDAOLogger.trace("Attempting to get ItemSocketDTO object with ID " + id);
        ItemSocketDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemSocketDAOLogger.trace("ItemSocketDTO get = Success!");
        }
        else {
            ItemSocketDAOLogger.error("ItemSocketDTO get = Failure!");
        }
        return newNode;
    }

    public void insertItemSocketById(ArrayList<ItemSocketDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IItemSocketDTO mapper = session.getMapper(IItemSocketDTO.class);
        ItemSocketDAOLogger.trace("Attempting to insert ItemSocketDTO object in list.");
        for (ItemSocketDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        ItemSocketDAOLogger.trace("ItemSocketDTO Insert Attempt finished.");
    }
}
