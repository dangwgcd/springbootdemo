//package com.my.config.quartz;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerBean;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.text.ParseException;
//
//@Configuration
//public class SchedledConfiguration {
//    private static final Logger LOGGER = LoggerFactory.getLogger(SchedledConfiguration.class);
//
//
//    // 配置中设定了
//    // ① targetMethod: 指定需要定时执行scheduleInfoAction中的simpleJobTest()方法
//    // ② concurrent：对于相同的JobDetail，当指定多个Trigger时, 很可能第一个job完成之前，
//    // 第二个job就开始了。指定concurrent设为false，多个job不会并发运行，第二个job将不会在第一个job完成之前开始。
//    // ③ cronExpression：0/10 * * * * ?表示每10秒执行一次，具体可参考附表。
//    // ④ triggers：通过再添加其他的ref元素可在list中放置多个触发器。 scheduleInfoAction中的simpleJobTest()方法
//    @Bean(name = "detailFactoryBean")
//    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTasks scheduledTasks) {
//        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
//        bean.setTargetObject(scheduledTasks);
//        bean.setTargetMethod("reportCurrentByCron");
//        bean.setConcurrent(false);
//        return bean;
//    }
//
//    @Bean(name = "cronTriggerBean")
//    public CronTriggerFactoryBean cronTriggerBean(MethodInvokingJobDetailFactoryBean detailFactoryBean) {
//        CronTriggerFactoryBean triggerBean = new CronTriggerFactoryBean();
//        triggerBean.setJobDetail(detailFactoryBean.getObject());
//        triggerBean.setCronExpression("0/5 * * * * ? ");//每5秒执行一次
//        return triggerBean;
//
//    }
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactory(CronTriggerBean[] cronTriggerBean) {
//        SchedulerFactoryBean bean = new SchedulerFactoryBean();
//        LOGGER.info(""+cronTriggerBean[0]);
//        bean.setTriggers(cronTriggerBean);
//        return bean;
//    }
//}