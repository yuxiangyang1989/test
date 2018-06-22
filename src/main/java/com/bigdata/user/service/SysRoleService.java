package com.bigdata.user.service;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.SysRole;
import com.bigdata.user.model.UserInfo;

import java.util.List;

/**
 * @author yang
 * @ClassName: SysRoleService
 * @Description:系统角色服务
 * @date 2018-05-30
 * @version:1.0.0
 */
public interface SysRoleService {

    /**
     * 根据用户信息查询角色
     * @param userInfo
     * @return List<SysRole>
     */
    List<SysRole> selectRoleByUser(UserInfo userInfo) throws SZBException;
}
