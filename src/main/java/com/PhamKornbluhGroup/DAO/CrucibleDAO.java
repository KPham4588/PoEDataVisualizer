package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        if (newNode != null) {
            CrucibleDAOLogger.trace("Success!");
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
