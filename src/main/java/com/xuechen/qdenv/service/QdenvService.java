package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz02;
import com.xuechen.qdenv.bo.Bz03;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.dto.Bz01Dto;
import com.xuechen.qdenv.dto.Bz02Dto;
import com.xuechen.qdenv.dto.Bz03Dto;
import com.xuechen.qdenv.dto.Bz04Dto;

import java.util.List;

public interface QdenvService {
    public void saveBz04(Bz04 bz04);
    public void updateBz04(Bz04 bz04);
    public List<Bz04Dto> queryBz04(Page page, Bz04Dto bz04Dto);
    public List<Bz04Dto> queryBz04(Bz04Dto bz04Dto);
    public List<Bz01Dto> queryBz01(Page page, Bz01Dto bz01Dto);
    public List<Bz01Dto> queryBz01( Bz01Dto bz01Dto);
    public void saveBz01(Bz01Dto bz01Dto);
    public void updateBz01(Bz01Dto bz01Dto);
    public List<Bz02Dto> queryBz02(Page page, Bz02Dto dto);
    public List<Bz02Dto> queryBz02(Bz02Dto dto);
    public List<Bz02> saveBz02(List<Bz02> bz02s);
    public void CopyBz01(Bz01Dto bz01Dto);
    public Bz03 saveBz03(Bz03Dto bz03Dto);
    public void deleteBz03(Bz03Dto bz03Dto);
    public List<Bz03Dto> queryBz03(Page page,Bz03Dto bz03Dto);
}
