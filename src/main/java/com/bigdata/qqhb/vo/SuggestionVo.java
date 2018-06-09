package com.bigdata.qqhb.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.qqhb.model.Suggestion;
import lombok.Data;

/**
 * @author yang
 * @ClassName: SuggestionVo
 * @Description:
 * @date 2018-06-03
 * @version:
 */
@Data
public class SuggestionVo extends BaseVo{
    private String 	userCode;//用户ID--手机IMEI唯一标识号
    private String msgType;//类型
    private String msg;//问题描述
    private String link;//联系方式
    public SuggestionVo(){}
    public SuggestionVo(Suggestion suggestion){
        this.setSid(NumberUtils.compress(suggestion.getId()));
        this.setUserCode(suggestion.getUserCode());
        this.setMsg(suggestion.getMsgType());
        this.setMsg(suggestion.getMsg());
        this.setLink(suggestion.getLink());
        this.setCreateTime(suggestion.getCreateTime());
        this.setUpdateTime(suggestion.getUpdateTime());
    }

    public Suggestion toModel(){
        Suggestion suggestion = new Suggestion();
        suggestion.setId(NumberUtils.uncompress(this.getSid()));
        suggestion.setUserCode(this.getUserCode());
        suggestion.setMsg(this.getMsgType());
        suggestion.setMsg(this.getMsg());
        suggestion.setLink(this.getLink());
        return suggestion;
    }
}
