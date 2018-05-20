package com.xuechen.qdenv.service;

import cn.hutool.core.date.DateUtil;
import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.core.utils.StringTools;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.*;
import com.xuechen.web.bo.AppDictDetail;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.exception.BusinessException;
import com.xuechen.web.utils.ContextUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * 业务service
 */
@Service
public class QdenvServiceImpl implements QdenvService {
    private static Logger logger= Logger.getLogger(QdenvServiceImpl.class);

    /**
     * 保存操作日志
     * @param wt09Dto
     * @return
     */
    public Wt09 saveWt09(Wt09Dto wt09Dto){
        Wt09 wt09=new Wt09();
        BeanUtils.copyProperties(wt09Dto,wt09);
        wt09.setWgt004(new Date());
        AppUserDTO user=(AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
        wt09.setWgt002(user.getUserId());
        wt09.setWgt003(user.getName());
        if (wt09.getWgt005()!=null){
            AppResource appResource
                    =CommonJdbcUtils.queryFirst("select resource_code as resourceCode,resource_name as resourceName from app_resource where resource_code=? ",
                    AppResource.class,wt09.getWgt005());
            if (appResource!=null) wt09.setWgt006(appResource.getResourceName());
        }

        CommonJdbcUtils.insert(wt09);
        return wt09;
    }

    /**
     * 保存操作日志
     * @param wat001
     * @param wgt005
     * @param aae013
     * @return
     */
    public Wt09 saveWt09(Integer wat001,String wgt005,String aae013 ){
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wat001);
        wt09Dto.setWgt005(wgt005);
        wt09Dto.setAae013(aae013);
        return saveWt09(wt09Dto);
    }
    /**
     *
     * 查询日志
     * @param wt09Dto
     * @return
     */
    public  List<Wt09Dto> queryWt09List(Page page,Wt09Dto wt09Dto){
        StringBuffer sb=new StringBuffer("select * from wt09 where 1=1 " );
        List<String> args=new ArrayList<String>();
        if (wt09Dto.getWat001()!=null){
            sb.append(" and wat001=? ");
            args.add(wt09Dto.getWat001().toString());
        }
        if (wt09Dto.getWgt001()!=null){
            sb.append(" and wgt001=? ");
            args.add(wt09Dto.getWgt001().toString());
        }
        sb.append(" order by wgt004 desc");
        CommonJdbcUtils.queryPageList(page,sb.toString(),Wt09Dto.class,args.toArray());
        return page.getData();
    }

    /**
     * 保存行业
     */
    public void saveBz04(Bz04 bz04){
        bz04.setBhz003(bz04.getBhz003().toUpperCase());
        CommonJdbcUtils.insert(bz04);
    }
    /**
     * 更新行业
     */
    public void updateBz04(Bz04 bz04){
        CommonJdbcUtils.updateSelect(bz04);
    }


    /**
     * 生成查询行业的语句
     * @param args
     * @param bz04Dto
     * @return
     */
    public String generateQueryBz04(List<Object> args,Bz04Dto bz04Dto){
        StringBuffer sql=new StringBuffer("select * from bz04 where 1=1 " );
        if (bz04Dto.getBhz001()!=null){
            sql.append("and bhz001= ? ");
            args.add(bz04Dto.getBhz001());
        }
        if (bz04Dto.getAae016()!=null){
            sql.append("and aae016= ? ");
            args.add(bz04Dto.getAae016());
        }
        if (bz04Dto.getBzh002()!=null){
            sql.append("and bhz002 like ? ");
            args.add("%"+bz04Dto.getBzh002()+"%");
        }
        return sql.toString();
    }
    /**
     *查询行业,分页
     * @param bz04Dto
     * @return
     */
    public List<Bz04Dto> queryBz04(Page page, Bz04Dto bz04Dto){
        String sql="";
        List<Object> args=new ArrayList<Object>();
        sql=generateQueryBz04(args,bz04Dto);
        CommonJdbcUtils.queryPageList(page,sql.toString(),Bz04Dto.class,args.toArray());
        return  page.getData();
    }
    /**
     *查询行业,不分页
     * @param bz04Dto
     * @return
     */
    public List<Bz04Dto> queryBz04(Bz04Dto bz04Dto){
        String sql="";
        List<Object> args=new ArrayList<Object>();
        sql=generateQueryBz04(args,bz04Dto);
        return CommonJdbcUtils.queryList(sql.toString(),Bz04Dto.class,args.toArray());
    }
    /**
     * 保存标准
     */
    public void saveBz01(Bz01Dto bz01Dto){
        if (bz01Dto.getBbz001()!=null){
            updateBz01(bz01Dto);
            return;
        }
        /**保存标准*/
        Bz01 bz01=new Bz01();
        BeanUtils.copyProperties(bz01Dto,bz01);
        CommonJdbcUtils.insert(bz01);
        /**保存检测项目*/
        if(bz01Dto.getList()!=null&&bz01Dto.getList().size()>0) {
            List<Bz02> bz02s = new ArrayList<Bz02>();
            Bz02 bz02 = null;
            for (Bz02Dto bz02Dto : bz01Dto.getList()) {
                bz02 = new Bz02();
                BeanUtils.copyProperties(bz02Dto, bz02);
                bz02s.add(bz02);
            }

        CommonJdbcUtils.insertBatch(bz02s);
        }
        /**保存标准行业对应*/
        if (bz01Dto.getBhz001s()!=null&&bz01Dto.getBhz001s().length>0) {
            Bz05 bz05 = null;
            for (int i = 0; i < bz01Dto.getBhz001s().length; i++) {
                bz05 = new Bz05();
                bz05.setBhz001(Integer.valueOf(bz01Dto.getBhz001s()[i]));
                bz05.setBbz001(bz01.getBbz001());
                CommonJdbcUtils.insert(bz05);
            }
        }
    }
    /**
     * 更新标准
     */
    public void updateBz01(Bz01Dto bz01Dto){
        /**更新标准* */
        Bz01 bz01=new Bz01();
        BeanUtils.copyProperties(bz01Dto,bz01);
        CommonJdbcUtils.updateSelect(bz01);
        /**更新检测项目*/
        if(bz01Dto.getList()!=null&&bz01Dto.getList().size()>0) {
            Bz02 bz02 = null;
            for (Bz02Dto bz02Dto : bz01Dto.getList()) {
                bz02 = new Bz02();
                BeanUtils.copyProperties(bz02Dto, bz02);
                CommonJdbcUtils.saveOrUpdateObject(bz02, true);
            }
        }
        /**保存标准行业对应*/
        if (bz01Dto.getBhz001s()!=null&&bz01Dto.getBhz001s().length>0) {
            CommonJdbcUtils.execute("delete from bz05 where bbz001=?", bz01Dto.getBbz001());
            Bz05 bz05 = null;
            for (int i = 0; i < bz01Dto.getBhz001s().length; i++) {
                bz05 = new Bz05();
                bz05.setBhz001(Integer.valueOf(bz01Dto.getBhz001s()[i]));
                bz05.setBbz001(bz01.getBbz001());
                CommonJdbcUtils.insert(bz05);
            }
        }
    }
    /**
     * 更新标准
     */
    public void CopyBz01(Bz01Dto bz01Dto){
        /**保存标准* */
        Bz01 bz01=new Bz01();
        BeanUtils.copyProperties(bz01Dto,bz01);
        bz01.setBbz001(null);
        CommonJdbcUtils.insert(bz01);
        /**更新检测项目*/
      String sql="insert into bz02(bbz001,bcz002,bcz003,bcz004,bcz005,bcz006,bcz007,bcz008,bcz009) " +
              " select ?,bcz002,bcz003,bcz004,bcz005,bcz006,bcz007,bcz008,bcz009 from bz02  where bbz001=? ";
      CommonJdbcUtils.execute(sql,bz01.getBbz001(),bz01Dto.getBbz001());
        /**保存标准行业对应*/
        if (bz01Dto.getBhz001s()!=null&&bz01Dto.getBhz001s().length>0) {
            CommonJdbcUtils.execute("delete from bz05 where bbz001=?", bz01.getBbz001());
            Bz05 bz05 = null;
            for (int i = 0; i < bz01Dto.getBhz001s().length; i++) {
                bz05 = new Bz05();
                bz05.setBhz001(Integer.valueOf(bz01Dto.getBhz001s()[i]));
                bz05.setBbz001(bz01.getBbz001());
                CommonJdbcUtils.insert(bz05);
            }
        }
    }

