package com.bigdata.user.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.user.model.WXToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: WXTokenRepository
 * @Description:
 * @date 2018-06-09
 * @version:1.0.0
 */
@Mapper
public interface WXTokenRepository extends IBaseRepository<WXToken,Long> {
}
