package com.example.demodao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@EnableTransactionManagement
@Configuration
@MapperScans({
        @MapperScan("com.example.demodao.mapper")
})
public class MybatisPlusConfiguration {
    public static void main(String[] args) {
        System.out.println("in");
    }
}
