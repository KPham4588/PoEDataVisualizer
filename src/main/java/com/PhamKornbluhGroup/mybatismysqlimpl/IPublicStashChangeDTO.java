package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IPublicStashChangeDTO extends IBaseDAO<PublicStashChangeDTO> {

    ArrayList<PublicStashChangeDTO> findStashesByItemNameAndLeague(@Param("itemName") String itemName,
                                                                   @Param("league") String league);
}
