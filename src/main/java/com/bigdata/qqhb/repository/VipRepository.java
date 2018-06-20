package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.Openvip;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: VipRepository
 * @Description:开通vip
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface VipRepository extends IBaseRepository<Openvip, Long> {
    Openvip findByOpenid(String openid);
}
