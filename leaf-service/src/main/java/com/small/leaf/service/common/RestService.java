package com.small.leaf.service.common;

import com.alibaba.fastjson.JSONObject;
import com.small.leaf.domain.common.ServiceResult;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;

/**
 * @Author: yefan
 * @Date: 2019/4/25 5:56 PM
 */
public interface RestService {

    /**
     * get请求
     */
    ServiceResult parseGetResult(Map<String, Object> map, String url);

    /**
     * get请求
     */
    ServiceResult parseGetResult(HashMap<String, Object> map, String url);

    /**
     * 无参或已拼接参数get请求
     */
    ServiceResult parseGetResult(String url);

    /**
     * post请求
     */
    ServiceResult parsePostResult(LinkedMultiValueMap<String, Object> map, String url);

    /**
     * 带有请求头的post请求
     */
    ServiceResult parsePostResultWithHeader(HttpHeaders httpHeader, JSONObject params,
            String url);


}
