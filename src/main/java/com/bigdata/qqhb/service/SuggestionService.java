package com.bigdata.qqhb.service;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Suggestion;

/**
 * @author yang
 * @ClassName: SuggestionService
 * @Description:投诉与建议
 * @date 2018-05-27
 * @version:
 */
public interface SuggestionService {
    /**
     * 投诉与建议
     * @param suggestion
     * @return boolean
     * @throws Exception
     */
    public Suggestion add(Suggestion suggestion) throws SZBException;
}
