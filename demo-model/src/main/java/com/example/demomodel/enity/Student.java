package com.example.demomodel.enity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demomodel.vo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="student object", description="student info")
@TableName("demo_student")
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "student number")
    private Integer studentNumber;

    @ApiModelProperty(value = "student name")
    private String studentNames;

    private String addresses;

    private Integer age;


}
