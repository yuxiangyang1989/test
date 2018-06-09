package com.bigdata.qqhb.vo;

import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.qqhb.model.AppUpdate;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @ClassName: AppUpdateVo
 * @Description:
 * @date 2018-05-29
 * @version:
 */
@Data
public class AppUpdateVo {
    private String id;
    private String userCode;
    private String versionNum;
    private String versionSerNum;
    private Date vsersionDate;

    public AppUpdateVo(){}
    public AppUpdateVo(AppUpdate appUpdate){
        this.id = NumberUtils.compress(appUpdate.getId());
        this.userCode = appUpdate.getUserCode();
        this.versionNum = appUpdate.getVersionNum();
        this.versionSerNum = appUpdate.getVersionSerNum();
        this.vsersionDate = appUpdate.getCreateTime();
    }

    public AppUpdate toModel(){
        AppUpdate appUpdate = new AppUpdate();
        appUpdate.setId(NumberUtils.uncompress(this.id));
        appUpdate.setUserCode(this.userCode);
        appUpdate.setVersionNum(this.versionNum);
        appUpdate.setVersionSerNum(this.versionSerNum);
        return appUpdate;
    }
}
