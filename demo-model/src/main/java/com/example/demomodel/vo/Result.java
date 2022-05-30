package com.example.demomodel.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Data
public class Result<T> implements Serializable {

    public static final Result OK = new Result(1);

    @ApiModelProperty(value = "status")
    private int status;

    @ApiModelProperty(value = "errorCode or businessCode")
    private int code;

    @ApiModelProperty(value = "error message")
    private String msg;

    @ApiModelProperty(value = "data")
    private T data;

    private Result(int status) {
        this.status = status;
    }

    private String errorInfo;

    private String msgInfo;

    private String test;

    private String name;
    // you can also create your own constructors
}
