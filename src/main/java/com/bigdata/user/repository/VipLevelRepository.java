package com.bigdata.user.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.user.model.VipLevel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: VipLevelRepository
 * @Description:
 * @date 2018-06-23
 * @version:
 */
@Mapper
public interface VipLevelRepository extends IBaseRepository<VipLevel,Long>{
    VipLevel findByOpenid(String openid);
}
