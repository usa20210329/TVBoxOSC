package com.github.tvbox.osc.util;

/**
 * 数字工具.
 * @author anaer
 */
public class NumUtil {
    
    /**
     * 字符串转整型. 
     * 转化失败返回null
     * @param str
     * @return
     */
    public static Integer toInt(String str){
        return toInt(str, null);
    }

    /**
     * 字符串转整型.
     * @param str 字符串
     * @param defValue 默认值
     * @return
     */
    public static Integer toInt(String str, Integer defValue){
        try{
            return Integer.parseInt(str);
        }catch(Exception e){
            return defValue;
        }
    }
}