    /**
     * 生成查询标准的语句
     * @param args
     * @param bz01Dto
     * @return
     */
    public String generateQueryBz01(List<Object> args,Bz01Dto bz01Dto){
        StringBuffer sb=new StringBuffer();
        sb.append("SELECT A.BBZ001,                                        ");
        sb.append("       A.BBZ002,                                        ");
        sb.append("       A.BBZ003,                                        ");
        sb.append("       A.BBZ004,                                        ");
        sb.append("       A.BBZ005,                                        ");
        sb.append("       A.BBZ006,                                        ");
        sb.append("       A.AAE013,                                        ");
        sb.append("       A.AAE016,                                        ");
        sb.append("       A.BMZ003,                                        ");
        sb.append("       GROUP_CONCAT(D.BZH002) AS bzh002s,                ");
        sb.append("       GROUP_CONCAT(D.BHZ001) AS bhz001i                ");
        sb.append("  FROM BZ01 A                                           ");
        sb.append("  LEFT OUTER JOIN (SELECT B.BZH002, B.BHZ001, C.BBZ001  ");
        sb.append("                     FROM BZ04 B, BZ05 C                ");
        sb.append("                    WHERE B.BHZ001 = C.BHZ001           ");
        sb.append("                      AND B.AAE016 = '1') D             ");
        sb.append("    ON A.BBZ001 = D.BBZ001                              ");
        sb.append(" WHERE 1=1                                   ");
        if(bz01Dto.getAae016()!=null){
            sb.append(" and a.aae016=? ");
            args.add(bz01Dto.getAae016());
        }
        if(bz01Dto.getBbz001()!=null){
            sb.append(" and a.bbz001=? ");
            args.add(bz01Dto.getBbz001());
        }
        if(bz01Dto.getBbz002()!=null){
            sb.append(" and a.bbz002 like ? ");
            args.add("%"+bz01Dto.getBbz002()+"%");
        }
        if(bz01Dto.getBbz004()!=null){
            sb.append(" and a.bbz004 like ? ");
            args.add("%"+bz01Dto.getBbz004()+"%");
        }
        sb.append(" GROUP BY A.BBZ001                                      ");
        return sb.toString();
    }
    /**
     *查询标准,分页
     * @param bz01Dto
     * @return
     */
    public List<Bz01Dto> queryBz01(Page page, Bz01Dto bz01Dto){
        String sql="";
        List<Object> args=new ArrayList<Object>();
        sql=generateQueryBz01(args,bz01Dto);
        CommonJdbcUtils.queryPageList(page,sql.toString(),Bz01Dto.class,args.toArray());
        return  page.getData();
    }
    /**
     *查询标准,不分页
     * @param bz01Dto
     * @return
     */
    public List<Bz01Dto> queryBz01(Bz01Dto bz01Dto){
        String sql="";
        List<Object> args=new ArrayList<Object>();
        sql=generateQueryBz01(args,bz01Dto);
        return CommonJdbcUtils.queryList(sql.toString(),Bz01Dto.class,args.toArray());
    }

    /**
     * 根据标准id查询检测项目列表
     * @param dto
     * @return
     */
    public List<Bz02Dto> queryBz02(Page page,Bz02Dto dto){
        String sql="select a.*,case WHEN bcz003='5' THEN CONCAT_WS('~',bcz004,bcz005) ELSE bcz004 end as bcz0045 " +
                "from bz02 a where bbz001=? order by bcz007 asc";
         CommonJdbcUtils.queryPageList(page,sql,Bz02Dto.class,dto.getBbz001());
         return  page.getData();
    }
    /**
     * 根据标准id查询检测项目列表
     * @param dto
     * @return
     */
    public List<Bz02Dto> queryBz02(Bz02Dto dto){
        String sql="select a.*,case WHEN bcz003='5' THEN CONCAT_WS('~',bcz004,bcz005) ELSE bcz004 end as bcz0045 " +
                "from bz02 a where bbz001=? order by bcz007 asc";
       return CommonJdbcUtils.queryList(sql,Bz02Dto.class,dto.getBbz001());
    }
    /**
     * 保存标准下的检测项目
     * @param bz02s
     * @return
     */
    public List<Bz02> saveBz02(List<Bz02> bz02s){
        if (bz02s==null||bz02s.size()==0) return null;
        CommonJdbcUtils.execute("delete from bz02 where bbz001=?",bz02s.get(0).getBbz001());
        CommonJdbcUtils.insertBatch(bz02s);
        return bz02s;
    }

    /**
     * 保存分组
     * @param bz03Dto
     * @return
     */
    public Bz03 saveBz03(Bz03Dto bz03Dto){
        Bz03 bz03=new Bz03();
        BeanUtils.copyProperties(bz03Dto,bz03);
        CommonJdbcUtils.insert(bz03);
        return bz03;
    }

    /**
     * 删除分组
     * @param bz03Dto
     */
    public void deleteBz03(Bz03Dto bz03Dto){
        String sql="delete from bz03 where bzz001=? ";
        if (bz03Dto.getBzz001()!=null)
        CommonJdbcUtils.execute(sql,bz03Dto.getBzz001());
    }

    /**
     * 查询分组情况
     * @param page
     * @param bz03Dto
     * @return
     */
    public List<Bz03Dto> queryBz03(Page page,Bz03Dto bz03Dto){
    String sql="select a.*,(select GROUP_CONCAT(b.bcz002) from bz02 b where b.bbz001=a.bbz001  and FIND_IN_SET(b.bcz001,a.bzz003) GROUP BY b.bbz001) as bzz003s \n" +
            "from bz03 a where a.bbz001= ? ";
            CommonJdbcUtils.queryPageList(page,sql,Bz03Dto.class,bz03Dto.getBbz001());
            return  page.getData();
    }
    /**
     * 查询分组情况
     * @param bz03Dto
     * @return
     */
    public List<Bz03Dto> queryBz03List(Bz03Dto bz03Dto){
        String sql="select a.*,(select GROUP_CONCAT(b.bcz002) from bz02 b where b.bbz001=a.bbz001  and FIND_IN_SET(b.bcz001,a.bzz003) GROUP BY b.bbz001) as bzz003s \n" +
                "from bz03 a where a.bbz001= ? ";
        return  CommonJdbcUtils.queryList(sql,Bz03Dto.class,bz03Dto.getBbz001());
    }

