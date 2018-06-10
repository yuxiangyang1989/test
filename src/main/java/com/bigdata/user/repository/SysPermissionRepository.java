package com.bigdata.user.repository;

import com.bigdata.user.model.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yang
 * @ClassName: SysPermissionRepository
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Repository
public interface SysPermissionRepository extends JpaRepository<SysPermission,Long>{
}
