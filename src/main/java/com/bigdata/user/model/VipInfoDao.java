package com.bigdata.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author yang
 * @ClassName: VipInfoDao
 * @Description:
 * @date 2018-06-23
 * @version:
 */
@Data
public class VipInfoDao {
    private WXUserInfo wxUserInfo;
    private VipLevel vipLevel;
}
