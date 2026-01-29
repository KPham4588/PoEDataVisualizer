package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.InfluencesDTO;

public interface IInfluencesDTO extends IBaseDAO<InfluencesDTO> {
    InfluencesDTO getEntityByItemId(int id);
}
