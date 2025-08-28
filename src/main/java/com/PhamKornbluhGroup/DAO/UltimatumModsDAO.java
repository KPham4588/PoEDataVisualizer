package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.UltimatumModsDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IUltimatumModsDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class UltimatumModsDAO {

    private final static Logger UltimatumModsDAOLogger = LogManager.getLogger(UltimatumModsDAO.class);

    public UltimatumModsDTO getUltimatumModsById(int id) {
        SqlSession session = SessionPool.getSession();
        IUltimatumModsDTO mapper = session.getMapper(IUltimatumModsDTO.class);
        UltimatumModsDAOLogger.trace("Attempting to get UltimatumModsDTO object with ID " + id);
        UltimatumModsDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            UltimatumModsDAOLogger.trace("UltimatumModsDTO get = Success!");
        }
        else {
            UltimatumModsDAOLogger.error("UltimatumModsDTO get = Failure!");
        }
        return newNode;
    }

    public void insertUltimatumModsById(ArrayList<UltimatumModsDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IUltimatumModsDTO mapper = session.getMapper(IUltimatumModsDTO.class);
        UltimatumModsDAOLogger.trace("Attempting to insert UltimatumModsDTO object in list.");
        for (UltimatumModsDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        UltimatumModsDAOLogger.trace("UltimatumModsDTO Insert Attempt finished.");
    }
}
