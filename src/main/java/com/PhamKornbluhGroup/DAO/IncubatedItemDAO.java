package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.IncubatedItemDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IIncubatedItemDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class IncubatedItemDAO {

    private final static Logger IncubatedItemDAOLogger = LogManager.getLogger(IncubatedItemDAO.class);

    public IncubatedItemDTO getIncubatedItemById(int id) {
        SqlSession session = SessionPool.getSession();
        IIncubatedItemDTO mapper = session.getMapper(IIncubatedItemDTO.class);
        IncubatedItemDAOLogger.trace("Attempting to get IncubatedItemDTO object with ID " + id);
        IncubatedItemDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            IncubatedItemDAOLogger.trace("IncubatedItemDTO get = Success!");
        }
        else {
            IncubatedItemDAOLogger.error("IncubatedItemDTO get = Failure!");
        }
        return newNode;
    }

    public void insertIncubatedItemById(ArrayList<IncubatedItemDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IIncubatedItemDTO mapper = session.getMapper(IIncubatedItemDTO.class);
        IncubatedItemDAOLogger.trace("Attempting to insert IncubatedItemDTO object in list.");
        for (IncubatedItemDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        IncubatedItemDAOLogger.trace("IncubatedItemDTO Insert Attempt finished.");
    }

    public void insertIncubatedItem(IncubatedItemDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IIncubatedItemDTO mapper = session.getMapper(IIncubatedItemDTO.class);
        IncubatedItemDAOLogger.trace("Attempting to insert IncubatedItemDTO object in list.");
        mapper.saveEntity(insertObject);
        session.commit();
        IncubatedItemDAOLogger.trace("IncubatedItemDTO Insert Attempt finished.");
    }
}
