package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.core.utils.StringTools;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.*;
import com.xuechen.web.dto.AppUserDTO;
import com.xuechen.web.exception.BusinessException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
    private static Logger logger= org.apache.log4j.Logger.getLogger(QdenvServiceImpl.class);

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
        CommonJdbcUtils.insert(wt09);
        return wt09;
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
            Wt09Dto wt09Dto=new Wt09Dto();
            wt09Dto.setWat001(wt01.getWat001());
            wt09Dto.setWgt005("DO_6");
            wt09Dto.setWgt006("保存快递信息");
            String aae013=String.format("快递单号：%s",wt01.getWat014());
            wt09Dto.setAae013(aae013);
            saveWt09(wt09Dto);
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
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt01.getWat001());
        wt09Dto.setWgt005("LC_INI");
        wt09Dto.setWgt006("新建");
        String aae013=(wt01Dto.getWat001()!=null?"修改委托信息":"新增加委托信息");
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);

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
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt05.getWat001());
        wt09Dto.setWgt005("LC_INI");
        wt09Dto.setWgt006("新建");
        String aae013=String.format("财务信息,应收总费用%s，其中采样费用%s、检测费用%s、折扣率%s."
        ,wt05.getWft007(),wt05.getWft002(),wt05.getWft004(), wt05.getWft006());
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);
        return wt05;
    }
    /**
     * 保存报告（标准）
     * @param wt02Dtos
     */

    public void saveWt02(List<Wt02Dto> wt02Dtos){
        Wt02 wt02=null;
        for (Wt02Dto wt02Dto:wt02Dtos){
            if ("removed".equals(wt02Dto.get_state())){
                deleteWt02(wt02Dto.getWbt001());
                continue;
            }
            wt02=new Wt02();
            BeanUtils.copyProperties(wt02Dto,wt02);
            if (wt02.getWbt001()==null) wt02.setWbt002(new Date());
            CommonJdbcUtils.saveOrUpdateObject(wt02,false);
            if (wt02Dto.getWt03DtoList()!=null) {
                for (Wt03Dto wt03Dto : wt02Dto.getWt03DtoList()) {
                    wt03Dto.setWbt001(wt02.getWbt001());
                    wt03Dto.setWat001(wt02.getWat001());
                    saveOrUpdateWt03(wt03Dto);
                }
            }
        }
    }

    public void deleteWt02(Integer wbt001){
        CommonJdbcUtils.execute("delete from wt02 where wbt001=?",wbt001);
    }
    /**
     * 添加采样点
     * @param wt03Dto
     * @return
     */
    public Wt03 saveOrUpdateWt03(Wt03Dto wt03Dto){

        Wt03 wt03=new Wt03();
        BeanUtils.copyProperties(wt03Dto,wt03);
        if ("removed".equals(wt03Dto.get_state())){
            deleteWt03(wt03Dto.getWct001());
            return wt03;
        }
        //保存采样点
        CommonJdbcUtils.saveOrUpdateObject(wt03,false);
        List<Wt04> wt04s=getWt04List(wt03Dto.getBcz001s(),wt03.getWct001(),wt03.getWbt001());
        saveWt04List(wt04s);

        /**
         * 保存日志
         */
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt03.getWat001());
        wt09Dto.setWct001(wt03.getWct001());
        wt09Dto.setWbt001(wt03.getWbt001());
        wt09Dto.setWgt005("DO_11");
        wt09Dto.setWgt006("添加采样点");
        String aae013=String.format("采样点%s",wt03.getWct002());
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);

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
            CommonJdbcUtils.updateSelect(wt03);
            Wt04 wt04=null;
            for (Wt04Dto wt04Dto:wt03Dto.getWt04DtoList()){
                wt04=new Wt04();
                BeanUtils.copyProperties(wt04Dto,wt04);
                wt04.setWxt005(user.getUserId());
                wt04.setWxt006(new Date());
                CommonJdbcUtils.updateSelect(wt04);
            }
        }
        /**
         * 保存日志
         */
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt03.getWat001());
        wt09Dto.setWct001(wt03.getWct001());
        wt09Dto.setWbt001(wt03.getWbt001());
        wt09Dto.setWgt005("DO_4");
        wt09Dto.setWgt006("检测数据");
        String aae013=String.format("采样点%s",wt03.getWct002());
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);

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
        stringBuffer.append("select a.*,b.wft001,b.wft002,b.wft004,b.wft006,b.wft007,b.wft010,c.name as username,(select wlt002 from wt06 where wlt003=a.wat018) as wat018s " +
                "from wt01 a ,wt05 b,app_user c where a.wat001=b.wat001 and a.userid=c.user_id ");
        if(wt01Dto.getWat001()!=null){
            stringBuffer.append(" and a.wat001=? ");
            args.add(wt01Dto.getWat001());
        }
        if(wt01Dto.getWat002()!=null){
            stringBuffer.append(" and a.wat002=? ");
            args.add(wt01Dto.getWat002());
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
        if(wt01Dto.getDaw002()!=null){
            stringBuffer.append(" and a.daw002 like ? ");
            args.add("%"+wt01Dto.getDaw002()+"%");
        }
        if(StringTools.hasText(wt01Dto.getAab301())){
            stringBuffer.append(" and a.aab301=? ");
            args.add(wt01Dto.getAab301());
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
        String sql="select a.*,b.bbz002,b.bbz003,b.bbz004 from wt02 a,bz01 b where a.bbz001=b.bbz001 and a.wat001=?";
        List<Wt02Dto> wt02Dtos= CommonJdbcUtils.queryList(sql,Wt02Dto.class,wt02Dto.getWat001());
        Wt03Dto wt03Dto=new Wt03Dto();
        for (Wt02Dto dto:wt02Dtos){
            wt03Dto.setWbt001(dto.getWbt001());
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
        String sql="select * from wt03 where wbt001=?";
        List<Wt03Dto> wt03Dtos= CommonJdbcUtils.queryList(sql,Wt03Dto.class,wt03Dto.getWbt001());
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
        String sql="select * from wt04 where wct001=?";
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
        Wt09Dto wt09Dto=new Wt09Dto();
        wt09Dto.setWat001(wt01.getWat001());
        wt09Dto.setWgt005("DO_14");
        wt09Dto.setWgt006("安排采样");
        String aae013=String.format("预约时间：%s",wt01.getWat004());
        wt09Dto.setAae013(aae013);
        saveWt09(wt09Dto);
    }

    /**
     * 获取下一步状态码
     * @param wat018
     */
    public Wt06 getNextWt06(String wat018,Integer step){
        String stringStep=step>=0?"+"+String.valueOf(step):String.valueOf(step);
        String sql="select * from wt06 where wlt004=(select wlt004"+stringStep+" from wt06 where wlt003=?)";
        return CommonJdbcUtils.queryFirst(sql,Wt06.class,wat018);
    }

    /**
     * 跳转下一步,或上一步,如果返回为空，则表示没有找到下一步或上一步
     * @param wt01Dto
     * @return
     */
    public Wt01Dto saveNextStep(Wt01Dto wt01Dto,Integer step){
        Wt06 wt06=getNextWt06(wt01Dto.getWat018(),step);
        if (wt06==null) return  null;
        CommonJdbcUtils.execute("update wt01 set wat018=? where wat001=?",wt06.getWlt003(),wt01Dto.getWat001());
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
        String aae013=String.format("跳转频数：%s",step);
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
        if (saveNextStep(dto,-1)==null){
            throw new BusinessException("上一步无步骤");
        }
        return dto;
    }
}