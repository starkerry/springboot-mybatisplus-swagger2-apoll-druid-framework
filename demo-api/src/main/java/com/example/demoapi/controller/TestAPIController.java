package com.example.demoapi.controller;

import com.example.demoservice.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@RestController
@Api(tags = { "demo-api"})
@Slf4j
@RequestMapping("/demo_api")
public class TestAPIController {

    @Resource
    IStudentService routerService;

    @GetMapping(value = "/test", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "test-api", httpMethod = "GET")
    public Object batchSyncSchool(){
        return routerService.get();
    }
}
