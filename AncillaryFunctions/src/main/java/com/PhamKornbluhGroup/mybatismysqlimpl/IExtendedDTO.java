package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.ExtendedDTO;

public interface IExtendedDTO extends IBaseDAO<ExtendedDTO> {
    void saveSubcategory(int extendedId, String subcategory);
}
