package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ScourgedDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IScourgedDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ScourgedDAO {

    private final static Logger ScourgedDAOLogger = LogManager.getLogger(ScourgedDAO.class);

    public ScourgedDTO getScourgedById(int id) {
        SqlSession session = SessionPool.getSession();
        IScourgedDTO mapper = session.getMapper(IScourgedDTO.class);
        ScourgedDAOLogger.trace("Attempting to get ScourgedDTO object with ID " + id);
        ScourgedDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ScourgedDAOLogger.trace("ScourgedDTO get = Success!");
        }
        else {
            ScourgedDAOLogger.error("ScourgedDTO get = Failure!");
        }
        return newNode;
    }

    public void insertScourgedById(ArrayList<ScourgedDTO> insertObjects) {
        SqlSession session = SessionPool.getSession();
        IScourgedDTO mapper = session.getMapper(IScourgedDTO.class);
        ScourgedDAOLogger.trace("Attempting to insert ScourgedDTO object in list.");
        for (ScourgedDTO node : insertObjects) {
            mapper.saveEntity(node);
        }
        session.commit();
        ScourgedDAOLogger.trace("ScourgedDTO Insert Attempt finished.");
    }
}