    /**
     * 生成查询仪器语句
     * @param args
     * @param bz06Dto
     * @return
     */
    public String generateQueryBz06Sql( List<String> args,Bz06Dto bz06Dto){
        StringBuffer sb=new StringBuffer("SELECT  a.*, CONCAT(a.bmz002, '(', b.`dict_name`, ')') AS bmz002s " +
                " FROM  bz06 a,  app_dict_detail b " +
                " WHERE a.bmz003 = b.`dict_val`   AND b.`dict_code` = 'BMZ003'");
        if (bz06Dto.getBmz001()!=null){
            sb.append(" and a.bmz001=? ");
            args.add(bz06Dto.getBmz001().toString());
        }
        if (bz06Dto.getBmz003()!=null){
            sb.append(" and a.bmz003=? ");
            args.add(bz06Dto.getBmz003());
        }
        if (StringTools.hasText(bz06Dto.getBmz002())){
            sb.append(" and a.bmz002 like ?");
            args.add("%"+bz06Dto.getBmz002()+"%");
        }
        if (bz06Dto.getAae016()!=null){
            sb.append(" and a.aae016=? ");
            args.add(bz06Dto.getAae016());
        }
        sb.append(" order by a.bmz003 ");
        return  sb.toString();
    }
    /**
     * 查询仪器列表
     * @param page
     * @param bz06Dto
     * @return
     */
    public List<Bz06Dto> queryBz06(Page page,Bz06Dto bz06Dto){
        List<String> args=new ArrayList<String>();
        String sql=generateQueryBz06Sql(args,bz06Dto);
        CommonJdbcUtils.queryPageList(page,sql,Bz06Dto.class,args.toArray());
        return page.getData();
    }
    /**
     * 查询仪器列表
     * @param bz06Dto
     * @return
     */
    public List<Bz06Dto> queryBz06List(Bz06Dto bz06Dto){
        List<String> args=new ArrayList<String>();
        String sql=generateQueryBz06Sql(args,bz06Dto);
        return  CommonJdbcUtils.queryList(sql,Bz06Dto.class,args.toArray());
    }

    /**
     * 保存或者更改仪器
     * @param bz06Dto
     * @return
     */
    public Bz06 saveOrUpdateBz06(Bz06Dto bz06Dto){
        Bz06 bz06=new Bz06();
        BeanUtils.copyProperties(bz06Dto,bz06);
        CommonJdbcUtils.saveOrUpdateObject(bz06,false);
        return  bz06;
    }
    /**
     * 查询序号
     * @param wat015
     * @return
     */
    public String getWat016(String wat015){
        String sql="select max(wat016) from wt01 where wat015=?";
        Long wat016=CommonJdbcUtils.queryObject(sql,Long.class,wat015);
        if (wat016==null) return "1";
        wat016=wat016+1;
        return String.valueOf(wat016);
    }

    /**
     * 保存委托附属信息
     * @param wt01Dto
     * @return
     */
    @Transactional
    public Wt01 saveWt(Wt01Dto wt01Dto){
        Wt01 wt01=new Wt01();
        if(wt01Dto.getWat001()==null) return wt01;
        BeanUtils.copyProperties(wt01Dto,wt01);
        CommonJdbcUtils.updateSelect(wt01);
        if (wt01.getWat013()!=null){
            /**
             * 保存日志
             */
            String aae013=String.format("附属信息-快递单号：%s",wt01.getWat014());
            saveWt09(wt01Dto.getWat001(),"DO_6",aae013);
        }
        return  wt01;
    }
    /**
     * 保存委托表
     * @param wt01Dto
     * @param wt02Dtos
     * @param wt03Dtos
     * @return
     */
    @Transactional
    public Wt01 saveWt(Wt01Dto wt01Dto,List<Wt02Dto> wt02Dtos,List<Wt03Dto> wt03Dtos){
        Wt01 wt01=new Wt01();
        BeanUtils.copyProperties(wt01Dto,wt01);
        wt01.setWat017(new Date());
        //保存状态
    if(wt01.getWat001()==null) {
        wt01.setWat010(wt01.getDaw005());//邮寄地址
        wt01.setWat011(wt01.getDaw003());//邮寄人
        wt01.setWat012(wt01.getDaw004());//邮寄电话
        if (wt01.getWat004() != null) {
            wt01.setWat018("LC_ORD");//预约状态
        } else {
            wt01.setWat018("LC_INI");//新建状态
        }
    }
        //保存主表
        CommonJdbcUtils.saveOrUpdateObject(wt01,false);
        //保存财务表
        Wt05 wt05=null;
        if (wt01Dto.getWat001()!=null)
        wt05=CommonJdbcUtils.queryFirst("select * from wt05 where wat001=? ",Wt05.class,wt01Dto.getWat001());
        else
        wt05=new Wt05();

        wt05.setWat001(wt01.getWat001());
    if (wt01Dto.getWft002()!=null&&!wt01Dto.getWft002().trim().equals(""))
        wt05.setWft002(Double.valueOf(wt01Dto.getWft002()));
    if (wt01Dto.getWft003()!=null&&!wt01Dto.getWft003().trim().equals(""))
        wt05.setWft003(Double.valueOf(wt01Dto.getWft003()));
    if (wt01Dto.getWft004()!=null&&!wt01Dto.getWft004().trim().equals(""))
        wt05.setWft004(Double.valueOf(wt01Dto.getWft004()));
    if (wt01Dto.getWft005()!=null&&!wt01Dto.getWft005().trim().equals(""))
        wt05.setWft005(Double.valueOf(wt01Dto.getWft005()));
    if (wt01Dto.getWft006()!=null&&!wt01Dto.getWft006().trim().equals(""))
        wt05.setWft006(Double.valueOf(wt01Dto.getWft006()));
    if (wt01Dto.getWft007()!=null&&!wt01Dto.getWft007().trim().equals(""))
        wt05.setWft007(Double.valueOf(wt01Dto.getWft007()));
    if (wt01Dto.getWft031()!=null&&!wt01Dto.getWft031().trim().equals(""))
        wt05.setWft031(wt01Dto.getWft031());

        wt05.setWat001(wt01.getWat001());
        wt05.setAae013("");
        saveWt05(wt05);
        if (wt03Dtos!=null) {
            //保存采样点
            for (Wt03Dto wt03Dto : wt03Dtos) {
                if (wt03Dto.getWbt001()!=null&&!"".equals(wt03Dto.getWbt001()))
                {
                    wt03Dto.setWat001(wt01.getWat001());
                    saveOrUpdateWt03(wt03Dto);
                    continue;
                }
                for (Wt02Dto wt02Dto : wt02Dtos) {
                    if (wt02Dto.getIdx().equals(wt03Dto.getIdx())) {
                        if (wt02Dto.getWt03DtoList() == null) wt02Dto.setWt03DtoList(new ArrayList<Wt03Dto>());
                        wt03Dto.setWat001(wt01.getWat001());
                        wt02Dto.setWat001(wt01.getWat001());
                        wt02Dto.getWt03DtoList().add(wt03Dto);
                    }
                }
            }
        }
        saveWt02(wt02Dtos);
        /**
         * 保存日志
         */
        String aae013=(wt01Dto.getWat001()!=null?"修改委托信息":"新增加委托信息");
        saveWt09(wt01.getWat001(),wt01.getWat018(),aae013);

        return wt01;

}

    /**
     * 保存财务表
     * @param wt05
     * @return
     */
    public Wt05 saveWt05(Wt05 wt05){
        CommonJdbcUtils.saveOrUpdateObject(wt05,false);
        /**
         * 保存日志
         */
        String aae013=String.format("财务信息:应收总费用%s，其中采样费用%s、检测费用%s、折扣率%s。"
        ,wt05.getWft007(),wt05.getWft002(),wt05.getWft004(), wt05.getWft006());
        saveWt09(wt05.getWat001(),"DO_3",aae013);
        return wt05;
    }
    /**
     * 保存报告（标准）
     * @param wt02Dtos
     */
@Transactional
    public void saveWt02(List<Wt02Dto> wt02Dtos){
        Wt02 wt02=null;
        for (Wt02Dto wt02Dto:wt02Dtos){
            if ("removed".equals(wt02Dto.get_state())){
                //deleteWt02(wt02Dto.getWbt001());
                CommonJdbcUtils.execute("update wt02 set aae016='0' where wbt001=? ",wt02Dto.getWbt001());
                saveWt09(wt02Dto.getWat001(),"DO_3","删除报告:"+wt02.getWbt001());
                continue;
            }
            wt02=new Wt02();
            BeanUtils.copyProperties(wt02Dto,wt02);
            if (wt02.getWbt001()==null) wt02.setWbt002(new Date());
            CommonJdbcUtils.saveOrUpdateObject(wt02,false);
            if (wt02Dto.getWbt001()==null) {
                saveWt09(wt02.getWat001(),"DO_3","新增报告:"+wt02.getWbt001());
            }else {
                saveWt09(wt02.getWat001(),"DO_3","修改报告:"+wt02.getWbt001());
            }
            if (wt02Dto.getWt03DtoList()!=null) {
                for (Wt03Dto wt03Dto : wt02Dto.getWt03DtoList()) {
                    wt03Dto.setWbt001(wt02.getWbt001());
                    wt03Dto.setWat001(wt02.getWat001());
                    saveOrUpdateWt03(wt03Dto);
                }
            }
        }
    }

