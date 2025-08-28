package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.LogbookModsDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ILogbookModsDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class LogbookModsDAO {

    private final static Logger LogbookModsDAOLogger = LogManager.getLogger(LogbookModsDAO.class);

    public LogbookModsDTO getLogbookModsById(int id) {
        SqlSession session = SessionPool.getSession();
        ILogbookModsDTO mapper = session.getMapper(ILogbookModsDTO.class);
        LogbookModsDAOLogger.trace("Attempting to get LogbookModsDTO object with ID " + id);
        LogbookModsDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            LogbookModsDAOLogger.trace("LogbookModsDTO get = Success!");
        }
        else {
            LogbookModsDAOLogger.error("LogbookModsDTO get = Failure!");
        }
        return newNode;
    }

    public void insertLogbookModsById(ArrayList<LogbookModsDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        ILogbookModsDTO mapper = session.getMapper(ILogbookModsDTO.class);
        LogbookModsDAOLogger.trace("Attempting to insert LogbookModsDTO object in list.");
        for (LogbookModsDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        LogbookModsDAOLogger.trace("LogbookModsDTO Insert Attempt finished.");
    }
}
