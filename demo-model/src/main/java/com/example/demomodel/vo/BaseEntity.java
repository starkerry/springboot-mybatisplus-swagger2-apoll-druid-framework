package com.example.demomodel.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Data
public abstract class BaseEntity implements Serializable {
    @ApiModelProperty(value = "primary key")
    @TableId(type = IdType.AUTO)
    private Long id;
}
