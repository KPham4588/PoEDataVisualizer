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

    public void insertItems(ArrayList<ItemDTO> items) {
        if (items == null) {
            return;
        }

        System.out.println("Attempting to insert ItemDTO objects in list.");
        for (ItemDTO item : items) {
            insertItem(item);
        }

        System.out.println("Finished inserting list of items.");
    }

    private void insertCosmeticMods(int itemId, ArrayList<String> cosmeticMods) {
        if (cosmeticMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : cosmeticMods) {
            mapper.insertCosmeticMod(itemId, mod);
        }
        session.commit();
    }

    private void insertCraftedMods(int itemId, ArrayList<String> craftedMods) {
        if (craftedMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : craftedMods) {
            mapper.insertCraftedMod(itemId, mod);
        }
        session.commit();
    }

    private void insertEnchantMods(int itemId, ArrayList<String> enchantMods) {
        if (enchantMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : enchantMods) {
            mapper.insertEnchantMod(itemId, mod);
        }
        session.commit();
    }

    private void insertExplicitMods(int itemId, ArrayList<String> explicitMods) {
        if (explicitMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : explicitMods) {
            mapper.insertExplicitMod(itemId, mod);
        }
        session.commit();
    }

    private void insertFlavourText(int itemId, ArrayList<String> flavourText) {
        if (flavourText == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String text : flavourText) {
            mapper.insertFlavourText(itemId, text);
        }
        session.commit();
    }

    private void insertFracturedMods(int itemId, ArrayList<String> fracturedMod) {
        if (fracturedMod == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : fracturedMod) {
            mapper.insertFracturedMod(itemId, mod);
        }
        session.commit();
    }

    private void insertImplicitMods(int itemId, ArrayList<String> implicitMod) {
        if (implicitMod == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : implicitMod) {
            mapper.insertImplicitMod(itemId, mod);
        }
        session.commit();
    }

    private void insertScourgeMods(int itemId, ArrayList<String> scourgeMods) {
        if (scourgeMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : scourgeMods) {
            mapper.insertScourgeMod(itemId, mod);
        }
        session.commit();
    }

    private void insertUtilityMods(int itemId, ArrayList<String> utilityMods) {
        if (utilityMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : utilityMods) {
            mapper.insertUtilityMod(itemId, mod);
        }
        session.commit();
    }

    private void insertVeiledMods(int itemId, ArrayList<String> veiledMods) {
        if (veiledMods == null) {
            return;
        }

        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);

        for (String mod : veiledMods) {
            mapper.insertVeiledMod(itemId, mod);
        }
        session.commit();
    }

    // TODO: figure out how to insert FrameType, influences
    public void insertItem(ItemDTO item) {
        SqlSession session = SessionPool.getSession();
        IItemDTO mapper = session.getMapper(IItemDTO.class);
        ItemDAOLogger.trace("Attempting to insert ItemDTO object.");
        mapper.saveEntity(item);
        session.commit();
        ItemDAOLogger.trace("ItemDTO insert attempt finished. Putting ItemID into child objects and inserting.");

        insertCosmeticMods(item.getDbId(), item.getCosmeticMods());
        insertCraftedMods(item.getDbId(), item.getCraftedMods());
        insertEnchantMods(item.getDbId(), item.getEnchantMods());
        insertExplicitMods(item.getDbId(), item.getExplicitMods());
        insertFlavourText(item.getDbId(), item.getFlavourText());
        insertFracturedMods(item.getDbId(), item.getFracturedMods());
        insertImplicitMods(item.getDbId(), item.getImplicitMods());
        insertScourgeMods(item.getDbId(), item.getScourgeMods());
        insertUtilityMods(item.getDbId(), item.getUtilityMods());
        insertVeiledMods(item.getDbId(), item.getVeiledMods());

        //item socket
        ArrayList<ItemSocketDTO> itemSockets = item.getSockets();
        if (itemSockets != null) {
            for (ItemSocketDTO socket : itemSockets) {
                socket.setItemId(item.getDbId());
            }
            ItemSocketDAO itemSocketDAO = new ItemSocketDAO();
            itemSocketDAO.insertItemSocketById(itemSockets);
        }

        ItemPropertyDAO itemPropertyDAO = new ItemPropertyDAO();

        // properties
        ArrayList<ItemPropertyDTO> properties = item.getProperties();
        if (properties != null) {
            for (ItemPropertyDTO property : properties) {
                property.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(properties);
        }

        // notable properties
        ArrayList<ItemPropertyDTO> notableProperties = item.getNotableProperties();
        if (notableProperties != null) {
            for (ItemPropertyDTO notableProperty : notableProperties) {
                notableProperty.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(notableProperties);
        }

        // item requirements
        ArrayList<ItemPropertyDTO> requirements = item.getRequirements();
        if (requirements != null) {
            for (ItemPropertyDTO requirement : requirements) {
                requirement.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(requirements);
        }

        // additional properties
        ArrayList<ItemPropertyDTO> additionalProperties = item.getAdditionalProperties();
        if (additionalProperties != null) {
            for (ItemPropertyDTO additionalProperty : additionalProperties) {
                additionalProperty.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(additionalProperties);
        }

        //next level requirements
        ArrayList<ItemPropertyDTO> nextLevelRequirements = item.getNextLevelRequirements();
        if (nextLevelRequirements != null) {
            for (ItemPropertyDTO nextlevelRequirement : nextLevelRequirements) {
                nextlevelRequirement.setItemId(item.getDbId());
            }
            itemPropertyDAO.insertItemProperties(nextLevelRequirements);
        }

        //rewards
        ArrayList<RewardsDTO> rewards = item.getRewards();
        if (rewards != null) {
            for (RewardsDTO reward : rewards) {
                reward.setItemId(item.getDbId());
            }
            RewardsDAO rewardsDAO = new RewardsDAO();
            rewardsDAO.insertRewards(rewards);
        }

        //logbook mods
        ArrayList<LogbookModsDTO> logbookMods = item.getLogbookMods();
        if (logbookMods != null) {
            for (LogbookModsDTO logbookMod : logbookMods) {
                logbookMod.setItemId(item.getDbId());
            }
            LogbookModsDAO logbookModsDAO = new LogbookModsDAO();
            logbookModsDAO.insertLogbookMods(logbookMods);
        }

        //ultimatum mods
        ArrayList<UltimatumModsDTO> ultimatumMods = item.getUltimatumMods();
        if (ultimatumMods != null) {
            for (UltimatumModsDTO ultimatumMod : ultimatumMods) {
                ultimatumMod.setItemId(item.getDbId());
            }
            UltimatumModsDAO ultimatumModsDAO = new UltimatumModsDAO();
            ultimatumModsDAO.insertUltimatumModsById(ultimatumMods);
        }

        IncubatedItemDTO incubatedItem = item.getIncubatedItem();
        if (incubatedItem != null) {
            incubatedItem.setItemId(item.getDbId());
            IncubatedItemDAO incubatedItemDAO = new IncubatedItemDAO();
            incubatedItemDAO.insertIncubatedItem(incubatedItem);
        }

        ScourgedDTO scourged = item.getScourged();
        if (scourged != null) {
            scourged.setItemId(item.getDbId());
            ScourgedDAO scourgedDAO = new ScourgedDAO();
            scourgedDAO.insertScourged(scourged);
        }

        HybridDTO hybrid = item.getHybrid();
        if (hybrid != null) {
            hybrid.setItemId(item.getDbId());
            HybridDAO hybridDAO = new HybridDAO();
            hybridDAO.insertHybrid(hybrid);
        }

        ExtendedDTO extended = item.getExtended();
        if (extended != null) {
            extended.setItemId(item.getDbId());
            ExtendedDAO extendedDAO = new ExtendedDAO();
            extendedDAO.insertExtended(extended);
        }
    }
}
