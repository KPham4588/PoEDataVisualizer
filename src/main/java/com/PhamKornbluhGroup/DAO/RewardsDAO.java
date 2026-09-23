package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.RewardsCollectionDTO;
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

    public void insertRewards(ArrayList<RewardsDTO> insertObjects, SqlSession session) {
        if (insertObjects == null) {
            return;
        }

        RewardsDAOLogger.trace("Attempting to insert list of rewards");
        for (RewardsDTO nextObject : insertObjects) {
            insertReward(nextObject, session);
        }
        RewardsDAOLogger.trace("Finished inserting list of rewards");
    }

    public void insertReward(RewardsDTO reward, SqlSession session) {
        if (reward == null) {
            return;
        }

        IRewardsDTO mapper = session.getMapper(IRewardsDTO.class);
        RewardsDAOLogger.trace("Attempting to insert RewardsDTO object");

        mapper.saveEntity(reward);

        ArrayList<RewardsCollectionDTO> rewardsCollectionDTOS = reward.getRewards();
        for (RewardsCollectionDTO nextRewardCollection : rewardsCollectionDTOS) {
            nextRewardCollection.setRewardsId(reward.getDbId());
        }
        // TODO: Delete redundant setter here and in all similar cases where we're directly modifying a mutable complex
        //  object held as an instance var in a DTO
        reward.setRewards(rewardsCollectionDTOS);

        RewardsDAOLogger.trace("Attempting to insert rewards collection.");
        RewardsCollectionDAO rewardsCollectionDAO = new RewardsCollectionDAO();
        rewardsCollectionDAO.insertRewardsCollections(rewardsCollectionDTOS, session);

        RewardsDAOLogger.trace("RewardsDTO Insert Attempt finished.");
    }
}
