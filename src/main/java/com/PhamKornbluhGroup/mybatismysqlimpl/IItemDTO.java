package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.ItemDTO;

public interface IItemDTO extends IBaseDAO<ItemDTO> {
    void insertCosmeticMod(int itemId, String cosmeticMod);
    void insertCraftedMod(int itemId, String craftedMod);
    void insertEnchantMod(int itemId, String enchantMod);
    void insertExplicitMod(int itemId, String explicitMod);
    void insertFlavourText(int itemId, String flavourText);
    void insertFracturedMod(int itemId, String fracturedMod);
    void insertImplicitMod(int itemId, String implicitMod);
    void insertScourgeMod(int itemId, String scourgeMod);
    void insertUtilityMod(int itemId, String utilityMod);
    void insertVeiledMod(int itemId, String veiledMod);
}
