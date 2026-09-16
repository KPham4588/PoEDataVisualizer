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
        try (SqlSession session = SessionPool.getSession()) {
            IResultDTO mapper = session.getMapper(IResultDTO.class);

            ResultDAOLogger.trace("Attempting to get ResultDTO object with ID " + id);
            ResultDTO result = mapper.getEntityById(id);

            if (result != null) {
                ResultDAOLogger.trace("Success!");
            }
            else {
                ResultDAOLogger.debug("Result is null!");
            }
            return result;
        }
    }

    /** Insert a result object and assigns ResultID to the child {@code PublicStashChangeDTO}
     * objects, then call a {@code PublicStashChangeDAO} to insert
     * @param resultToInsert this is a ResultDTO object
     */
    public void insertResult(ResultDTO resultToInsert) {
        if (resultToInsert == null) {
            return;
        }

        try (SqlSession session = SessionPool.getBatchedSession()) {
            IResultDTO mapper = session.getMapper(IResultDTO.class);

            ResultDAOLogger.trace("Attempting to insert ResultDTO object.");
            mapper.saveEntity(resultToInsert);

            ArrayList<PublicStashChangeDTO> stashes = resultToInsert.getStashes();
            for (PublicStashChangeDTO nextStash : stashes) {
                nextStash.setResultId(resultToInsert.getDbId());
            }

            ResultDAOLogger.trace("Attempting to insert stashes.");
            PublicStashChangeDAO stashChangeDAO = new PublicStashChangeDAO();
            stashChangeDAO.insertPublicStashChanges(stashes, session);

            session.commit();
            ResultDAOLogger.trace("Attempt finished.");
        }

    }

    public void updateResult(ResultDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);
        ResultDAOLogger.trace("Attempting to update ResultDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        ResultDAOLogger.trace("Attempt finished.");
    }

    public void deleteResultById(int id) {
        SqlSession session = SessionPool.getSession();
        IResultDTO mapper = session.getMapper(IResultDTO.class);
        ResultDAOLogger.trace("Attempting to delete ResultDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        ResultDAOLogger.trace("Attempt finished.");
    }
}