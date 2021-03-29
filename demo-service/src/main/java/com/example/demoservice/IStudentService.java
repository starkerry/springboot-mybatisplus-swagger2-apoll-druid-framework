package com.example.demoservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomodel.enity.Student;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
public interface IStudentService extends IService<Student> {
    String get();
}
