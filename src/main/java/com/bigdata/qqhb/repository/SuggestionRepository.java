package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: SuggestionRepository
 * @Description: 投诉与建议
 * @date 2018-05-24
 * @version:
 */
public interface SuggestionRepository extends JpaRepository<Suggestion, String> {
}
