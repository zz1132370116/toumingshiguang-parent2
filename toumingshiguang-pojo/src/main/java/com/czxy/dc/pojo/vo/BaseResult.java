package com.czxy.dc.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 舍頭襘游泳 on 2018/12/12.
 */
@Data
@NoArgsConstructor

public class BaseResult {
    private Map<String,Object> data = new HashMap<>();
    public BaseResult(Integer errno, String errmsg) {
        data.put("errno" , errno);
        data.put("errmsg" , errmsg);
    }

    /**
     * 追加其他参数，支持链式
     * @param key
     * @param msg
     * @return
     */
    public BaseResult append(String key , Object msg){
        data.put(key , msg);
        return this;
    }
}
