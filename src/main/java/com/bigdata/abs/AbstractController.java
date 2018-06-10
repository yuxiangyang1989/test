package com.bigdata.abs;

import com.alibaba.fastjson.JSON;
import com.bigdata.constant.Constants;
import com.bigdata.enums.ResponseCode;
import com.bigdata.exception.AuthenticationException;
import com.bigdata.exception.SZBException;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.framework.common.utils.StringUtils;
import com.bigdata.framework.web.util.HostUtils;
import com.bigdata.framework.web.util.HttpClientUtils;
import com.bigdata.user.vo.CodeVo;
import com.bigdata.user.vo.SimpleUser;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: AbstractController
 * @Description:
 * @date 2018-06-05
 * @version:
 */
@Slf4j
@RestController
public class AbstractController {
    @Value("wx.effective.url")
    private String tokenUrl;

    protected boolean validateToken(String token,String openid) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("access_token", token);
        map.put("openid", openid);
        String url = HostUtils.getContent(map,tokenUrl);
        CodeVo codeVo =null;
        try {
            String result = HttpClientUtils.get(url, "UTF-8");
            codeVo = JSON.parseObject(result,CodeVo.class);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new SZBException(ResponseCode.TokenInvalid);
        }
        if (null == codeVo){
            throw new SZBException(ResponseCode.TokenInvalid);
        }
        if (0==codeVo.getErrcode()){
            return true;
        }else{
            log.error("token验证失败------errcode={}--errmsg={}",codeVo.getErrcode(),codeVo.getErrmsg());
            return false;
        }
    }
}
