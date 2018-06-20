package com.bigdata.framework.sends;

import com.bigdata.framework.web.util.HttpClientUtils;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;

import java.io.IOException;
import java.util.Random;

/**
 * @author yang
 * @ClassName: TxMsgUtil
 * @Description:腾讯短信
 * @date 2018-06-16
 * @version:1.0.0
 */
@Slf4j
public class TxMsgUtil {

    private TxMsgUtil(){}

    private volatile static TxMsgUtil txMsgUtil;

    public static TxMsgUtil getTxMsgUtil() {
        if (txMsgUtil == null) {
            synchronized (TxMsgUtil.class) {
                if (txMsgUtil == null) {
                    txMsgUtil = new TxMsgUtil();
                }
            }
        }
        return txMsgUtil;
    }


    /**
     * 单发短信
     * @param phoneNumber
     * @param msg
     * @return
     */
    public SmsSingleSenderResult sendMsg(Integer appId,String appKey,String phoneNumber,String msg){
        SmsSingleSenderResult result =null;
        try {
            SmsSingleSender ssender = new SmsSingleSender(appId, appKey);
            result = ssender.send(0, "86", phoneNumber, msg, "", "");
        }catch (HTTPException e) {
            log.error("HTTP响应码错误");
        }catch (JSONException e) {
            log.error("json解析错误");
        } catch (IOException e) {
            log.error("网络IO错误");
        }
        return result;
    }

    /**
     * 指定模板单发短信
     * @param phoneNumber
     * @param templateId
     * @param params
     * @return
     */
    public SmsSingleSenderResult sendMsgByTemp(Integer appId,String appKey,String phoneNumber,Integer templateId,String[] params){
        SmsSingleSenderResult result =null;
        try {
            SmsSingleSender ssender = new SmsSingleSender(appId, appKey);
            result = ssender.sendWithParam("86", phoneNumber, templateId,params,null ,"", "");
        }catch (HTTPException e) {
            log.error("HTTP响应码错误");
        }catch (JSONException e) {
            log.error("json解析错误");
        } catch (IOException e) {
            log.error("网络IO错误");
        }
        return result;
    }

    /**
     * 群发短信
     * @param phoneNumbers
     * @param msg
     * @return
     */
    public SmsMultiSenderResult sendMsgMulti(Integer appId,String appKey,String[] phoneNumbers,String msg){
        SmsMultiSenderResult result =null;
        try {
            SmsMultiSender ssender = new SmsMultiSender (appId, appKey);
            result = ssender.send(0,"86", phoneNumbers, msg ,"", "");
        }catch (HTTPException e) {
            log.error("HTTP响应码错误");
        }catch (JSONException e) {
            log.error("json解析错误");
        } catch (IOException e) {
            log.error("网络IO错误");
        }
        return result;
    }

    /**
     * 群发指定模板
     * @param phoneNumbers
     * @param msg
     * @param templateId
     * @param params
     * @return
     */
    public SmsMultiSenderResult sendMsgMultiByTemp(Integer appId,String appKey,String[] phoneNumbers,String msg,Integer templateId,String[] params){
        SmsMultiSenderResult result =null;
        try {
            SmsMultiSender ssender = new SmsMultiSender (appId, appKey);
            result = ssender.sendWithParam("86", phoneNumbers,templateId, params, "", "", "");
        }catch (HTTPException e) {
            log.error("HTTP响应码错误");
        }catch (JSONException e) {
            log.error("json解析错误");
        } catch (IOException e) {
            log.error("网络IO错误");
        }
        return result;
    }


    public static long getRandom() {
        return (new Random(getCurrentTime())).nextLong() % 900000L + 100000L;
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis() / 1000L;
    }

    private static String sha256(String rawString) {
        return DigestUtils.sha256Hex(rawString);
    }
}


