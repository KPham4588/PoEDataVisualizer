package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.DTO.ExtendedDTO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.mybatismysqlimpl.IItemDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ItemDAO {

    private final static Logger ItemDAOLogger = LogManager.getLogger(ItemDAO.class);

    public ItemDTO getItemById(int id) {
        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to get ItemDTO object with ID " + id);
        ItemDTO newNode = mapper.getEntityById(id);
        if (newNode != null) {
            ItemDAOLogger.trace("ItemDTO get = Success!");
        }
        else {
            ItemDAOLogger.error("ItemDTO get = Failure!");
        }
        return newNode;
    }

    // TODO: figure out how to insert FrameType, influences
    public void insertItem(ItemDTO item) {
        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to insert ItemDTO object.");

        mapper.saveEntity(item);
        session.commit();
        ItemDAOLogger.trace("ItemDTO insert attempt finished. Putting ItemID into child objects");

        CrucibleDTO crucible = item.getCrucible();
        crucible.setItemId(item.getDbId());
        CrucibleDAO crucibleDAO = new CrucibleDAO();
        crucibleDAO.insertCrucible(crucible);

        ExtendedDTO extended = item.getExtended();
        extended.setItemId(item.getDbId());
        ExtendedDAO extendedDAO = new ExtendedDAO();
        extendedDAO.insertExtendedById(extended);

        CrucibleDTO crucible = item.getCrucible();
        crucible.setItemId(item.getDbId());
        CrucibleDAO crucibleDAO = new CrucibleDAO();
        crucibleDAO.insertCrucible(crucible);

        CrucibleDTO crucible = item.getCrucible();
        crucible.setItemId(item.getDbId());
        CrucibleDAO crucibleDAO = new CrucibleDAO();
        crucibleDAO.insertCrucible(crucible);

        CrucibleDTO crucible = item.getCrucible();
        crucible.setItemId(item.getDbId());
        CrucibleDAO crucibleDAO = new CrucibleDAO();
        crucibleDAO.insertCrucible(crucible);


    }

    public void insertItems(ArrayList<ItemDTO> items) {
        System.out.println("Attempting to insert ItemDTO objects in list.");
        for (ItemDTO item : items) {
            insertItem(item);
        }

        System.out.println("Finished inserting list of items.");
    }
}
