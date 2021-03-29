package com.example.demoapi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class, scanBasePackages = {"com.example.*"})
@EnableCaching
@MapperScan("com.example.demodao.mapper")
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
