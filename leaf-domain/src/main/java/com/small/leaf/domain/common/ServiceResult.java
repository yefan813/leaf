package com.small.leaf.domain.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: yefan
 * @Date: 2019/4/25 6:09 PM
 */
public class ServiceResult {

    private JSONObject content;
    private int code;
    private String message;

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
