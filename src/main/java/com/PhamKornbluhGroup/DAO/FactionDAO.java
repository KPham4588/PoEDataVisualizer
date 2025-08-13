package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.FactionDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IFactionDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FactionDAO {

    private final static Logger FactionDAOLogger = LogManager.getLogger(FactionDAO.class);

    public FactionDTO getFactionById(int id) {
        SqlSession session = SessionPool.getSession();
        IFactionDTO mapper = session.getMapper(IFactionDTO.class);
        System.out.println("Attempting to get FactionDTO object with ID " + id);
        FactionDTO faction = mapper.getEntityById(id);
        if (faction != null) {
            FactionDAOLogger.trace("Success!");
        }
        else {
            FactionDAOLogger.error("Failure!");
        }
        return faction;
    }

    public void saveFaction(FactionDTO insertObject)
    {
        SqlSession session = SessionPool.getSession();
        IFactionDTO mapper = session.getMapper(IFactionDTO.class);
        System.out.println("Attempting to save FactionDTO object");
        mapper.saveEntity(insertObject);
        session.commit();

        System.out.println("Attempt finished.");
    }
}
