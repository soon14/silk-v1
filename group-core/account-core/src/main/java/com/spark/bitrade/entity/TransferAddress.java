package com.spark.bitrade.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spark.bitrade.constant.CommonStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Zhang Jinwei
 * @date 2018年02月27日
 */
@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @JoinColumn(name = "coin_id")
    @ManyToOne
    private Coin coin;
    private String address;
    @Column(columnDefinition = "decimal(18,6) comment '转账手续费率'")
    private BigDecimal transferFee=BigDecimal.ZERO;
    @Column(columnDefinition = "decimal(18,2) comment '最低转账数目'")
    private BigDecimal minAmount=BigDecimal.ZERO;
    @Enumerated(EnumType.ORDINAL)
    private CommonStatus status=CommonStatus.NORMAL;
}
