package com.bigdata.framework.db.condition;

import com.bigdata.enums.StateCode;
import lombok.Data;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author yang
 * @ClassName: QueryCondition
 * @Description:
 * @date 2018-06-20
 * @version:
 */
@Data
public class QueryCondition {
    public Long userId;
    public String keyword;
    public Integer[] states;

    public void setStates(StateCode... states) {
        if (ArrayUtils.isNotEmpty(states)) {
            this.states = Arrays.stream(states)
                    .filter(Objects::nonNull)
                    .map(StateCode::code)
                    .distinct()
                    .toArray(Integer[]::new);
        }
    }

    public void setState(StateCode state) {
        if (null != state) {
            states = new Integer[]{state.code()};
        }
    }
}
