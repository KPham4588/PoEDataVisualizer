package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.ICrucibleNodeDTO;
import org.apache.ibatis.session.SqlSession;

public class DBHelper {

    public void saveCrucibleNode() {
        CrucibleNodeDTO dto = new CrucibleNodeDTO();
        dto.setCrucibleId(69);
        dto.setIcon("SampleImage.jpg");
        SqlSession session = SessionPool.getSession();
        System.out.println("got the session; probably connected");
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("got the mapper; attempting to make a SQL call");
        mapper.saveEntity(dto);
        System.out.println("Successfully saved.");
    }

    public CrucibleNodeDTO getEntityById(int id) {
        SqlSession session = SessionPool.getSession();
        System.out.println("got the session; probably connected");
        ICrucibleNodeDTO mapper = session.getMapper(ICrucibleNodeDTO.class);
        System.out.println("got the mapper; attempting to make a SQL call");
        CrucibleNodeDTO newNode = mapper.getEntityById(1);
        System.out.println("The entry's ID is " + newNode.getDbId());
        return newNode;
    }
}
