package com.small.leaf.service.common;

import com.alibaba.fastjson.JSONObject;
import com.small.leaf.domain.common.ServiceResult;

/**
 * @Author: yefan
 * @Date: 2019/4/26 11:07 AM
 */
public class BaseRestService {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILED = 500;



    public ServiceResult buildSuccessResult(JSONObject jsonObject){
        ServiceResult result = new ServiceResult();
        result.setContent(jsonObject);
        result.setCode(CODE_SUCCESS);
        return result;
    }

    public ServiceResult buildErrorResult(String msg){
        ServiceResult result = new ServiceResult();
        result.setCode(CODE_FAILED);
        result.setMessage(msg);
        return result;
    }

}
