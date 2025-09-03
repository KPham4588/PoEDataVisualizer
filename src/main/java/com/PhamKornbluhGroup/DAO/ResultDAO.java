package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ResultDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IResultDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ResultDAO {

    private final static Logger ResultDAOLogger = LogManager.getLogger(ResultDAO.class);

    public ResultDTO getResultById(int id) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);
        System.out.println("Attempting to get ResultDTO object with ID " + id);
        ResultDTO result = mapper.getEntityById(id);
        if (result != null) {
            ResultDAOLogger.trace("Success!");
        }
        else {
            ResultDAOLogger.error("Failure!");
        }
        return result;
    }

    public void insertResult(ResultDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);

        System.out.println("Attempting to insert ResultDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        ArrayList<PublicStashChangeDTO> stashes = insertObject.getStashes();
        for (PublicStashChangeDTO node : stashes) {
            node.setResultId(insertObject.getDbId());
        }
        insertObject.setStashes(stashes);

        System.out.println("Attempting to insert crucible stashes.");
        PublicStashChangeDAO insertStashes = new PublicStashChangeDAO();
        insertStashes.insertPublicStashChanges(stashes);

        System.out.println("Attempt finished.");
    }

    public void updateResult(ResultDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);
        System.out.println("Attempting to update ResultDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteResultById(int id) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);
        System.out.println("Attempting to delete ResultDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}