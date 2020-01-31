package com.wh.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @program: order_service
 * @description:
 * @author: wh
 * @create: 2019-10-14 15:28
 */
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json字符串转为JsonNode的方法
     * @param s
     * @return
     */
    public static JsonNode str2JsonNode(String s){
        try {
            return objectMapper.readTree(s);
        }catch (IOException e){
            return null;
        }
    }
}
