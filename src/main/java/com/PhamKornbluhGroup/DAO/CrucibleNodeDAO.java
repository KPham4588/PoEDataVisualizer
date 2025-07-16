package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleNodeDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CrucibleNodeDAO {

    private final static Logger CrucibleNodeDAOLogger = LogManager.getLogger(CrucibleNodeDAO.class);

    public void insertCrucibleNode(CrucibleNodeDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to insert CrucibleNodeDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public CrucibleNodeDTO getCrucibleNodeById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to get CrucibleNodeDTO object with ID " + id);
        CrucibleNodeDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            CrucibleNodeDAOLogger.trace("Success!");
        }
        else {
            CrucibleNodeDAOLogger.trace("Failure!");
        }
        return newNode;
    }

    List<CrucibleNodeDTO> getCrucibleNodesByCrucibleId (int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to get multiple CrucibleNodeDTO objects with crucible ID " + id);
        ArrayList<CrucibleNodeDTO> nodes = (ArrayList<CrucibleNodeDTO>) mapper.getCrucibleNodesByCrucibleId(id);
        if (nodes != null) {
            CrucibleNodeDAOLogger.trace("got multiple CrucibleNodes!");
        }
        else {
            CrucibleNodeDAOLogger.trace("Failed to get the list of CrucibleNodeDTO!");
        }
        return nodes;
    }

    public void updateCrucibleNode(CrucibleNodeDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to update CrucibleNodeDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteCrucibleNodeById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to delete CrucibleNodeDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}
