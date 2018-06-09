package com.bigdata.user.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.user.model.SysPermission;
import com.bigdata.user.model.UserInfo;
import com.bigdata.user.repository.SysPermissionRepository;
import com.bigdata.user.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yang
 * @ClassName: SysPermissionServiceImpl
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService{

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    public List<SysPermission> selectPermByUser(UserInfo userInfo) throws SZBException{
        SysPermission sysPermission = new SysPermission();
        sysPermission.setId(userInfo.getPermissionId());
        Example<SysPermission> example = Example.of(sysPermission);
        return sysPermissionRepository.findAll(example);
    }
}
