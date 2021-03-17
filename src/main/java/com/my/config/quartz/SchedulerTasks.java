package com.my.config.quartz;

import com.my.job.UserJob;
import com.my.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Configurable
@EnableScheduling//标注启动定时任务
@Configuration
public class SchedulerTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerTasks.class);

    @Scheduled(fixedRate = 1000 * 30)//定义某个定时任务，每30s
    public void reportCurrentTime() {
        LOGGER.info("Scheduling Tasks Examples: The time is now " + DateUtil.getNowDate());
    }

    //每2s执行一次
    @Scheduled(cron = "0/2 * * * * ? ")
    public void reportCurrentByCron() {
        userJob().getUserById();
    }


    @Bean
    public UserJob userJob() {
        return new UserJob();
    }

}