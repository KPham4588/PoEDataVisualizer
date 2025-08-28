package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.ExtendedDTO;

public interface IExtendedDTO extends IBaseDAO<ExtendedDTO> {
    void saveSubcategories(int extendedId, String subcategory);
}
