package com.spark.bitrade.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spark.bitrade.constant.OrderStatus;
import lombok.Data;

import java.util.Date;

@Data
public class OtcOrderTopScreen {

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date endTime;
    private OrderStatus status;
    private String unit;
}
