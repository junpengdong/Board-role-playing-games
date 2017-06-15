package com.board.games.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
public final class APIUtil {

    private APIUtil(){}

    public static Map<String, Object> toMap(String message, boolean result){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", message);
        map.put("success", result);
        return map;
    }

    public static Map<String, Object> toMap(String message, boolean result, Object data){
        Map<String, Object> map = toMap(message, result);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> toMap(String message, boolean result, Map<String, Object> datas){
        Map<String, Object> map = toMap(message, result);
        map.putAll(datas);
        return map;
    }
    
    

    public static Map<String, Object> toMap(String message, boolean result, Object data, Map<String, Object> datas){
        Map<String, Object> map = toMap(message, result);
        map.put("data", data);
        map.putAll(datas);
        return map;
    }
}
