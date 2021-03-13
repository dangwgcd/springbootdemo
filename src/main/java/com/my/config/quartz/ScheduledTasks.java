//package com.my.config.quartz;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Component
//@Configurable
//@EnableScheduling//标注启动定时任务
//public class ScheduledTasks{
//    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
//
////    @Scheduled(fixedRate = 1000 * 30)//定义某个定时任务，每30s
//    public void reportCurrentTime(){
//        LOGGER.info ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
//    }
//
//    //每1分钟执行一次
////    @Scheduled(cron = "0 */1 *  * * * ")
//    public void reportCurrentByCron(){
//        LOGGER.info ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
//    }
//
//    private SimpleDateFormat dateFormat(){
//        return new SimpleDateFormat ("HH:mm:ss");
//    }
//
//}