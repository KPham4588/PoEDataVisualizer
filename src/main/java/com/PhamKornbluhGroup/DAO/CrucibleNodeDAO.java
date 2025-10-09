package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleNodeDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CrucibleNodeDAO {

    private final static Logger CrucibleNodeDAOLogger = LogManager.getLogger(CrucibleNodeDAO.class);

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

    public void insertCrucibleNode(CrucibleNodeDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to insert CrucibleNodeDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        insertStats(insertObject.getDbId(), insertObject.getStats());
        insertIn(insertObject.getDbId(), insertObject.getIn());
        insertOut(insertObject.getDbId(), insertObject.getOut());

        System.out.println("Attempt finished.");
    }

    public void insertCrucibleNodes(ArrayList<CrucibleNodeDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to insert" + insertObjects.size() + " CrucibleNodeDTO object in list.");
        for (CrucibleNodeDTO node : insertObjects) {
            insertCrucibleNode(node);
        }
        System.out.println("Attempt finished.");
    }

    private void insertStats(int crucibleNodeId, ArrayList<String> stats) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);

        for (String stat : stats) {
            mapper.insertStat(crucibleNodeId, stat);
        }
        session.commit();
    }

    private void insertIn(int crucibleNodeId, ArrayList<String> in) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);

        for (String inValue : in) {
            mapper.insertIn(crucibleNodeId, inValue);
        }
        session.commit();
    }

    private void insertOut(int crucibleNodeId, ArrayList<String> out) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);

        for (String outValue: out) {
            mapper.insertOut(crucibleNodeId, outValue);
        }
        session.commit();
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
