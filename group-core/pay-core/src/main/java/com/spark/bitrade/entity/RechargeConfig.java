package com.spark.bitrade.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 充值配置表(RechargeConfig)表实体类
 *
 * @author daring5920
 * @since 2019-09-04 10:52:12
 */
@SuppressWarnings("serial")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "充值配置表")
public class RechargeConfig {

    /**
     * 配置id
     */
    @TableId
    @ApiModelProperty(value = "配置id", example = "")
    private Long id;

    /**
     * 币种单位
     */
    @ApiModelProperty(value = "币种单位", example = "")
    private String unit;

    /**
     * 充值数量
     */
    @ApiModelProperty(value = "充值数量", example = "")
    private BigDecimal rechargeAmount;

    /**
     * 充值开关，0 关闭，1开启 默认0
     */
    @ApiModelProperty(value = "充值开关，0 关闭，1开启 默认0", example = "")
    private Integer rechargeSwitch;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", example = "")
    private Date updateTime;


}