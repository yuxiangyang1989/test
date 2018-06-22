package com.bigdata.user.service;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.SysPermission;
import com.bigdata.user.model.UserInfo;

import java.util.List;

/**
 * @author yang
 * @ClassName: SysPermissionService
 * @Description:系统权限服务
 * @date 2018-05-30
 * @version:1.0.0
 */
public interface SysPermissionService {

    List<SysPermission> selectPermByUser(UserInfo userInfo) throws SZBException;
}
