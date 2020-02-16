package com.edu.audit.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: EmailCodeUtils
 * @Description: 邮箱验证码工具类
 * @Author: Vince
 * @Date: 2020/2/16 11:59
 * @Version: v1.0
 */
public class EmailCodeUtils {
    public static String achieveCode() {
        String[] beforeShuffle = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z"
        };
        List<String> list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        return afterShuffle.substring(3, 9);
    }
}
