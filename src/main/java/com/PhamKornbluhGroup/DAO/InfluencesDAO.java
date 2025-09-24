package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.InfluencesDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IInfluencesDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfluencesDAO {
    private final static Logger InfluencesDAOLogger = LogManager.getLogger(InfluencesDAO.class);

    public InfluencesDTO getInfluencesById(int id) {
        SqlSession session = SessionPool.getSession();
        IInfluencesDTO mapper = session.getMapper(IInfluencesDTO.class);
        InfluencesDAOLogger.trace("Attempting to get InfluencesDTO object with ID " + id);
        InfluencesDTO influences = mapper.getEntityById(id);
        if (influences != null) {
            InfluencesDAOLogger.trace("Success!");
        }
        else {
            InfluencesDAOLogger.trace("Failure!");
        }
        return influences;
    }

    public InfluencesDTO getInfluencesByItemId(int id) {
        SqlSession session = SessionPool.getSession();
        IInfluencesDTO mapper = session.getMapper(IInfluencesDTO.class);
        InfluencesDAOLogger.trace("Attempting to get InfluencesDTO object by association to itemId " + id);
        InfluencesDTO influences = mapper.getEntityByItemId(id);
        if (influences != null) {
            InfluencesDAOLogger.trace("Success!");
        }
        else {
            InfluencesDAOLogger.trace("Failure!");
        }
        return influences;
    }

    public void insertInfluences(InfluencesDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IInfluencesDTO mapper = session.getMapper(IInfluencesDTO.class);
        InfluencesDAOLogger.trace("Attempting to insert InfluencesDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        InfluencesDAOLogger.trace("Attempt finished.");
    }

    public void updateCrucibleNode(InfluencesDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IInfluencesDTO mapper = session.getMapper(IInfluencesDTO.class);
        InfluencesDAOLogger.trace("Attempting to update CrucibleNodeDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        InfluencesDAOLogger.trace("Attempt finished.");
    }

    public void deleteInfluencesById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        InfluencesDAOLogger.trace("Attempting to delete CrucibleNodeDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        InfluencesDAOLogger.trace("Attempt finished.");
    }
}
