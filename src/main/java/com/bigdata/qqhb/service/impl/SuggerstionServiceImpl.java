package com.bigdata.qqhb.service.impl;

import com.bigdata.exception.SZBException;
import com.bigdata.qqhb.model.Suggestion;
import com.bigdata.qqhb.repository.SuggestionRepository;
import com.bigdata.qqhb.service.SuggestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @ClassName: SuggerstionServiceImpl
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Slf4j
@Service
public class SuggerstionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Override
    public Suggestion add(Suggestion suggestion) throws SZBException{
        return suggestionRepository.save(suggestion);
    }
}