    /**
     *打印审核签发
     * @param wt02Dto
     * @param flag 1：打印，2：审核，3：签发
     */
    public void updateWt02(Wt02Dto wt02Dto,String flag){

        AppUserDTO appUserDTO=(AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
            Wt02 wt02=CommonJdbcUtils.queryFirst("select * from wt02 where wbt001=?",Wt02.class,wt02Dto.getWbt001());
            Wt02 wt021=new Wt02();
            BeanUtils.copyProperties(wt02Dto,wt021);
            if("1".equals(flag)){
                wt021.setWbt015(new Date());
                wt021.setWbt014(wt02.getWbt014()==null?1:wt02.getWbt014()+1);
                saveWt09(wt02.getWat001(),"DO_10","打印报告");
            }
            if("2".equals(flag)){
                wt021.setWbt008(appUserDTO.getUserId());
                wt021.setWbt009(new Date());
                saveWt09(wt02.getWat001(),"DO_9","审核报告");
            }
            if("3".equals(flag)){
                if ("1".equals(wt02Dto.getWbt016())&&!wt02Dto.getExt1().equals(appUserDTO.getExt1()))
                    throw new BusinessException("电子签名授权码不正确！");
                wt021.setWbt010(wt02Dto.getWbt010());
                wt021.setWbt011(StringTools.formatNowDate(null));
                saveWt09(wt02.getWat001(),"DO_8","签发报告");
            }
            CommonJdbcUtils.updateSelect(wt021);
    }

    public void deleteWt02(Integer wbt001){
        CommonJdbcUtils.execute("delete from wt02 where wbt001=?",wbt001);
    }
    /**
     * 添加采样点
     * @param wt03Dto
     * @return
     */
    @Transactional
    public Wt03 saveOrUpdateWt03(Wt03Dto wt03Dto){

        Wt03 wt03=new Wt03();
        BeanUtils.copyProperties(wt03Dto,wt03);
        if ("removed".equals(wt03Dto.get_state())){
           // deleteWt03(wt03Dto.getWct001());
            CommonJdbcUtils.execute("update wt03 set aae016='0' where wct001=? ",wt03Dto.getWct001());
            saveWt09(wt03.getWat001(),"DO_3","删除采样点："+wt03.getWct002());
            return wt03;
        }
        if(wt03.getWct014()==null){
            wt03.setWct018(new Date());
            AppUserDTO appUserDTO=(AppUserDTO)SecurityUtils.getSubject().getSession().getAttribute("user");
            wt03.setWct013(appUserDTO.getUserId());
        }
        //保存采样点
        CommonJdbcUtils.saveOrUpdateObject(wt03,false);
        List<Wt04> wt04s=getWt04List(wt03Dto.getBcz001s(),wt03.getWct001(),wt03.getWbt001());
        CommonJdbcUtils.execute("delete from wt04 where wct001=?",wt03.getWct001());
        saveWt04List(wt04s);

        /**
         * 保存日志
         */
        String aae013=String.format("采样点%s:",wt03.getWct002());
        saveWt09(wt03.getWat001(),"DO_11",aae013);

        return wt03;
    }

    /**
     * 添加检测数据
     * @param wt03Dtos
     * @return
     */
    @Transactional
    public void updateWt03(List<Wt03Dto> wt03Dtos){
        Wt03 wt03=null;
        AppUserDTO user=(AppUserDTO) SecurityUtils.getSubject().getSession().getAttribute("user" );
        for (Wt03Dto wt03Dto:wt03Dtos){
            wt03=new Wt03();
            BeanUtils.copyProperties(wt03Dto,wt03);
            if (wt03Dto.getWt04DtoList()!=null) {
                wt03.setWct018(new Date());
            }
            CommonJdbcUtils.updateSelect(wt03);
            Wt04 wt04=null;
            if (wt03Dto.getWt04DtoList()!=null) {
                for (Wt04Dto wt04Dto : wt03Dto.getWt04DtoList()) {
                    wt04 = new Wt04();
                    BeanUtils.copyProperties(wt04Dto, wt04);
                    wt04.setWxt005(user.getUserId());
                    wt04.setWxt006(new Date());
                    CommonJdbcUtils.updateSelect(wt04);
                }
            }
        }
        /**
         * 保存日志
         */
        String aae013=String.format("采样点%s",wt03.getWct002());
        saveWt09(wt03.getWat001(),"DO_4",aae013);

    }
    public List<Wp01Dto> queryWp01List(Wp01Dto wp01Dto){
        StringBuffer sb=new StringBuffer("select * from wp01 where 1=1 ");
        List<String> args=new ArrayList<String>();
        if (wp01Dto.getWtp001()!=null){
            sb.append(" and wtp001=? ");
            args.add(wp01Dto.getWtp001().toString());
        }
        if (wp01Dto.getWtp002()!=null){
            sb.append(" and wtp002=? ");
            args.add(wp01Dto.getWtp002());
        }
        if (wp01Dto.getWtp003()!=null){
            sb.append(" and wtp003=? ");
            args.add(wp01Dto.getWtp003());
        }
        if (args.size()==0) return null;
        return CommonJdbcUtils.queryList(sb.toString(),Wp01Dto.class,args.toArray());
    }
    public void deleteWt03(Integer wct001){
        CommonJdbcUtils.execute("delete from wt03 where wct001=?",wct001);
        CommonJdbcUtils.execute("delete from wt04 where wct001=?",wct001);
    }
    /**
     * 查询检测项目列表
     * @param bcz001s
     * @return
     */
    public  List<Wt04> getWt04List(String bcz001s,Integer wct001,Integer wbt001){
        String sql="select "+wbt001+" as wbt001,"+wct001+" as wct001,bcz001,bcz002,bcz003,bcz004,bcz005,bcz006,bcz008," +
                "bcz010 as wxt004 from bz02 where FIND_IN_SET(bcz001,?)";
        return CommonJdbcUtils.queryList(sql,Wt04.class,bcz001s);
    }

    /**
     * 保存检测项目列表
     * @param wt04s
     */
    public void saveWt04List(List<Wt04> wt04s){
        for (Wt04 wt04:wt04s){
            CommonJdbcUtils.saveOrUpdateObject(wt04,false);
        }
    }

    public String generateQueryWt(List<Object> args,Wt01Dto wt01Dto){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select a.*,b.wft001,b.wft002,b.wft003,b.wft004,b.wft005,b.wft006,b.wft007," +
                " b.wft008,b.wft009,b.wft010,b.wft011,b.wft031,b.aae013 as wftaae013,c.name as username,(select wlt002 from wt06 where wlt003=a.wat018) as wat018s, " +
                " (select GROUP_CONCAT(d.wdt001) from wt08 d WHERE a.wat001=d.wat001) wdt001s, " +
                "(select GROUP_CONCAT(d.userid) from wt08 d WHERE a.wat001=d.wat001) fuserids, " +
                "(select GROUP_CONCAT(d.name) from wt08 d WHERE a.wat001=d.wat001) fnames from " +
                " wt01 a ,wt05 b,app_user c where a.wat001=b.wat001 and a.userid=c.user_id ");
        if(wt01Dto.getWat001()!=null){
            stringBuffer.append(" and a.wat001=? ");
            args.add(wt01Dto.getWat001());
        }
        if(StringTools.hasText(wt01Dto.getWat002())){
            stringBuffer.append(" and a.wat002=? ");
            args.add(wt01Dto.getWat002().toUpperCase());
        }
        if(StringTools.hasText(wt01Dto.getWat018())){
            stringBuffer.append(" and a.wat018=? ");
            args.add(wt01Dto.getWat018());
        }
        if(wt01Dto.getAae003()!=null){
            stringBuffer.append(" and a.aae003=? ");
            args.add(wt01Dto.getAae003());
        }
        if(StringTools.hasText(wt01Dto.getWat003())){
            stringBuffer.append(" and a.wat003=? ");
            args.add(wt01Dto.getWat003());
        }
        if(StringTools.hasText(wt01Dto.getBhz003())){
            stringBuffer.append(" and a.bhz003=? ");
            args.add(wt01Dto.getBhz003());
        }
        if(StringTools.hasText(wt01Dto.getDaw002())){
            stringBuffer.append(" and a.daw002 like ? ");
            args.add("%"+wt01Dto.getDaw002()+"%");
        }
        if(StringTools.hasText(wt01Dto.getDaw005())){
            stringBuffer.append(" and a.daw005 like ? ");
            args.add("%"+wt01Dto.getDaw005()+"%");
        }
        if(StringTools.hasText(wt01Dto.getDaw004())){
            stringBuffer.append(" and a.daw004 like ? ");
            args.add(wt01Dto.getDaw004()+"%");
        }
        if(StringTools.hasText(wt01Dto.getWft010())){
            stringBuffer.append(" and b.wft010=? ");
            args.add(wt01Dto.getWft010());
        }
        if(StringTools.hasText(wt01Dto.getAab301())){
            stringBuffer.append(" and a.aab301=? ");
            args.add(wt01Dto.getAab301());
        }
        if(StringTools.hasText(wt01Dto.getWft015())&&"1".equals(wt01Dto.getWft015())){
            stringBuffer.append(" and exists(select 1 from wt07 e where b.wft001=e.wft001 and e.wft015=? ) ");
            args.add(wt01Dto.getWft015());
        }
        if(StringTools.hasText(wt01Dto.getWft015())&&"2".equals(wt01Dto.getWft015())){
            stringBuffer.append(" and not exists(select 1 from wt07 e where b.wft001=e.wft001 and e.wft015=? ) ");
            args.add(wt01Dto.getWft015());
        }
        if(wt01Dto.getS_date()!=null&&!wt01Dto.getS_date().trim().equals("")){
            stringBuffer.append(" AND a.wat017>=str_to_date('"+wt01Dto.getS_date()+"','%Y-%m-%d')  ");
        }
        if(wt01Dto.getE_date()!=null&&!wt01Dto.getE_date().trim().equals("")){
            stringBuffer.append(" AND a.wat017<=str_to_date('"+wt01Dto.getE_date()+"','%Y-%m-%d')  ");
        }
        if(wt01Dto.getUserid()!=null){
            stringBuffer.append(" and a.userid=? ");
            args.add(wt01Dto.getUserid());
        }
        stringBuffer.append(" and  FIND_IN_SET(a.wat018,?) ");
        args.add(queryWt06s(true));
        return stringBuffer.toString();
    }
    /**
     * 查询委托列表
     * @param dto
     * @return
     */
    public List<Wt01Dto> queryWtList(Wt01Dto dto){
        List<Object> args=new ArrayList<Object>();
        String sql=generateQueryWt(args,dto);
        return CommonJdbcUtils.queryList(sql,Wt01Dto.class,args.toArray());
    }
    /**
     * 查询委托page
     * @param dto
     * @return
     */
    public List<Wt01Dto> queryWt(Page page,Wt01Dto dto){
        List<Object> args=new ArrayList<Object>();
        String sql=generateQueryWt(args,dto);
        CommonJdbcUtils.queryPageList(page,sql,Wt01Dto.class,args.toArray());
        return page.getData();
    }

