package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.UltimatumModsDTO;

import java.util.ArrayList;

public interface IUltimatumModsDTO extends IBaseDAO<UltimatumModsDTO> {
    ArrayList<UltimatumModsDTO> getEntityByItemId(int dbId);
}
