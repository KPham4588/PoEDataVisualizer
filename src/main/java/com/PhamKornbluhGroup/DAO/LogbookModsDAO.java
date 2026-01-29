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

    public void insertLogbookMods(ArrayList<LogbookModsDTO> insertObjects) {
        if (insertObjects == null) {
            return;
        }

        LogbookModsDAOLogger.trace("Attempting to insert LogbookModsDTO object in list.");
        for (LogbookModsDTO node : insertObjects) {
            insertLogbookMod(node);
        }
        LogbookModsDAOLogger.trace("LogbookModsDTO List Insert Attempt finished.");
    }

    public void insertLogbookMod(LogbookModsDTO insertObject) {
        if (insertObject == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        ILogbookModsDTO mapper = session.getMapper(ILogbookModsDTO.class);
        LogbookModsDAOLogger.trace("Attempting to insert LogbookModsDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();

        insertMods(insertObject.getDbId(), insertObject.getMods());

        var faction = insertObject.getFaction();
        faction.setLogbookModsId(insertObject.getDbId());
        FactionDAO factionDAO = new FactionDAO();
        factionDAO.saveFaction(faction);

        LogbookModsDAOLogger.trace("LogbookModsDTO Insert Attempt finished.");
    }

    private void insertMods(int logbookModsId, ArrayList<String> logbookMods) {
        if (logbookMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        ILogbookModsDTO mapper = session.getMapper(ILogbookModsDTO.class);

        for (String mod : logbookMods) {
            mapper.insertMod(logbookModsId, mod);
        }
        session.commit();
    }
}