    /**
     * 根据委托ID查询报告
     * @param wt02Dto
     * @return
     */
    public List<Wt02Dto> queryWt02(Wt02Dto wt02Dto){
        StringBuffer sql=new StringBuffer("select a.*,b.bbz002,b.bbz003,b.bbz004 from wt02 a,bz01 b where a.bbz001=b.bbz001 ");
        List<String> args=new ArrayList<String>();
        if (wt02Dto.getWat001()!=null){
            args.add(wt02Dto.getWat001().toString());
            sql.append(" and a.wat001=? ");
        }
        if (wt02Dto.getWbt001()!=null){
            args.add(wt02Dto.getWbt001().toString());
            sql.append(" and a.wbt001=? ");
        }
        if (StringTools.hasText(wt02Dto.getAae016())){
            args.add(wt02Dto.getAae016());
            sql.append(" and a.aae016=? ");
        }
        List<Wt02Dto> wt02Dtos= CommonJdbcUtils.queryList(sql.toString(),Wt02Dto.class,args.toArray());
        Wt03Dto wt03Dto=new Wt03Dto();
        for (Wt02Dto dto:wt02Dtos){
            wt03Dto.setWbt001(dto.getWbt001());
            wt03Dto.setAae016("1");//查询有效
            dto.setWt03DtoList(queryWt03(wt03Dto));
        }
        return  wt02Dtos;
    }

    /**
     * 根据报告查询采样点
     * @param wt03Dto
     * @return
     */
    public List<Wt03Dto> queryWt03(Wt03Dto wt03Dto){
        StringBuffer sb=new StringBuffer("select * from wt03 where 1=1 ");
        List<String> args=new ArrayList<String>();
        if (wt03Dto.getWbt001()!=null){
            sb.append(" and wbt001=? ");
            args.add(wt03Dto.getWbt001().toString());
        }
        if (wt03Dto.getWct001()!=null){
            sb.append(" and wct001=? ");
            args.add(wt03Dto.getWct001().toString());
        }
        if (StringTools.hasText(wt03Dto.getAae016())){
            sb.append(" and aae016=? ");
            args.add(wt03Dto.getAae016());
        }
        List<Wt03Dto> wt03Dtos= CommonJdbcUtils.queryList(sb.toString(),Wt03Dto.class,args.toArray());
        Wt04Dto wt04Dto=new Wt04Dto();
        for (Wt03Dto dto:wt03Dtos){
            wt04Dto.setWct001(dto.getWct001());
            dto.setWt04DtoList(queryWt04(wt04Dto));
        }
        return wt03Dtos;
    }

    /**
     * 根据采样点查询检测项目
     * @param wt04Dto
     * @return
     */
    public List<Wt04Dto> queryWt04(Wt04Dto wt04Dto){
        String sql="select a.*,c.bmz001,c.bmz002,c.bmz003,c.bmz004 from wt04 a LEFT JOIN bz02 b on a.bcz001=b.bcz001 LEFT JOIN bz06 c on b.bcz012=c.bmz001 " +
                " where a.wct001= ?";
        return CommonJdbcUtils.queryList(sql,Wt04Dto.class,wt04Dto.getWct001());
    }

    /**
     * 查询操作人员环节权限列表
     * @param isPermission
     * @return
     */
    public List<Wt06Dto> queryWt06(Boolean isPermission){
        String sql="select * from wt06 ";
        List<Wt06Dto> list=null;
        List<Wt06Dto> rlist=new ArrayList<Wt06Dto>();
        list =CommonJdbcUtils.queryList(sql,Wt06Dto.class);
        if (isPermission){
            Subject subject= SecurityUtils.getSubject();
           for (Wt06Dto dto:list){
              if (subject.isPermitted(dto.getWlt003())){
                  rlist.add(dto);
              }
           }
            return rlist;
        }
        for (Wt06Dto wt06Dto:list){
            if (!wt06Dto.getWlt003().equals("LC_0")){
                rlist.add(wt06Dto);
            }
        }
        return rlist;
    }

