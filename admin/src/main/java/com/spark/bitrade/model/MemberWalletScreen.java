package com.spark.bitrade.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberWalletScreen extends AccountScreen{

    String unit ;

    String walletAddress ;

    BigDecimal minBalance ;

    BigDecimal maxBalance ;

    BigDecimal minFrozenBalance;

    BigDecimal maxFrozenBalance ;

    BigDecimal minAllBalance ;

    BigDecimal maxAllBalance ;

}
