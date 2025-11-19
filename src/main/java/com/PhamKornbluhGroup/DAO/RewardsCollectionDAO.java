package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.RewardsCollectionDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IRewardsCollectionDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class RewardsCollectionDAO {

    private final static Logger RewardsCollectionDAOLogger = LogManager.getLogger(RewardsCollectionDAO.class);

    public RewardsCollectionDTO getRewardsCollectionById(int id) {
        SqlSession session = SessionPool.getSession();
        IRewardsCollectionDTO mapper = session.getMapper(IRewardsCollectionDTO.class);
        RewardsCollectionDAOLogger.trace("Attempting to get RewardsCollectionDTO object with ID " + id);
        RewardsCollectionDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            RewardsCollectionDAOLogger.trace("RewardsCollectionDTO get = Success!");
        }
        else {
            RewardsCollectionDAOLogger.error("RewardsCollectionDTO get = Failure!");
        }
        return newNode;
    }

    public void insertRewardsCollections(ArrayList<RewardsCollectionDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IRewardsCollectionDTO mapper = session.getMapper(IRewardsCollectionDTO.class);
        RewardsCollectionDAOLogger.trace("Attempting to insert RewardsCollectionDTO objects in list.");
        for (RewardsCollectionDTO rewardsCollection : insertObjects) {
            mapper.saveEntity(rewardsCollection);
        }
        session.commit();
        RewardsCollectionDAOLogger.trace("RewardsCollectionDTO Insert Attempt finished.");
    }
}
