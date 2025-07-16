package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CrucibleDAO {

    private final static Logger CrucibleDAOLogger = LogManager.getLogger(CrucibleDAO.class);

    //P UPDATES NEEDED -- THIS IS COPIED FROM CRUCIBLENODEDTO
    public void insertCrucible(CrucibleDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleDTO mapper = session.getMapper(ICrucibleDTO.class);
        System.out.println("Attempting to insert CrucibleDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public CrucibleDTO getCrucibleById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleDTO mapper = session.getMapper(ICrucibleDTO.class);
        System.out.println("Attempting to get CrucibleDTO object with ID " + id);
        CrucibleDTO newNode = mapper.getEntityById(id);
        CrucibleNodeDAO crucibleNodeDao = new CrucibleNodeDAO();
        List<CrucibleNodeDTO> nodes = crucibleNodeDao.getCrucibleNodesByCrucibleId(id);
        if (newNode != null) {
            CrucibleDAOLogger.trace("Success!");
            newNode.setNodes((ArrayList<CrucibleNodeDTO>) nodes);
        }
        else {
            CrucibleDAOLogger.error("Failure!");
        }
        return newNode;
    }

    //P UPDATES NEEDED -- THIS IS COPIED FROM CRUCIBLENODEDTO
    public void updateCrucible(CrucibleDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleDTO mapper = session.getMapper(ICrucibleDTO.class);
        System.out.println("Attempting to update CrucibleDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    //P UPDATES NEEDED -- THIS IS COPIED FROM CRUCIBLENODEDTO
    public void deleteCrucibleById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleDTO mapper = session.getMapper(ICrucibleDTO.class);
        System.out.println("Attempting to delete CrucibleDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
    
}

/*
* we will eventually need to figure out how to query for a full nested object with one to many relationships
* this join will be preserved for now
* <select id="getEntityById" resultMap="CrucibleDTOMap">
        <![CDATA[
        SELECT
            Crucible.dbId as dbId,
            Crucible.itemId as itemId,
            Crucible.layout as layout,
            -- All of the CrucibleNode fields below link to the associated Arraylist "nodes" property, mapped via the CrucibleNodeDTOMapper Resultmap
            CrucibleNode.dbId AS nodeDbId,
            CrucibleNode.crucibleId as crucibleId,
            CrucibleNode.skill as skill,
            CrucibleNode.tier as tier,
            CrucibleNode.icon as icon,
            CrucibleNode.allocated as allocated,
            CrucibleNode.isNotable as isNotable,
            CrucibleNode.isReward as isReward,
            CrucibleNode.stats as stats,
            CrucibleNode.reminderText as reminderText,
            CrucibleNode.orbit as orbit,
            CrucibleNode.orbitIndex as orbitIndex,
            CrucibleNode.`out` as `out`,
            CrucibleNode.`in` as `in`,
            CrucibleNode.`crucibleNodeIndex` as crucibleNodeIndex
        FROM `poe-oracle`.Crucible AS Crucible
        INNER JOIN `poe-oracle`.CrucibleNode AS CrucibleNode
        ON Crucible.dbId = CrucibleNode.crucibleId
        WHERE Crucible.dbId = #{dbId}
		]]>
    </select>
* */
