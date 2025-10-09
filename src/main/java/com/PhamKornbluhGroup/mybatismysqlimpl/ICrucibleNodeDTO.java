package com.PhamKornbluhGroup.mybatismysqlimpl;

import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;

public interface ICrucibleNodeDTO extends IBaseDAO<CrucibleNodeDTO> {
    void insertStat(int crucibleNodeId, String stat);
    void insertOut(int crucibleNodeId, String out);
    void insertIn(int crucibleNodeId, String in);
}
