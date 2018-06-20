package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.RedBag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: RedbagRepository
 * @Description: 红包基数
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface RedbagRepository extends IBaseRepository<RedBag, String> {
}
