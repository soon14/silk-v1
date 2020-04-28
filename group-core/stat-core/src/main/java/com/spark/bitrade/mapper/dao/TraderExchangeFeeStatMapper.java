package com.spark.bitrade.mapper.dao;

import com.spark.bitrade.entity.TraderExchangeFeeStat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zhang Yanjun
 * @time 2018.12.17 15:36
 */
@Mapper
public interface TraderExchangeFeeStatMapper {

    List<TraderExchangeFeeStat> findAllBy(@Param("baseUnit") String baseUnit, @Param("coinUnit") String coinUnit, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