    /**
     * 查询状态列表，小于wlt004
     * @param wlt004
     * @return
     */
    public List<Wt06Dto> queryWt06(Integer wlt004){
        String sql="select * from wt06 where wlt004 < ? ";
        List<Wt06Dto> list=null;
        list =CommonJdbcUtils.queryList(sql,Wt06Dto.class,wlt004);
        return list;
    }
    /**
     * 查询操作人员环节权限列表
     * @param isPermission
     * @return
     */
    public String queryWt06s(Boolean isPermission){
        List<Wt06Dto> list=queryWt06(isPermission);
        String res="";
        for (Wt06Dto dto:list){
            if ("".equals(res)) res=res+dto.getWlt003();
            else
                res=res+","+dto.getWlt003();
        }
        return  res;
    }

    /**
     * 查询人员分配列表
     * @param wat001
     * @return
     */
    public List<Wt08Dto> queryWt08ByWat001(Integer wat001){
        String sql="select a.*,b.wat002,b.wat004,b.aae013 from wt08 a,wt01 b where a.wat001=b.wat001 and a.wat001=?";
        List<Wt08Dto>  wt08Dtos=  CommonJdbcUtils.queryList(sql,Wt08Dto.class,wat001);
        if (wt08Dtos==null||wt08Dtos.size()==0){
            sql="select b.wat002,b.wat004,b.aae013 from wt01 b where b.wat001=?";
             wt08Dtos=  CommonJdbcUtils.queryList(sql,Wt08Dto.class,wat001);
        }
        return  wt08Dtos;
    }

    /**
     * 保存人员分配列表
     * @param wt08s
     */
    @Transactional
    public void saveWt08List(Wt01Dto wt01Dto,List<Wt08> wt08s){
        Wt01 wt01=new Wt01();
        BeanUtils.copyProperties(wt01Dto,wt01);
        CommonJdbcUtils.updateSelect(wt01);
        CommonJdbcUtils.execute("delete  from wt08 where wat001=?",wt01Dto.getWat001());
        CommonJdbcUtils.insertBatch(wt08s);
        /**
         * 保存日志
         */
        String aae013=String.format("预约时间：%s",wt01.getWat004());
        saveWt09(wt01.getWat001(),"DO_14",aae013);
    }

    /**
     * 获取下一步状态码
     * @param wat018
     */
    public Wt06 getNextWt06(String wat018,Integer step){
        String stringStep=step>=0?"+"+String.valueOf(step):String.valueOf(step);
        String sql="select * from wt06 where wlt004=(select wlt004"+stringStep+" from wt06 where wlt003=?)";
        Wt06 wt06=CommonJdbcUtils.queryFirst(sql,Wt06.class,wat018);
        return wt06;
    }
    /**
     * 获取下一步状态码
     * @param wlt003
     */
    public Wt06 getNextWt06ByWlt003(String wlt003){
        String sql="select * from wt06 where wlt003=?";
        return CommonJdbcUtils.queryFirst(sql,Wt06.class,wlt003);
    }

