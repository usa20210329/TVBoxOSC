package com.github.tvbox.osc.util;

import java.util.LinkedHashSet;
import java.util.Set;

public class StrUtil {

    public static boolean equals(String str1, String str2) {
        return equals(str1, str2, false);
    }

    public static boolean equals(String str1, String str2, boolean ignoreCase) {
        if (null == str1) {
            return str2 == null;
        }

        if (null == str2) {
            return false;
        }

        if (ignoreCase) {
            return str1.equalsIgnoreCase(str2);
        } else {
            return str1.equals(str2);
        }
    }

    public static boolean contains(String str, String searchStr) {
        if (null == str || null == searchStr) {
            return false;
        }

        return str.contains(searchStr);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 分词处理.
     * @param searchTitle
     * @return
     */
    public static Set<String> getWords(String searchTitle) {
        Set<String> set = new LinkedHashSet<>();
        set.add(searchTitle);
        boolean found = false;
        String[] splits = new String[] { "/", "之", " ", "　", "第", "-", "\\(", "（", "\\[", "：" };
        String[] array = new String[] { "粤语版", "粤语", "国语版", "国语", "日本版", "韩国版", "台湾剧", "台剧", "加更版", "TV版",
                "未删减版", "新传", "前传" };
        for (String str : splits) {
            if (searchTitle.contains(str)) {
                String[] strArray = searchTitle.split(str);
                set.add(strArray[0]);
                found = true;
                break; // 包含一个, 就结束
            }
        }

        if (!found) {
            String filter = filterChinese(searchTitle);
            if (StrUtil.isNotBlank(filter)) {
                boolean isContains = false;
                for (String str : array) {
                    if (filter.contains(str)) {
                        isContains = true;
                        set.add(filter.replace(str, ""));
                        break; // 包含一个 就结束
                    }
                }

                // 如果上面都不包含 就把纯中文的加进去
                if (!isContains) {
                    set.add(filter);
                }              
            }
        }

        return set;
    }

    /**
     * 过滤中文.
     * @param chin
     * @return
     */
    public static String filterChinese(String chin) {
        if (isNotBlank(chin)) {
            chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
        }
        return chin;
    }
}
