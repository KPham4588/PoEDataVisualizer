package com.PhamKornbluhGroup.DAO;

import com.PhamKornbluhGroup.DTO.*;
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

        ArrayList<ItemSocketDTO> itemSockets = item.getSockets();
        for (ItemSocketDTO socket : itemSockets) {
            socket.setItemId(item.getDbId());
        }
        ItemSocketDAO itemSocketDAO = new ItemSocketDAO();
        itemSocketDAO.insertItemSocketById(itemSockets);

        ArrayList<ItemDTO> socketedItems = item.getSocketedItems();
        for (ItemDTO socketedItem : socketedItems) {
            socketedItem.setParentItemId(item.getDbId());
        }
        insertItems(socketedItems);

        ArrayList<ItemPropertyDTO> properties = item.getProperties();
        for (ItemPropertyDTO property : properties) {
            property.setItemId(item.getDbId());
        }
        ItemPropertyDAO itemPropertyDAO = new ItemPropertyDAO();
        itemPropertyDAO.insertItemProperty(properties);

        ArrayList<ItemPropertyDTO> notableProperties = item.getNotableProperties();
        for (ItemPropertyDTO notableProperty : notableProperties) {
            notableProperty.setItemId(item.getDbId());
        }
        itemPropertyDAO.insertItemProperty(notableProperties);

        ArrayList<ItemPropertyDTO> requirements = item.getRequirements();
        for (ItemPropertyDTO requirement : requirements) {
            requirement.setItemId(item.getDbId());
        }
        itemPropertyDAO.insertItemProperty(requirements);

        ArrayList<ItemPropertyDTO> additionalProperties = item.getAdditionalProperties();
        for (ItemPropertyDTO additionalProperty : additionalProperties) {
            additionalProperty.setItemId(item.getDbId());
        }
        itemPropertyDAO.insertItemProperty(additionalProperties);

        ArrayList<ItemPropertyDTO> nextLevelRequirements = item.getNextLevelRequirements();
        for (ItemPropertyDTO nextlevelRequirement : nextLevelRequirements) {
            nextlevelRequirement.setItemId(item.getDbId());
        }
        itemPropertyDAO.insertItemProperty(nextLevelRequirements);

        ArrayList<RewardsDTO> rewards = item.getRewards();
        for (RewardsDTO reward : rewards) {
            reward.setItemId(item.getDbId());
        }
        RewardsDAO rewardsDAO = new RewardsDAO();
        rewardsDAO.insertRewardsById(rewards);

        ArrayList<LogbookModsDTO> logbookMods = item.getLogbookMods();
        for (LogbookModsDTO logbookMod : logbookMods) {
            logbookMod.setItemId(item.getDbId());
        }
        LogbookModsDAO logbookModsDAO = new LogbookModsDAO();
        logbookModsDAO.insertLogbookModsById(logbookMods);

        ArrayList<UltimatumModsDTO> ultimatumMods = item.getUltimatumMods();
        for (UltimatumModsDTO ultimatumMod : ultimatumMods) {
            ultimatumMod.setItemId(item.getDbId());
        }
        UltimatumModsDAO ultimatumModsDAO = new UltimatumModsDAO();
        ultimatumModsDAO.insertUltimatumModsById(ultimatumMods);

        IncubatedItemDTO incubatedItem = item.getIncubatedItem();
        IncubatedItemDAO incubatedItemDAO = new IncubatedItemDAO();
        incubatedItemDAO.insertIncubatedItem(incubatedItem);

        ScourgedDTO scourged = item.getScourged();
        ScourgedDAO scourgedDAO = new ScourgedDAO();
        scourgedDAO.insertScourged(scourged);

        CrucibleDTO crucible = item.getCrucible();
        crucible.setItemId(item.getDbId());
        CrucibleDAO crucibleDAO = new CrucibleDAO();
        crucibleDAO.insertCrucible(crucible);

        HybridDTO hybrid = item.getHybrid();
        hybrid.setItemId(item.getDbId());
        HybridDAO hybridDAO = new HybridDAO();
        hybridDAO.insertHybrid(hybrid);

        ExtendedDTO extended = item.getExtended();
        extended.setItemId(item.getDbId());
        ExtendedDAO extendedDAO = new ExtendedDAO();
        extendedDAO.insertExtended(extended);
    }

    public void insertItems(ArrayList<ItemDTO> items) {
        System.out.println("Attempting to insert ItemDTO objects in list.");
        for (ItemDTO item : items) {
            insertItem(item);
        }

        System.out.println("Finished inserting list of items.");
    }
}
