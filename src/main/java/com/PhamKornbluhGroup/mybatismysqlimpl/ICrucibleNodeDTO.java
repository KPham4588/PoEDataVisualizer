package com.PhamKornbluhGroup.mybatismysqlimpl;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;

import java.util.List;

public interface ICrucibleNodeDTO extends IBaseDAO<CrucibleNodeDTO> {
    List<CrucibleNodeDTO> getEntityByCrucibleId(int id);
}
