package com.spark.bitrade.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spark.bitrade.constant.BooleanEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member_application_config")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberApplicationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    /**
     *   0/1(关闭/开启)
     */
    private BooleanEnum withdrawCoinOn = BooleanEnum.IS_TRUE ;

    private BooleanEnum rechargeCoinOn = BooleanEnum.IS_TRUE ;

    private BooleanEnum promotionOn = BooleanEnum.IS_TRUE ;

    private BooleanEnum transactionOn = BooleanEnum.IS_TRUE ;

}
