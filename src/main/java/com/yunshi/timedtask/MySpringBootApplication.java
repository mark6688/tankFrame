package com.yunshi.timedtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world
 *
 * @author SongYuanKun
 */


@RestController
//定时任务
@EnableScheduling

@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @RequestMapping("/hello")
    public String helloWord() {
        return "定时服务已启动";
    }
    

}
