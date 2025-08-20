package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.HybridDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IHybridDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class HybridDAO {

    private final static Logger HybridDAOLogger = LogManager.getLogger(HybridDAO.class);

    public HybridDTO getHybridById(int id) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        System.out.println("Attempting to get HybridDTO object with ID " + id);
        HybridDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            HybridDAOLogger.trace("Success!");
        }
        else {
            HybridDAOLogger.trace("Failure!");
        }
        return newNode;
    }

    public void insertHybrid(HybridDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        System.out.println("Attempting to insert HybridDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void insertHybrid(ArrayList<HybridDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        System.out.println("Attempting to insert HybridDTO object in list.");
        for (HybridDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void updateHybrid(HybridDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        System.out.println("Attempting to update HybridDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteHybridById(int id) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        System.out.println("Attempting to delete HybridDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}
