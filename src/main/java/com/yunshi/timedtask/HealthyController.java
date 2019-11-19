package com.yunshi.timedtask;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author makang
 * @date 2019年10月28日10:05:09
 * 健康查询
 */
@Controller
@Slf4j
public class HealthyController {


    private static final String HEALTH_COLLECTION_NAME = "health_monitors";

    @GetMapping("api/healthy/check")
    @ResponseBody
    public String check() {
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("message", "success");
        return result.toString();
    }

    @PostMapping("v1/testPost")
    @ResponseBody
    public String testPost(@RequestBody String json){

        try{
            log.info("接收到Post请求，参数为："+json);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "处理成功";
    }

    @GetMapping("v1/testGet")
    @ResponseBody
    public String testGet(){

        try{
            log.info("接收到Get请求，没有明确参数");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "处理成功";
    }
}