    /**
     * 跳转下一步,或上一步,如果返回为空，则表示没有找到下一步或上一步
     * @param wt01Dto
     * @return
     */
    @Transactional
    public Wt01Dto saveNextStep(Wt01Dto wt01Dto,Integer step){
        Wt06 wt06=null;
        if(wt01Dto.getWlt003()!=null){
            wt06=getNextWt06ByWlt003(wt01Dto.getWlt003());
        }else{
            wt06=getNextWt06(wt01Dto.getWat018(),step);
        }

        if (wt06==null) return  null;
        CommonJdbcUtils.execute("update wt01 set wat028=wat018,wat018=? where wat001=?",wt06.getWlt003(),wt01Dto.getWat001());
        wt01Dto.setWat018(wt06.getWlt003());
        /**
         * 保存日志
         */
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt01Dto.getWat001());
        if (step>0) {
            wt09Dto.setWgt005("DO_12");
            wt09Dto.setWgt006("提交");
        }
        else {
            wt09Dto.setWgt005("DO_13");
            wt09Dto.setWgt006("退回");
        }
        String aae013=String.format("跳转步骤：%s，-->%s。原因：%s",step,wt06.getWlt002(),wt01Dto.getJson1()==null?"":wt01Dto.getJson1());
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);
        return wt01Dto;
    }

    /**
     * 进入下一环节
     * @param wt01Dto
     * @return
     */
    public Wt01Dto saveNextProcess(Wt01Dto wt01Dto){
        List<Wt01Dto> wt01Dtos=queryWtList(wt01Dto);
        if (wt01Dtos.isEmpty()||wt01Dtos.size()==0){
            throw new BusinessException("未找到此委托信息");
        }
        Wt01Dto dto=wt01Dtos.get(0);
        String sql=null;
        if ("LC_INI".equals(dto.getWat018())){//新建
            if (dto.getWat004()==null)
                throw  new BusinessException("预约日期为空，不能进入预约环节");
        }else if ("LC_ORD".equals(dto.getWat018())){//预约
            List<Wt08Dto> wt08s=queryWt08ByWat001(dto.getWat001());
            if (wt08s==null||wt08s.size()==0)  new BusinessException("未安排采样人员，不能进入采样环节");
        }else if ("LC_COL".equals(dto.getWat018())){//采样
            sql="select * from wt03 where wat001=? and (wct003 is null or wct004 is null or wct005 is null)";
            List<Wt03> wt03s=CommonJdbcUtils.queryList(sql,Wt03.class,dto.getWat001());
            if (wt03s!=null&&wt03s.size()>0)
                throw new BusinessException("采样点数据未录入或者录入不完整，不允许进入检测环节");
        }else if ("LC_TES".equals(dto.getWat018())){//检测
            sql="select a.* from wt04 a,wt03 b,wt01 c where a.wct001=b.wct001 and b.wat001=c.wat001 and a.wxt002 is NULL " +
                    "and c.wat001=? ";
            List<Wt04> wt04s=CommonJdbcUtils.queryList(sql,Wt04.class,dto.getWat001());
            if (wt04s!=null&&wt04s.size()>0)
                throw new BusinessException("检测数据未录入或者录入不完整，不允许进入检测待审环节");
        }else if ("LC_CHE".equals(dto.getWat018())){//检测待审

        }else if ("LC_PUB".equals(dto.getWat018())){//发布

        }
        if (saveNextStep(dto,1)==null){
            throw new BusinessException("下一步无步骤");
        }
        return dto;
    }
    /**
     * 进入上一环节
     * @param wt01Dto
     * @return
     */
    public Wt01Dto savePreProcess(Wt01Dto wt01Dto){
        List<Wt01Dto> wt01Dtos=queryWtList(wt01Dto);
        if (wt01Dtos.isEmpty()||wt01Dtos.size()==0){
            throw new BusinessException("未找到此委托信息");
        }
        Wt01Dto dto=wt01Dtos.get(0);
        dto.setJson1(wt01Dto.getJson1());
        dto.setWlt003(wt01Dto.getWlt003());
        if (saveNextStep(dto,-1)==null){
            throw new BusinessException("上一步无步骤");
        }
        return dto;
    }

    /**
     * 查询报告显示信息
     * @param wt02Dto
     * @return
     */
    public Wt02Dto queryWt02Report(Wt02Dto wt02Dto){
        String sql="select a.wat001,a.wat002,(select dict_name from app_dict_detail where dict_code='WAT003' and dict_val=a.wat003 ) as wat003" +
                ",a.daw001,a.daw002,a.daw005,b.wbt001,b.wbt005,b.wbt006,b.wbt012,b.wbt014, " +
                "b.aae013,b.wbt008,b.wbt010,b.wbt011,c.bbz002,c.bbz004,b.wbt009 from wt01 a,wt02 b,bz01 c where " +
                "b.bbz001=c.bbz001 and a.wat001=b.wat001 and b.wbt001=? ";
        Wt02Dto wt02Dto1=CommonJdbcUtils.queryFirst(sql,Wt02Dto.class,wt02Dto.getWbt001());
            sql="select GROUP_CONCAT(DISTINCT bcz002) from wt04 where wbt001=? GROUP BY wbt001";
            String bcz002s=CommonJdbcUtils.queryObject(sql,String.class,wt02Dto1.getWbt001());
        wt02Dto1.setBcz002s(bcz002s);//检测项目列表
        sql="select MIN(wct014) as wct014min,SUM(wbt007) as wbt007sum,MAX(wct016) as wct016max from wt03 where wbt001=?";
        Wt02Dto wt02Dto2=CommonJdbcUtils.queryFirst(sql,Wt02Dto.class,wt02Dto.getWbt001());
        wt02Dto1.setWbt007sum(wt02Dto2.getWbt007sum());//样品数量
        wt02Dto1.setWct014min(wt02Dto2.getWct014min());//采样时间
        wt02Dto1.setWct016max(wt02Dto2.getWct016max());//封闭时间
        //获取采样点信息
        Wt03Dto wt03Dto=new Wt03Dto();
        wt03Dto.setWbt001(wt02Dto.getWbt001());
        wt02Dto1.setWt03DtoList(queryWt03(wt03Dto));
        return  wt02Dto1;
    }

    /**
     * 查询发票信息
     * @param wt07Dto
     * @return
     */
    public List<Wt07Dto> queryWt07list(Wt07Dto wt07Dto){
        String sql="select * from wt07 where 1=1 ";
        List<String> args=new ArrayList<String>();
        if (wt07Dto.getWft001()!=null){
            sql=sql+" and wft001=? ";
            args.add(wt07Dto.getWft001().toString());
        }
        if (StringTools.hasText(wt07Dto.getAae016())){
            sql=sql+" and aae016 =? ";
            args.add(wt07Dto.getAae016());
        }
        if (args.size()==0) return null;
        List<Wt07Dto> wt07Dtos=CommonJdbcUtils.queryList(sql,Wt07Dto.class,args.toArray());
            return  wt07Dtos;
    }

    /**
     * 保存发票信息
     * @param wt07Dto
     * @return
     */
    @Transactional
    public Wt07 saveWt07(Wt07Dto wt07Dto){
        Wt07 wt07=new Wt07();
        BeanUtils.copyProperties(wt07Dto,wt07);
        if(wt07Dto.getWft020()==null){
            wt07.setWft021(new Date());
            wt07.setAae016("1");
            wt07.setWft015("1");
        }

        CommonJdbcUtils.saveOrUpdateObject(wt07,false);

        Wt01 wt01=CommonJdbcUtils.queryFirst("select wat001 from wt05 where wft001=? ",Wt01.class,wt07.getWft001());
        saveWt09(wt01.getWat001(),"DO_3","保存发票信息：开票金额"+wt07.getWft014());
        return  wt07;
    }

    /**
     * 查询报告
     * @param page
     * @param wt02Dto
     * @return
     */
    public List<Wt02Dto> queryWt02Disables(Page page,Wt02Dto wt02Dto){
        StringBuffer sql=new StringBuffer("select a.wat001,a.wat002,a.daw001,a.daw002,a.daw003,a.daw004," +
                "a.daw005,b.bbz001,b.wbt001,b.wbt002,b.wbt003,b.aae016 " +
                ",c.bbz002,c.bbz003,(select wlt002 from wt06 where wlt003=a.wat018) as wat018s " +
                " from wt01 a,wt02 b,bz01 c where a.wat001=b.wat001 and b.bbz001=c.bbz001 ");
        List<String> args=new ArrayList<String>();
        if (wt02Dto.getWat001()!=null){
            args.add(wt02Dto.getWat001().toString());
            sql.append(" and a.wat001=? ");
        }
        if (wt02Dto.getWbt001()!=null){
            args.add(wt02Dto.getWbt001().toString());
            sql.append(" and b.wbt001=? ");
        }
        if ("0".equals(wt02Dto.getAae016())){
            sql.append(" and(b.aae016='0' or EXISTS(select 1 from wt03 d where b.wbt001=d.wbt001 and d.aae016='0') )  ");
        }
        if (StringTools.hasText(wt02Dto.getWat002())){
            args.add(wt02Dto.getWat002());
            sql.append(" and a.wat002=? ");
        }
        CommonJdbcUtils.queryPageList(page,sql.toString(),Wt02Dto.class,args.toArray());
        return  page.getData();
    }

    /**
     * update wt02
     * @param wt02Dto
     * @return
     */
    @Transactional
    public Wt02 updateWt02Simple(Wt02Dto wt02Dto){
        Wt02 wt02=new Wt02();
        BeanUtils.copyProperties(wt02Dto,wt02);
        CommonJdbcUtils.saveOrUpdateObject(wt02,false);
        wt02=CommonJdbcUtils.queryFirst("select wat001 from wt02 where wbt001=?",Wt02.class,wt02Dto.getWbt001());
        udpateCacleFee(wt02.getWat001());
        return  wt02;
    }

    /**
     * update wt03
     * @param wt03Dto
     * @return
     */
    @Transactional
    public Wt03 updateWt03Simple(Wt03Dto wt03Dto){
        Wt03 wt03=new Wt03();
        BeanUtils.copyProperties(wt03Dto,wt03);
        CommonJdbcUtils.saveOrUpdateObject(wt03,false);
        Wt02 wt02=CommonJdbcUtils.queryFirst("select wat001 from wt02 where wbt001=?",Wt02.class,wt03Dto.getWbt001());
        udpateCacleFee(wt02.getWat001());
        return  wt03;
    }

    /**
     * 更新费用
     * @param wat001
     */
    public void udpateCacleFee(Integer wat001){
        String sql="select SUM(a.wxt004) from wt04 a,wt03 b ,wt02 c where a.wct001=b.wct001 and c.wbt001=b.wbt001 and " +
                " c.wat001=? and c.aae016='1' and b.aae016='1'";
        Double testFee=CommonJdbcUtils.queryObject(sql,Double.class,wat001);
        Subject user=SecurityUtils.getSubject();
        if(user.hasRole("BD")||user.hasRole("BE")){//如果是业务才可以修改总计
            sql="update wt05 set wft004=?,wft007=(wft002+wft004)*wft006 where wat001=?";
        }else{
            sql="update wt05 set wft004=? where wat001=?";
        }

        CommonJdbcUtils.execute(sql,testFee,wat001);
        Wt05 wt05=CommonJdbcUtils.queryFirst("select * from wt05 where wat001=?",Wt05.class,wat001);
        String aae013=String.format("费用重新计算:应收总费用%s，其中采样费用%s、检测费用%s、折扣率%s。"
                ,wt05.getWft007(),wt05.getWft002(),wt05.getWft004(), wt05.getWft006());
        saveWt09(wat001,"DO_3",aae013);
    }

    /**
     * 更新实收信息
     * @param wt05Dto
     * @return
     */
    public Wt05 updateWt05(Wt05Dto wt05Dto){
        Wt05 wt05=new Wt05();
        BeanUtils.copyProperties(wt05Dto,wt05);
        if ("1".equals(wt05.getWft010()))
            wt05.setWft011(new Date());
        CommonJdbcUtils.updateSelect(wt05);
        String isFee="1".equals(wt05.getWft010())?"实收":"未实收";
        saveWt09(wt05Dto.getWat001(),"DO_3","收费维护："+isFee);
        return  wt05;

    }

    /**
     * 隐藏或者显示
     * @param wt01Dto
     * @param type
     */
    public void hideAndShow(Wt01Dto wt01Dto,String type){
        String sql="";
        if ("H".equals(type)){
            sql="update wt01 set wat028=wat018,wat018='LC_0' where wat001=? and wat018!='LC_0' ";
        }
        if ("S".equals(type)){
            sql="update wt01 set wat018=wat028 where wat001=? ";
        }
        CommonJdbcUtils.execute(sql,wt01Dto.getWat001());
    }

    /**
     * 保存样品
     * @param wt10Dto
     */
    @Transactional
    public void saveWt10(Wt10Dto wt10Dto){
        List<Wt10> wt10s=CommonJdbcUtils.queryList("select * from wt10 where wst003=? and wct001=? ",
                Wt10.class,wt10Dto.getWst003(),wt10Dto.getWct001());
        if (wt10s!=null&&wt10s.size()>0){
            throw new BusinessException("此样品编号已经存在！");
        }
        Wt10 wt10=new Wt10();
        BeanUtils.copyProperties(wt10Dto,wt10);
        wt10.setWst008(DateUtil.now());
        wt10.setWst009(ContextUtils.getUserId());
        CommonJdbcUtils.insert(wt10);
        String[] wxt001=wt10Dto.getWxt001s().split(",");
        String sql="update wt04 set wxt009=CONCAT_WS(' ',IFNULL(wxt009,''),?) where wxt001= ? ";
        if (wxt001.length>0){
            for (int i=0;i<wxt001.length;i++){
            CommonJdbcUtils.execute(sql,wt10.getWst003()+" ",wxt001[i]);
            }
        }
    }

    /**
     * 删除样品
     * @param wt10Dto
     */
    @Transactional
    public void deleteWt10(Wt10Dto wt10Dto){
        String sql="delete from wt10 where wst001= ? ";
        CommonJdbcUtils.execute(sql,wt10Dto.getWst001());
        sql="update wt04 set wxt009=replace(wxt009,?,'') where wct001=? ";
        CommonJdbcUtils.execute(sql,wt10Dto.getWst003()+" ",wt10Dto.getWct001());
    }
    public List<Wt10Dto> queryWt10Page(Page page,Wt10Dto wt10Dto){
        StringBuffer stringBuffer=new StringBuffer("select * from wt10 where wct001=? ");

       CommonJdbcUtils.queryPageList(page,stringBuffer.toString(),Wt10Dto.class,wt10Dto.getWct001());
       return page.getData();
    }

    /**
     * 检测原始录入时查询样品
     * @param wt10Dto
     * @return
     */
    public List<Wt10Dto> queryWt10PageForRecord(Page page,Wt10Dto wt10Dto){
        StringBuffer stringBuffer=new StringBuffer("select a.wxt001,a.bcz002,a.bcz001,b.* from wt04 a,wt10 b where a.wct001=b.wct001");
        List<String> args=new ArrayList<String>();
        if (StringTools.hasText(wt10Dto.getWst003())){
            stringBuffer.append(" and b.wst003=? ");
            args.add(wt10Dto.getWst003());
        }
        if(wt10Dto.getWct001()!=null){
            stringBuffer.append(" and b.wct001=? ");
            args.add(wt10Dto.getWct001().toString());
        }
        if (args.size()==0) throw new  BusinessException("查询条件为空");
        CommonJdbcUtils.queryPageList(page,stringBuffer.toString(),Wt10Dto.class,args.toArray());
        return  page.getData();
    }

    /**
     * 保存检测原始记录
     * @param wt11Dto
     */
    @Transactional
    public Wt11 saveWt11(Wt11Dto wt11Dto){
        Wt11 wt11=new Wt11();
        BeanUtils.copyProperties(wt11Dto,wt11);
        String sql="select * from wt11 a where a.wst001=? and a.wxt001=? and a.wrt008=(select max(b.wrt008) from wt11 b where b.wst001=? and b.wxt001=?)";
        List<Wt11Dto> wt11Dtos=CommonJdbcUtils.queryList(sql,Wt11Dto.class,wt11Dto.getWst001(),wt11Dto.getWxt001(),wt11Dto.getWst001(),wt11Dto.getWxt001());
        if (wt11Dtos==null||wt11Dtos.size()==0){
            wt11.setWrt008(1);
        }else {
            wt11.setWrt008(wt11Dtos.get(0).getWrt008()+1);
        }
        wt11.setWrt006(new Date());
        wt11.setWrt007(ContextUtils.getUserId());
        if (!wt11.getWrt002().startsWith("["))
            wt11.setWrt002("["+wt11.getWrt002()+"]");
        CommonJdbcUtils.insert(wt11);
        //添加步骤字典
        AddBcz013(wt11Dto.getWrt002(),wt11Dto.getBcz001());
        return wt11;
    }

    /**
     * 删除原始记录表
     * @param wt11Dto
     */
    public void deleteWt11(Wt11Dto wt11Dto){
        if (wt11Dto.getWrt001()!=null)
            CommonJdbcUtils.execute("delete from wt11 where wrt001=? ",wt11Dto.getWrt001());
    }

    /**
     * 查询原始记录表
     * @param page
     * @param wt11Dto
     * @return
     */
    public List<Wt11Dto> queryWt11Page(Page page,Wt11Dto wt11Dto){
        String sql="select b.bcz002,bcz001,a.* from wt11 a,wt04 b where a.wxt001=b.wxt001 and  a.wst001=? and a.wxt001=? order by a.wrt008 ";
        CommonJdbcUtils.queryPageList(page,sql,Wt11Dto.class,wt11Dto.getWst001(),wt11Dto.getWxt001());
        return page.getData();
    }

    /**
     * 保存检验步骤
     * @param bcz013
     * @param bcz001
     */
    public void AddBcz013(String bcz013,Integer bcz001){
        Bz02 bz02exists=CommonJdbcUtils.queryFirst("select * from bz02 where bcz001=? and bcz013 like ? ",
                Bz02.class,bcz001,"%["+bcz013+"]%");
        if (bz02exists!=null) return;
        Bz02 bz02=CommonJdbcUtils.queryFirst("select * from bz02 where bcz001=? ",Bz02.class,bcz001);
        if (bz02==null) return;
        String bcz013_in=!StringTools.hasText(bz02.getBcz013())?"["+bcz013+"]":bz02.getBcz013()+",["+bcz013+"]";
        CommonJdbcUtils.execute("update bz02 set bcz013=? where bcz001=? ",bcz013_in,bcz001);
    }
    /**
     * 保存检验步骤
     * @param bcz013
     * @param bcz001
     */
    @Transactional
    public void deleteBcz013(String bcz013,Integer bcz001){
        Bz02 bz02=CommonJdbcUtils.queryFirst("select * from bz02 where bcz001=? ",Bz02.class,bcz001);
        if (bz02==null) return;
        String bcz013_in="";
        if (bz02.getBcz013().startsWith("["+bcz013+"]")) {
            bcz013_in=bz02.getBcz013().replace("["+bcz013+"]","");
        }else{
            bcz013_in=bz02.getBcz013().replace(",["+bcz013+"]","");
        }
        CommonJdbcUtils.execute("update bz02 set bcz013=? where bcz001=? ",bcz013_in,bcz001);
    }

    /**
     * 查询步骤列表
     * @param bcz001
     * @return
     */
    public List<AppDictDetail> queryBcz013List(Integer bcz001){
        Bz02 bz02=CommonJdbcUtils.queryFirst("select * from bz02 where bcz001=? ",Bz02.class,bcz001);
        String[] bcz013=bz02.getBcz013().split(",");
        List<AppDictDetail> appDictDetails=new ArrayList<AppDictDetail>();
        AppDictDetail appDictDetail=null;
        for (int i=0;i<bcz013.length;i++){
            appDictDetail=new AppDictDetail();
            appDictDetail.setDictVal(bcz013[i]);
            appDictDetails.add(appDictDetail);
        }
        return appDictDetails;
    }
}