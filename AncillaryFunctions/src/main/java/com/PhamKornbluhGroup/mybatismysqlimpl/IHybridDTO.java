package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.HybridDTO;

public interface IHybridDTO extends IBaseDAO<HybridDTO> {
    void insertExplicitMod(int hybridId, String mod);
}
