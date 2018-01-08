package com.xuechen.web.dao;



import com.xuechen.web.bo.AppNotice;
import com.xuechen.web.bo.AppResource;
import com.xuechen.web.bo.AppRole;
import com.xuechen.web.bo.AppUser;
import com.xuechen.web.dto.AppNoticeDTO;
import com.xuechen.web.dto.AppRoleDTO;
import com.xuechen.web.dto.AppUserDTO;

import java.util.List;

public interface AppAdminMapper {
    List<AppUserDTO> selectUserByUser(AppUser appUser);
    List<AppUserDTO> queryPassworkByUser(AppUser appUser);
    List<AppResource> selectResourceByUser(AppUser appUser);
    List<AppRole> selectRolesByUserid(int userid);
    List<AppRoleDTO> selectRoleInfoByRoleId(AppRole appRole);
    int selectMaxDictValByCode(String dictCode);
    List<AppNoticeDTO> selectAppNotice(AppNoticeDTO appNoticeDTO);
    List<AppNoticeDTO> selectAppNoticeResult(AppNoticeDTO appNoticeDTO);
}
