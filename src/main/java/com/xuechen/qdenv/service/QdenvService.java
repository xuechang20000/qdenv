package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.*;

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
    public String getWat016(String wat015);
    public Wt01 saveWt(Wt01Dto wt01Dto, List<Wt02Dto> wt02Dtos, List<Wt03Dto> wt03Dtos);
    public Wt05 saveWt05(Wt05 wt05);
    public void saveWt02(List<Wt02Dto> wt02Dtos);
    public Wt03 saveOrUpdateWt03(Wt03Dto wt03Dto);
    public  List<Wt04> getWt04List(String bcz001s,Integer wct001,Integer wbt001);
    public void saveWt04List(List<Wt04> wt04s);
}
