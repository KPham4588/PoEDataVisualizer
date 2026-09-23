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

    public void insertItems(ArrayList<ItemDTO> items, SqlSession session) {
        if (items == null) {
            return;
        }

        ItemDAOLogger.trace("Attempting to insert ItemDTO objects in list.");
        for (ItemDTO nextItem : items) {
            insertItem(nextItem, session);
        }

        ItemDAOLogger.trace("Finished inserting list of items.");
    }

    private void insertCosmeticMods(int itemId, ArrayList<String> cosmeticMods, SqlSession session) {
        if (cosmeticMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : cosmeticMods) {
            mapper.insertCosmeticMod(itemId, mod);
        }
    }

    private void insertCraftedMods(int itemId, ArrayList<String> craftedMods, SqlSession session) {
        if (craftedMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : craftedMods) {
            mapper.insertCraftedMod(itemId, mod);
        }
    }

    private void insertEnchantMods(int itemId, ArrayList<String> enchantMods, SqlSession session) {
        if (enchantMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : enchantMods) {
            mapper.insertEnchantMod(itemId, mod);
        }
    }

    private void insertExplicitMods(int itemId, ArrayList<String> explicitMods, SqlSession session) {
        if (explicitMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : explicitMods) {
            mapper.insertExplicitMod(itemId, mod);
        }
    }

    private void insertFlavourText(int itemId, ArrayList<String> flavourText, SqlSession session) {
        if (flavourText == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String text : flavourText) {
            mapper.insertFlavourText(itemId, text);
        }
    }

    private void insertFracturedMods(int itemId, ArrayList<String> fracturedMod, SqlSession session) {
        if (fracturedMod == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : fracturedMod) {
            mapper.insertFracturedMod(itemId, mod);
        }
    }

    private void insertImplicitMods(int itemId, ArrayList<String> implicitMod, SqlSession session) {
        if (implicitMod == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : implicitMod) {
            mapper.insertImplicitMod(itemId, mod);
        }
    }

    private void insertScourgeMods(int itemId, ArrayList<String> scourgeMods, SqlSession session) {
        if (scourgeMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : scourgeMods) {
            mapper.insertScourgeMod(itemId, mod);
        }
    }

    private void insertUtilityMods(int itemId, ArrayList<String> utilityMods, SqlSession session) {
        if (utilityMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : utilityMods) {
            mapper.insertUtilityMod(itemId, mod);
        }
    }

    private void insertVeiledMods(int itemId, ArrayList<String> veiledMods, SqlSession session) {
        if (veiledMods == null) {
            return;
        }

        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : veiledMods) {
            mapper.insertVeiledMod(itemId, mod);
        }
    }

    // TODO: figure out how to insert FrameType, influences
    public void insertItem(ItemDTO item, SqlSession session) {
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to insert ItemDTO object.");
        mapper.saveEntity(item);
        ItemDAOLogger.trace("ItemDTO insert attempt finished. Putting ItemID into child objects and inserting.");

        insertCosmeticMods(item.getDbId(), item.getCosmeticMods(), session);
        insertCraftedMods(item.getDbId(), item.getCraftedMods(), session);
        insertEnchantMods(item.getDbId(), item.getEnchantMods(), session);
        insertExplicitMods(item.getDbId(), item.getExplicitMods(), session);
        insertFlavourText(item.getDbId(), item.getFlavourText(), session);
        insertFracturedMods(item.getDbId(), item.getFracturedMods(), session);
        insertImplicitMods(item.getDbId(), item.getImplicitMods(), session);
        insertScourgeMods(item.getDbId(), item.getScourgeMods(), session);
        insertUtilityMods(item.getDbId(), item.getUtilityMods(), session);
        insertVeiledMods(item.getDbId(), item.getVeiledMods(), session);

        //item socket
        ArrayList<ItemSocketDTO> itemSockets = item.getSockets();
        if (itemSockets != null) {
            for (ItemSocketDTO nextSocket : itemSockets) {
                nextSocket.setItemId(item.getDbId());
            }
            ItemSocketDAO itemSocketDAO = new ItemSocketDAO();
            itemSocketDAO.insertItemSocketById(itemSockets, session);
        }

        ItemPropertyDAO itemPropertyDAO = new ItemPropertyDAO();

        // properties
        ArrayList<ItemPropertyDTO> properties = item.getProperties();
        if (properties != null) {
            for (ItemPropertyDTO property : properties) {
                property.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(properties, session);
        }

        // notable properties
        ArrayList<ItemPropertyDTO> notableProperties = item.getNotableProperties();
        if (notableProperties != null) {
            for (ItemPropertyDTO notableProperty : notableProperties) {
                notableProperty.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(notableProperties, session);
        }

        // item requirements
        ArrayList<ItemPropertyDTO> requirements = item.getRequirements();
        if (requirements != null) {
            for (ItemPropertyDTO requirement : requirements) {
                requirement.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(requirements, session);
        }

        // additional properties
        ArrayList<ItemPropertyDTO> additionalProperties = item.getAdditionalProperties();
        if (additionalProperties != null) {
            for (ItemPropertyDTO additionalProperty : additionalProperties) {
                additionalProperty.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(additionalProperties, session);
        }

        //next level requirements
        ArrayList<ItemPropertyDTO> nextLevelRequirements = item.getNextLevelRequirements();
        if (nextLevelRequirements != null) {
            for (ItemPropertyDTO nextlevelRequirement : nextLevelRequirements) {
                nextlevelRequirement.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(nextLevelRequirements, session);
        }

        //rewards
        ItemDAOLogger.trace("Planning to insert rewards");
        ArrayList<RewardsDTO> rewards = item.getRewards();
        if (rewards != null) {
            ItemDAOLogger.trace("rewards is not null for item id = {} where rewards == {}", item.getId(), rewards);
            for (RewardsDTO nextReward : rewards) {
                nextReward.setItemId(item.getDbId());
            }
            RewardsDAO rewardsDAO = new RewardsDAO();
            rewardsDAO.insertRewards(rewards, session);
            ItemDAOLogger.trace("inserted reward");
        }

        //logbook mods
        ArrayList<LogbookModsDTO> logbookMods = item.getLogbookMods();
        if (logbookMods != null) {
            for (LogbookModsDTO logbookMod : logbookMods) {
                logbookMod.setItemId(item.getDbId());
            }
            LogbookModsDAO logbookModsDAO = new LogbookModsDAO();
            logbookModsDAO.insertLogbookMods(logbookMods, session);
        }

        //ultimatum mods
        ArrayList<UltimatumModsDTO> ultimatumMods = item.getUltimatumMods();
        if (ultimatumMods != null) {
            for (UltimatumModsDTO ultimatumMod : ultimatumMods) {
                ultimatumMod.setItemId(item.getDbId());
            }
            UltimatumModsDAO ultimatumModsDAO = new UltimatumModsDAO();
            ultimatumModsDAO.insertUltimatumModsById(ultimatumMods, session);
        }

        IncubatedItemDTO incubatedItem = item.getIncubatedItem();
        if (incubatedItem != null) {
            incubatedItem.setItemId(item.getDbId());
            IncubatedItemDAO incubatedItemDAO = new IncubatedItemDAO();
            incubatedItemDAO.insertIncubatedItem(incubatedItem, session);
        }

        ScourgedDTO scourged = item.getScourged();
        if (scourged != null) {
            scourged.setItemId(item.getDbId());
            ScourgedDAO scourgedDAO = new ScourgedDAO();
            scourgedDAO.insertScourged(scourged, session);
        }

        HybridDTO hybrid = item.getHybrid();
        if (hybrid != null) {
            hybrid.setItemId(item.getDbId());
            HybridDAO hybridDAO = new HybridDAO();
            hybridDAO.insertHybrid(hybrid, session);
        }

        ExtendedDTO extended = item.getExtended();
        if (extended != null) {
            extended.setItemId(item.getDbId());
            ExtendedDAO extendedDAO = new ExtendedDAO();
            extendedDAO.insertExtended(extended, session);
        }
    }
}
