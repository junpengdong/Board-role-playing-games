package com.board.games.utils;


import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/14.
 */
public class RandomCode {
    public static String getValiCode(int codeLength){
        //随机获取4个英文字母
        ArrayList list = new ArrayList();
        for (char c = 'a'; c <= 'z'; c++) {
            list.add(c);
        }

        String code = "";
        for (int i = 0; i < codeLength; i++) {
            int num = (int) (Math.random() * list.size());
            code = code + list.get(num);
            list.remove(num);
        }
        return code;
    }
}
