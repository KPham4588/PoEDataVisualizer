package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;

public interface ICrucibleDTO extends IBaseDAO<CrucibleDTO> {
    public CrucibleDTO getEntityByItemId(int dbId);
}
