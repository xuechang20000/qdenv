package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.*;
import com.xuechen.qdenv.dto.Bz01Dto;
import com.xuechen.qdenv.dto.Bz02Dto;
import com.xuechen.qdenv.dto.Bz03Dto;
import com.xuechen.qdenv.dto.Bz04Dto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务service
 */
@Service
public class QdenvServiceImpl implements QdenvService {
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

}