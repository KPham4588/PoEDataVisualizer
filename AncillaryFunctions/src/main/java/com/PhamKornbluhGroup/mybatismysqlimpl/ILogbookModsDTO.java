package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.LogbookModsDTO;

public interface ILogbookModsDTO extends IBaseDAO<LogbookModsDTO> {
    void insertMod(int logbookModsId, String mod);
}
