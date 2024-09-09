package com.example.food.Config.QuartzConfig;


import com.example.food.Schedule.CaculatePoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
@Import(CaculatePoints.class)
public class QuartzConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzConfig.class);

    @Value("${org.quartz.scheduler.instanceName}")
    private String instanceName;

    @Value("${org.quartz.scheduler.instanceId}")
    private String instanceId;

    @Value("${org.quartz.threadPool.threadCount}")
    private String threadCount;

    @Autowired
    @Qualifier("cronCaculatePointsTriggerBean")
    private CronTriggerFactoryBean cronCaculatePointsTrigger;

    @Bean
    public org.quartz.spi.JobFactory jobFactory(ApplicationContext applicationContext) {
        QuartzJobFactory JobFactory = new QuartzJobFactory();
        JobFactory.setApplicationContext(applicationContext);
        return JobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();

        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory(applicationContext));

        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceName", instanceName);
        quartzProperties.setProperty("org.quartz.scheduler.instanceId", instanceId);
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", threadCount);

        factory.setQuartzProperties(quartzProperties);
        factory.setTriggers(cronCaculatePointsTrigger.getObject());
        LOGGER.info("starting jobs...");

        return factory;
    }
}

