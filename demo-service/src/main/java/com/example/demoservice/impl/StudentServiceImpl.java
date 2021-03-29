package com.example.demoservice.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demodao.mapper.StudentMapper;
import com.example.demomodel.enity.Student;
import com.example.demoservice.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public String get() {
        return JSONObject.toJSONString(studentMapper.selectById(1L));
    }
}
