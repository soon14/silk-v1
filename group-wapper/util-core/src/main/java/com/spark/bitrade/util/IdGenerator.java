package com.spark.bitrade.util;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/***
 * 
 * @author yangch
 * @time 2018.07.03 9:13
 */
public class IdGenerator {
    /**
     * Twitter-Snowflake算法 64位Long类型生成唯一ID 第一位0，表明正数 2-42，41位，表示毫秒时间戳差值，起始值自定义
     * 43-52，10位，机器编号，5位数据中心编号，5位进程编号 53-64，12位，毫秒内计数器 本机内存生成，性能高
     *
     * 主要就是三部分： 时间戳，进程id，序列号 时间戳41，id10位，序列号12位
     *
     * @author yangch
     * @since JDK 1.6
     */

    private static IdGenerator idGenerator;
    private final static long beginTs = 1483200000000L;

    private long lastTs = 0L;

    private long processId;
    private int processIdBits = 10;

    private long sequence = 0L;
    private int sequenceBits = 12;

    // 10位进程ID标识
    public IdGenerator(long processId) {
        if (processId > ((1 << processIdBits) - 1)) {
            throw new RuntimeException("进程ID超出范围，设置位数" + processIdBits + "，最大"
                    + ((1 << processIdBits) - 1));
        }
        this.processId = processId;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long ts = timeGen();
        if (ts < lastTs) {// 刚刚生成的时间戳比上次的时间戳还小，出错
            throw new RuntimeException("时间戳顺序错误");
        }
        if (ts == lastTs) {// 刚刚生成的时间戳跟上次的时间戳一样，则需要生成一个sequence序列号
            // sequence循环自增
            sequence = (sequence + 1) & ((1 << sequenceBits) - 1);
            // 如果sequence=0则需要重新生成时间戳
            if (sequence == 0) {
                // 且必须保证时间戳序列往后
                ts = nextTs(lastTs);
            }
        } else {// 如果ts>lastTs，时间戳序列已经不同了，此时可以不必生成sequence了，直接取0
            sequence = 0L;
        }
        lastTs = ts;// 更新lastTs时间戳
        return ((ts - beginTs) << (processIdBits + sequenceBits)) | (processId << sequenceBits) | sequence;
    }

    protected long nextTs(long lastTs) {
        long ts = timeGen();
        while (ts <= lastTs) {
            ts = timeGen();
        }
        return ts;
    }

    public static String getOrderId(String prefix){
        if(idGenerator==null){
            idGenerator =  new IdGenerator(new Random(10).nextInt(1023));
        }
        return prefix + idGenerator.nextId();
    }



    public static void main(String[] args) throws Exception {
        IdGenerator ig = new IdGenerator(1023);
        String str = "20170101";
        System.out.println(new SimpleDateFormat("YYYYMMDD").parse(str).getTime());
        Set<String> set = new HashSet<String>();
        //long begin = System.nanoTime();
        long begin = System.currentTimeMillis();
        String nextId;
        for (int i = 0; i < 10000; i++) {
            nextId = ig.nextId()+"";
            //nextId = IdGenerator.getOrderId("#");
            set.add(nextId);
            System.out.println(i+"="+nextId);
        }
        //System.out.println("time=" + (System.nanoTime() - begin)/1000.0 + " us");
        System.out.println("time=" + (System.currentTimeMillis() - begin) + "ms");
        System.out.println(set.size());
        //System.out.println(set);
    }

}
