package com.small.leaf;

import com.alibaba.fastjson.JSONObject;
import com.small.leaf.domain.common.ServiceResult;
import com.small.leaf.service.common.RestService;
import com.small.leaf.service.common.config.RestConfig;
import com.small.leaf.service.common.impl.RestServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yefan
 * @Date: 2019/4/25 5:45 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RestConfig.class, RestServiceImpl.class})
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestService restService;

    @Test
    public void httpApiTest(){
        String url = "https://www.apiopen.top/weatherApi";
        Map<String, Object> map = new HashMap<>();
        map.put("city","成都");
        String result = restTemplate.getForObject(url, String.class, map);
        JSONObject jResult = JSONObject.parseObject(result);
        System.out.println(jResult);
    }

    @Test
    public void httpRestServiceTest(){
        String url = "https://www.apiopen.top/weatherApi";
        Map<String, Object> map = new HashMap<>();
        map.put("city","成都");
        ServiceResult result = restService.parseGetResult(map, url);
        System.out.println(result.getContent());
    }
}
