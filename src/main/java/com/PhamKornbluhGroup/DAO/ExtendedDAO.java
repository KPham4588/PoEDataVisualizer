package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.ExtendedDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IExtendedDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ExtendedDAO {

    private final static Logger ExtendedDAOLogger = LogManager.getLogger(ExtendedDAO.class);

    public ExtendedDTO getExtendedById(int id) {
        SqlSession session = SessionPool.getSession();
        IExtendedDTO mapper = session.getMapper(IExtendedDTO.class);
        System.out.println("Attempting to get ExtendedDTO object with ID " + id);
        ExtendedDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ExtendedDAOLogger.trace("Success!");
        }
        else {
            ExtendedDAOLogger.error("Failure!");
        }
        return newNode;
    }

    public void insertExtended(ExtendedDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        IExtendedDTO mapper = session.getMapper(IExtendedDTO.class);
        System.out.println("Attempting to insert ExtendedDTO object in list.");
        mapper.saveEntity(insertObject);
            for (String subcategory : insertObject.getSubcategories()) {
                mapper.saveSubcategories(insertObject.getDbId(), subcategory);
            }

        session.commit();
        System.out.println("Attempt finished.");
    }
}
