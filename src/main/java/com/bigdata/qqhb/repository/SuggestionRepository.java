package com.bigdata.qqhb.repository;

import com.bigdata.framework.db.repository.IBaseRepository;
import com.bigdata.qqhb.model.Suggestion;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @ClassName: SuggestionRepository
 * @Description: 投诉与建议
 * @date 2018-05-24
 * @version:
 */
@Mapper
public interface SuggestionRepository extends IBaseRepository<Suggestion, String> {
}
