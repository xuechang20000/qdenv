package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.dto.Bz04Dto;

import java.util.List;

public interface QdenvService {
    public void saveBz04(Bz04 bz04);
    public void updateBz04(Bz04 bz04);
    public List<Bz04Dto> queryBz04(Page page, Bz04Dto bz04Dto);
}
