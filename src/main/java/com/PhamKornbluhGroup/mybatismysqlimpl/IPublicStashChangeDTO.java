package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IPublicStashChangeDTO extends IBaseDAO<PublicStashChangeDTO> {

    ArrayList<PublicStashChangeDTO> findStashesByItemNameAndLeague(@Param("itemName") String itemName,
                                                                   @Param("league") String league);

    ArrayList<PublicStashChangeDTO> findStashesByCustomParameters(
            @Param("accountName") String accountName,
            @Param("artFilename") String artFilename,
            @Param("baseType") String baseType,
            @Param("colour") String colour,
            @Param("flavourTextNote") String flavourTextNote,
            @Param("forum_note") String forum_note,
            @Param("icon") String icon,
            @Param("inventoryId") String inventoryId,
            @Param("league") String league,
            @Param("name") String name,
            @Param("note") String note,
            @Param("prophecyText") String prophecyText,
            @Param("rarity") String rarity,
            @Param("secDescrText") String secDescrText,
            @Param("stackSizeText") String stackSizeText,
            @Param("typeLine") String typeLine,
            @Param("abyssJewel") String abyssJewel,
            @Param("cisRaceReward") String cisRaceReward,
            @Param("corrupted") String corrupted,
            @Param("delve") String delve,
            @Param("duplicated") String duplicated,
            @Param("elder") String elder,
            @Param("foreseeing") String foreseeing,
            @Param("fractured") String fractured,
            @Param("identified") String identified,
            @Param("isRelic") String isRelic,
            @Param("lockedToAccount") String lockedToAccount,
            @Param("lockedToCharacter") String lockedToCharacter,
            @Param("memoryItem") String memoryItem,
            @Param("replica") String replica,
            @Param("ruthless") String ruthless,
            @Param("seaRaceReward") String seaRaceReward,
            @Param("searing") String searing,
            @Param("shaper") String shaper,
            @Param("split") String split,
            @Param("support") String support,
            @Param("synthesised") String synthesised,
            @Param("tangled") String tangled,
            @Param("thRaceReward") String thRaceReward,
            @Param("unmodifiable") String unmodifiable,
            @Param("veiled") String veiled,
            @Param("verified") String verified,
            @Param("unmodifiableExceptChaos") String unmodifiableExceptChaos,
            @Param("foilVariation") String foilVariation,
            @Param("ilvl") String ilvl,
            @Param("itemLevel") String itemLevel,
            @Param("maxStackSize") String maxStackSize,
            @Param("stackSize") String stackSize,
            @Param("talismanTier") String talismanTier,
            @Param("socket") String socket);
}
