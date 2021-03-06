package com.spark.bitrade.controller;

import com.spark.bitrade.service.BusinessDiscountRuleService;
import com.spark.bitrade.util.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/***
 * 
 * @author yangch
 * @time 2018.05.26 17:08
 */

@RestController
public class HealthyController {

    @Autowired
    private BusinessDiscountRuleService businessDiscountRuleService;
    /***
      * 负载均衡健康检查接口
      * @author yangch
      * @time 2018.05.26 17:04 
      */
    @RequestMapping("healthy")
    public MessageResult healthy(){
        return MessageResult.success();
    }

    @RequestMapping("/sleep/{sleepTime}")
    public String sleep(@PathVariable Long sleepTime) throws InterruptedException {
        //超时测试接口
        int i =0/1;
        TimeUnit.SECONDS.sleep(sleepTime);
        return "SUCCESS";
    }

    /**
     * 获取系统时间
     * @author tansitao
     * @time 2018/9/11 11:57 
     */
    @RequestMapping("systemTime")
    public MessageResult systemTime(){
        MessageResult mr = new MessageResult();
        mr.setData(System.currentTimeMillis());
        return mr;
    }

   /**
    * 刷新缓存
    * @author tansitao
    * @time 2018/10/11 13:51 
    */
    @RequestMapping("flushCache")
    public MessageResult flushCache(){
        businessDiscountRuleService.flushCache();
        return MessageResult.success();
    }
}
