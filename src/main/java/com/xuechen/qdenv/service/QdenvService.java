package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.*;

import java.util.List;

public interface QdenvService {
    public Wt09 saveWt09(Wt09Dto wt09Dto);
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
    public List<Bz03Dto> queryBz03List(Bz03Dto bz03Dto);
    public List<Bz06Dto> queryBz06(Page page,Bz06Dto bz06Dto);
    public List<Bz06Dto> queryBz06List(Bz06Dto bz06Dto);
    public Bz06 saveOrUpdateBz06(Bz06Dto bz06Dto);
    public String getWat016(String wat015);
    public Wt01 saveWt(Wt01Dto wt01Dto);
    public Wt01 saveWt(Wt01Dto wt01Dto, List<Wt02Dto> wt02Dtos, List<Wt03Dto> wt03Dtos);
    public Wt05 saveWt05(Wt05 wt05);
    public void saveWt02(List<Wt02Dto> wt02Dtos);
    public void updateWt02(Wt02Dto wt02Dto,String flag);
    public Wt03 saveOrUpdateWt03(Wt03Dto wt03Dto);
    public void updateWt03(List<Wt03Dto> wt03Dtos);
    public List<Wp01Dto> queryWp01List(Wp01Dto wp01Dto);
    public  List<Wt04> getWt04List(String bcz001s,Integer wct001,Integer wbt001);
    public void saveWt04List(List<Wt04> wt04s);
    public List<Wt01Dto> queryWtList(Wt01Dto dto);
    public List<Wt01Dto> queryWt(Page page,Wt01Dto dto);
    public List<Wt02Dto> queryWt02(Wt02Dto wt02Dto);
    public List<Wt03Dto> queryWt03(Wt03Dto wt03Dto);
    public List<Wt04Dto> queryWt04(Wt04Dto wt04Dto);
    public List<Wt06Dto> queryWt06(Boolean isPermission);
    public List<Wt08Dto> queryWt08ByWat001(Integer wat001);
    public void saveWt08List(Wt01Dto wt01Dto,List<Wt08> wt08s);
    public Wt01Dto saveNextProcess(Wt01Dto wt01Dto);
    public Wt01Dto savePreProcess(Wt01Dto wt01Dto);
    public Wt02Dto queryWt02Report(Wt02Dto wt02Dto);
}
