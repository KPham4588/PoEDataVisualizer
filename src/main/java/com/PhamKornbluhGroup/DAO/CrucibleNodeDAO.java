package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleNodeDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;

public class CrucibleNodeDAO {

    public void insertCrucibleNode(CrucibleNodeDTO insertObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to insert CrucibleNodeDTO object.");
        mapper.saveEntity(insertObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public CrucibleNodeDTO getCrucibleNodeById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to get CrucibleNodeDTO object with ID " + id);
        CrucibleNodeDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            System.out.println("Success!");
        }
        else {
            System.out.println("Failure!");
        }
        return newNode;
    }

    public void updateCrucibleNode(CrucibleNodeDTO updateObject) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to update CrucibleNodeDTO entry.");
        mapper.updateEntity(updateObject);
        session.commit();
        System.out.println("Attempt finished.");
    }

    public void deleteCrucibleNodeById(int id) {
        SqlSession session = SessionPool.getSession();
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("Attempting to delete CrucibleNodeDTO object with ID " + id);
        mapper.removeEntity(id);
        session.commit();
        System.out.println("Attempt finished.");
    }
}
