package com.xuechen.qdenv.service;

import com.wondersgroup.framwork.dao.CommonJdbcUtils;
import com.wondersgroup.framwork.dao.bo.Page;
import com.xuechen.qdenv.bo.Bz04;
import com.xuechen.qdenv.dto.Bz04Dto;
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
        CommonJdbcUtils.insert(bz04);
    }
    /**
     * 更新行业
     */
    public void updateBz04(Bz04 bz04){
        CommonJdbcUtils.updateSelect(bz04);
    }

    /**
     *查询行业
     * @param bz04Dto
     * @return
     */
    public List<Bz04Dto> queryBz04(Page page, Bz04Dto bz04Dto){
        StringBuffer sql=new StringBuffer("select * from bz04 where 1=1 " );
        List<Object> args=new ArrayList<Object>();
        if (bz04Dto.getBhz001()!=null){
            sql.append(" bhz001= ?");
            args.add(bz04Dto.getBhz001());
        }
        if (bz04Dto.getAae016()!=null){
            sql.append(" aae016= ?");
            args.add(bz04Dto.getAae016());
        }
        if (bz04Dto.getBzh002()!=null){
            sql.append(" bhz002 like ?");
            args.add("%"+bz04Dto.getBzh002()+"%");
        }
        CommonJdbcUtils.queryPageList(page,sql.toString(),Bz04Dto.class,args.toArray());
        return  page.getData();
    }
}
