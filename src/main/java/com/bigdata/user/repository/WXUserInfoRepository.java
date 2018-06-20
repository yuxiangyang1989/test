package com.bigdata.user.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.user.model.WXUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: WXUserInfoRepository
 * @Description:
 * @date 2018-06-09
 * @version:1.0.0
 */
@Mapper
public interface WXUserInfoRepository extends IBaseRepository<WXUserInfo,Long> {

    WXUserInfo findByOpenid(String openid);

    WXUserInfo findById(Long id);
}
