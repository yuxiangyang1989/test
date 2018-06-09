package com.bigdata.framework.common.utils;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.stream.IntStream;

/**
 * @author yang
 * @ClassName: StringUtils
 * @Description:
 * @date 2018-05-29
 * @version:
 */
@Slf4j
public class StringUtils extends org.apache.commons.lang3.StringUtils  {
    // 下划线字符
    private static final char UNDERLINE = '_';
    //  图片webp后缀
    private final static String IMAGE_STYLE = "-w220";
    private final static String IMAGE_MOBILE_STYLE = "-w1080";

    /**
     * 将带有下划线的字符串转换成驼峰字符串
     * download_count => downloadCount
     *
     * @param str 需要转换的字符串
     * @return 变成驼峰形式字符串
     */
    public static String underlineToCamel(String str) {
        if (isEmpty(str)) {
            return EMPTY;
        }
        String temp = str.toLowerCase();
        int len = temp.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = temp.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(temp.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将驼峰形式字符串转换成下划线形式
     * downloadCount => download_count
     *
     * @param str 需要转换的字符串
     * @return 变成下划线形式字符串
     */
    public static String camelToUnderline(String str) {
        if (isEmpty(str)) {
            return EMPTY;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                sb.append(UNDERLINE);
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    /**
     * 取汉语拼音的首字母
     *
     * @param chinese 汉字
     * @return 首字母
     */
    public static String getPinyinInitial(String chinese) {
        String pinyin = chineseToPinyin(chinese, true);
        return isBlank(pinyin) ? EMPTY : pinyin.substring(0, 1).toUpperCase();
    }

    /**
     * 汉字转换位汉语拼音，英文字符不变
     *
     * @param chinese       汉字
     * @param firstCharOnly 只取首字母
     * @return 拼音
     */
    public static String chineseToPinyin(String chinese, boolean firstCharOnly) {
        if (StringUtils.isBlank(chinese)) {
            return StringUtils.EMPTY;
        }

        String pinyinName = "";
        char[] chars = chinese.toCharArray();
        HanyuPinyinOutputFormat formatter = new HanyuPinyinOutputFormat();
        formatter.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        formatter.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        StringBuilder pinyinBuilder = new StringBuilder();
        IntStream.range(0, chars.length).forEach(idx -> {
            if (chars[idx] > 128) {
                try {
                    String pinyin = PinyinHelper.toHanyuPinyinStringArray(chars[idx], formatter)[0];
                    pinyinBuilder.append(firstCharOnly ? pinyin.charAt(0) : pinyin);
                } catch (Exception ex) {
                    log.warn(ex.getMessage());
                }
            } else {
                pinyinBuilder.append(chars[idx]);
            }
        });
        return pinyinBuilder.toString();
    }

    /**
     * 检查两个字符串是不是完全不同，
     * 主要用于数据更新时，对两个字段进行检查
     *
     * @param str1 String
     * @param str2 String
     * @return true: 两个字符不同
     */
    public static boolean isNotSame(String str1, String str2) {
        if (null == str1 || null == str2) {
            return false;
        } else if (str1.equalsIgnoreCase(str2)) {
            return false;
        }
        return true;
    }

    /**
     * 每两个字符互换位置
     *
     * @param input 需要处理的字符串
     * @return 互换位置后的字符串
     */
    public static String swapChar(String input) {
        if (input == null) {
            return null;
        }
        char[] original = input.toCharArray();
        char[] changed = new char[original.length];
        for (int i = 0; i < original.length / 2; i++) {
            int start = i * 2;
            int next = i * 2 + 1;
            changed[start] = original[next];
            changed[next] = original[start];
        }
        if (original.length % 2 == 1) {
            changed[original.length - 1] = original[original.length - 1];
        }

        return new String(changed);
    }

    /**
     * 去除url后面的style属性，如-w220、-w1080
     * 因为目前的附件处理都是加了这属性的，日后待优化
     *
     * @param path
     * @return
     */
    public static String getPathWithoutStyle(String path) {
        if (isBlank(path)) {
            return path;
        }
        if (path.endsWith(IMAGE_STYLE)) {
            return path.replace(IMAGE_STYLE, "");
        }
        if (path.endsWith(IMAGE_MOBILE_STYLE)) {
            return path.replace(IMAGE_MOBILE_STYLE, "");
        }

        return path;
    }

    /**
     * 用户身份证号码/电话号码的打码隐藏加星号加*
     * <p>参数异常直接返回null</p>
     * @param idCardNum
     * @param front
     * @param end
     * @return
     */
    public static String mask(String idCardNum, int front, int end) {
        //身份证不能为空
        if (isEmpty(idCardNum)) {
            return null;
        }
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) {
            return null;
        }
        //需要截取的不能小于0
        if (front < 0 || end < 0) {
            return null;
        }
        //计算*的数量
        int asteriskCount = idCardNum.length() - (front + end);
        StringBuffer asteriskStr = new StringBuffer();
        for (int i = 0; i < asteriskCount; i++) {
            asteriskStr.append("*");
        }
        String regex = "(\\w{" + String.valueOf(front) + "})(\\w+)(\\w{" + String.valueOf(end) + "})";
        return idCardNum.replaceAll(regex, "$1" + asteriskStr + "$3");

    }
}
