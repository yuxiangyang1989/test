package com.bigdata.framework.common.utils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author yang
 * @ClassName: TokenUtil
 * @Description:自制token
 * @date 2018-06-07
 * @version:
 */
public class TokenUtil {
    public static final String TOKEN = "token";

    public static String generateToken() {
        return (new Long(System.currentTimeMillis())).toString();
    }

    public static String getToken(HttpSession session) {
        String token = generateToken();
        saveToken(session, token);
        return token;
    }

    public static void saveToken(HttpSession session, String token) {
        ArrayList<String> tokenList = getTokenList(session);
        tokenList.add(token);
        session.setAttribute("tokenList", tokenList);
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<String> getTokenList(HttpSession session) {
        Object obj = session.getAttribute("tokenList");
        if (obj != null) {
            return (ArrayList) obj;
        } else {
            ArrayList<String> tokenList = new ArrayList<String>();
            return tokenList;
        }
    }

    public static boolean isTokenValid(HttpSession session, String token) {
        boolean isValid = false;
        if (session != null) {
            ArrayList<String> tokenList = getTokenList(session);
            //如果tokenList中包含token(表单页生成的token(long类型)), 说明token未进行过tokenList.remove(token)处理, 即是第一次处理。
            //如果tokenList中不包含token, 说明此token已经进行过tokenList.remove(token)处理, 即意味着这是重复操作。
            if (tokenList.contains(token)) {
                isValid = true;
                tokenList.remove(token);
            }
        }
        return isValid;
    }
}
