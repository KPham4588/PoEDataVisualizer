package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;

public interface ICrucibleNodeDTO extends IBaseDAO<CrucibleNodeDTO> {
    // Keeping this within MyBatis Config, only able to be used within the parent Crucible ResultMap Query "getEntityById"
    // List<CrucibleNodeDTO> getEntityByCrucibleId(int id);
}
