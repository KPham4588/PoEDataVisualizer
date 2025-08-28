package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.RewardsDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IRewardsDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class RewardsDAO {

    private final static Logger RewardsDAOLogger = LogManager.getLogger(RewardsDAO.class);

    public RewardsDTO getRewardsById(int id) {
        SqlSession session = SessionPool.getSession();
        IRewardsDTO mapper = session.getMapper(IRewardsDTO.class);
        RewardsDAOLogger.trace("Attempting to get RewardsDTO object with ID " + id);
        RewardsDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            RewardsDAOLogger.trace("RewardsDTO get = Success!");
        }
        else {
            RewardsDAOLogger.error("RewardsDTO get = Failure!");
        }
        return newNode;
    }

    public void insertRewardsById(ArrayList<RewardsDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IRewardsDTO mapper = session.getMapper(IRewardsDTO.class);
        RewardsDAOLogger.trace("Attempting to insert RewardsDTO object in list.");
        for (RewardsDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        RewardsDAOLogger.trace("RewardsDTO Insert Attempt finished.");
    }
}
