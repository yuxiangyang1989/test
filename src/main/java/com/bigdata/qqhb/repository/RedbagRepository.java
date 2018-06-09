package com.bigdata.qqhb.repository;

import com.bigdata.qqhb.model.RedBag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @ClassName: RedbagRepository
 * @Description: 红包基数
 * @date 2018-05-24
 * @version:
 */
public interface RedbagRepository extends JpaRepository<RedBag, String> {
}
