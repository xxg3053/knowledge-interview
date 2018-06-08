package com.kenfo.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.entity
 * @Description: TODO
 * @date 2018/5/12 上午9:56
 */
@Data
@ApiModel(description = "用户")
public class User {

    @ApiModelProperty(value = "用户ID")
    private int id;
    @ApiModelProperty(value = "姓名")
    private String username;
    private int age;
    private Date ctm;

}
