package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.HybridDTO;
import com.PhamKornbluhGroup.DTO.ItemPropertyDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IHybridDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class HybridDAO {

    private final static Logger HybridDAOLogger = LogManager.getLogger(HybridDAO.class);

    public HybridDTO getHybridById(int id) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        HybridDAOLogger.trace("Attempting to get HybridDTO object with ID " + id);
        HybridDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            HybridDAOLogger.trace("Success!");
        }
        else {
            HybridDAOLogger.trace("Failure!");
        }
        return newNode;
    }

    public void insertHybrid(HybridDTO insertObject, SqlSession session) {
        if (insertObject == null) {
            return;
        }

        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        HybridDAOLogger.trace("Attempting to insert HybridDTO object.");
        mapper.saveEntity(insertObject);
        session.flushStatements();

        ArrayList<String> explicitMods = insertObject.getExplicitMods();
        insertExplicitMods(insertObject.getDbId(), explicitMods, session);

        ArrayList<ItemPropertyDTO> properties = insertObject.getProperties();
        for (ItemPropertyDTO nextProperty : properties) {
            nextProperty.setHybridId(insertObject.getDbId());
        }

        ItemPropertyDAO itemProperty = new ItemPropertyDAO();
        itemProperty.insertItemProperties(properties, session);

        HybridDAOLogger.trace("Attempt finished.");
    }

    private void insertExplicitMods(int hybridId, ArrayList<String> explicitMods, SqlSession session) {
        if (explicitMods == null) {
            return;
        }

        HybridDAOLogger.trace("Attempting to insert ExplicitMods");
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        for (String mod : explicitMods) {
            mapper.insertExplicitMod(hybridId, mod);
        }

        HybridDAOLogger.trace("Attempt finished.");
    }

    public void updateHybrid(HybridDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        HybridDAOLogger.trace("Attempting to update HybridDTO entry.");
        mapper.updateEntity(updateObject);

        HybridDAOLogger.trace("Attempt finished.");
    }

    public void deleteHybridById(int id) {
        SqlSession session = SessionPool.getSession();
        IHybridDTO mapper = session.getMapper(IHybridDTO.class);
        HybridDAOLogger.trace("Attempting to delete HybridDTO object with ID " + id);
        mapper.removeEntity(id);

        HybridDAOLogger.trace("Attempt finished.");
    }
}
