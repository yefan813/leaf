package com.small.leaf.service.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.small.leaf.domain.common.ServiceResult;
import com.small.leaf.service.common.BaseRestService;
import com.small.leaf.service.common.RestService;
import com.small.leaf.service.common.exception.CoreServiceException;
import com.small.leaf.service.common.exception.enums.CoreServiceExcepType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yefan
 * @Date: 2019/4/25 6:10 PM
 */
@Service
public class RestServiceImpl extends BaseRestService implements RestService {

    /**
     * logger
     **/
    private static final Logger logger = LoggerFactory.getLogger(RestServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 发送get请求
     *
     * @param map 参数map
     * @param url 请求地址，参数拼接在链接中，用通配符代表 示例 : Map<String, Object> map = new HashMap<String, Object>;
     * map.put("channel", 1); map.put("goodsId", 2); String url = "http://localhost:8083/goods/goodsIndex?channel={channel}&goods_id={goodsId}";
     * 根据实际情况自己添加参数
     */
    @Override
    public ServiceResult parseGetResult(Map<String, Object> map, String url) {
        ServiceResult result;
        try {
            String sResult = restTemplate.getForObject(url, String.class, map);
            JSONObject jResult = JSONObject.parseObject(sResult);
            result = buildSuccessResult(jResult);
        } catch (CoreServiceException e) {
            result = buildErrorResult("url:" + url + "请求失败");
            logger.info("url:{}, map:{},请求失败", url, map);
            e = new CoreServiceException(CoreServiceExcepType.REQUEST_CODE, "请求失败");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 发送get请求
     *
     * @param map 参数map
     * @param url 请求地址，地址中不需要拼接参数，在方法中处理 示例 : HashMap<String, Object> map = new HashMap<String,
     * Object>; map.put("channel", 1); map.put("goodsId", 2); String url =
     * "http://localhost:8083/goods/goodsIndex"; 根据实际情况自己添加参数
     */
    @Override
    public ServiceResult parseGetResult(HashMap<String, Object> map, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (!MapUtils.isEmpty(map)) {
            Set<String> keys = map.keySet();
            sb.append("?");
            for (String str : keys) {
                sb.append(str);
                sb.append("=");
                sb.append(map.get(str).toString());
                sb.append("&");
            }
        }
        String finalUrl = sb.toString();
        if (finalUrl.endsWith("&")) {
            finalUrl = finalUrl.substring(0, finalUrl.length() - 1);
        }
        ServiceResult result = this.parseGetResult(finalUrl);
        return result;
    }

    /**
     * 发送get请求
     *
     * @param url 请求地址 请求为纯字符串，可以是无参数的get请求，也可以是将参数的K V都拼接好传入 示例 1、http://localhost:8083/goods/goodsIndex
     * 2、http://localhost:8083/goods/goodsIndex?channel=1&goods_id=2 以上两种方式都支持
     */
    @Override
    public ServiceResult parseGetResult(String url) {
        ServiceResult result = new ServiceResult();
        try {
            String sResult = restTemplate.getForObject(url, String.class);
            JSONObject jResult = JSONObject.parseObject(sResult);
            result = buildSuccessResult(jResult);
        } catch (CoreServiceException e) {
            result = buildErrorResult("url:" + url + "请求失败");
            logger.info("url:{}, map:{},请求失败", url);
            e = new CoreServiceException(CoreServiceExcepType.REQUEST_CODE, "请求失败");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 发送post请求
     *
     * @param map 请求参数集合
     * @param url 示例： MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
     * map.add("channel", 1); map.add("goods_id", 2); String url = "http://localhost:8083/goods/goodsIndex";
     * 根据实际情况自己添加参数
     */
    @Override
    public ServiceResult parsePostResult(LinkedMultiValueMap<String, Object> map, String url) {
        ServiceResult result = new ServiceResult();
        try {
            String sResult = restTemplate.postForObject(url, map, String.class);
            JSONObject jResult = JSONObject.parseObject(sResult);
            result = buildSuccessResult(jResult);
        } catch (CoreServiceException e) {
            result = buildErrorResult("url:" + url + "请求失败");
            logger.info("url:{}, map:{},请求失败", url, map);
            e = new CoreServiceException(CoreServiceExcepType.REQUEST_CODE, "请求失败");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 带header的http post请求 header中的值可以自己设置
     */
    @Override
    public ServiceResult parsePostResultWithHeader(HttpHeaders httpHeader, JSONObject params,
            String url) {
        ServiceResult result;
        try {
            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params,
                    httpHeader);
            ResponseEntity exchange = restTemplate
                    .exchange(url, HttpMethod.POST, httpEntity, String.class);
            JSONObject jResult = JSONObject.parseObject(exchange.getBody().toString());
            result = buildSuccessResult(jResult);
        } catch (Exception e) {
            logger.info("url:{}, map:{},请求失败", url, params);
            result = buildErrorResult("url:" + url + "请求失败");
        }
        return result;
    }


}
