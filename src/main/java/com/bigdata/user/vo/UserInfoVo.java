package com.bigdata.user.vo;

import com.bigdata.apiout.BaseVo;
import com.bigdata.enums.user.UserInfoTypeEnum;
import com.bigdata.framework.common.utils.DESUtil;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.framework.common.utils.TokenUtil;
import com.bigdata.user.model.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.nio.charset.Charset;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: UserRegisterVo
 * @Description:
 * @date 2018-06-03
 * @version:1.0.0
 */
@Data
public class UserInfoVo extends BaseVo{
    private String loginname;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String salt;
    private String phone;
    private String email;
    private String cardId;
    private UserInfoTypeEnum type;
    private Long roleId;
    private Long permissionId;
    private String token;
    private String username;

    public UserInfoVo(){}

    public UserInfoVo(UserInfo userInfo){
        this.setSid(NumberUtils.compress(userInfo.getId()));
        this.loginname = userInfo.getLoginName();
        this.password = userInfo.getPassword();
        this.salt = userInfo.getSalt();
        this.phone = StringUtils.mask(userInfo.getPhone(),3,4) ;;
        this.cardId = StringUtils.mask(userInfo.getCardId(),6,4);
        this.email = userInfo.getEmail();
        this.type = userInfo.getType();
        this.roleId = userInfo.getRoleId();
        this.permissionId = userInfo.getPermissionId();
        this.username = userInfo.getUsername();

        this.token = new String(DESUtil.encrypt(TokenUtil.generateToken()+"-"+userInfo.getLoginName(),salt), Charset.defaultCharset());
    }

    public UserInfo toModel(){
        UserInfo userInfo = new UserInfo();
        Optional.ofNullable(this.getSid()).ifPresent(sid->userInfo.setId(NumberUtils.uncompress(sid)));
        Optional.ofNullable(this.getUsername()).ifPresent(name->userInfo.setUsername(name));
        Optional.ofNullable(this.getPassword()).ifPresent(password->userInfo.setPassword(password));
        Optional.ofNullable(this.getPhone()).ifPresent(phone->userInfo.setPhone(phone));
        Optional.ofNullable(this.getCardId()).ifPresent(cardId->userInfo.setCardId(cardId));
        Optional.ofNullable(this.getLoginname()).ifPresent(loginname->userInfo.setLoginName(loginname));
        Optional.ofNullable(this.getEmail()).ifPresent(email->userInfo.setEmail(email));
        return userInfo;
    }
}
