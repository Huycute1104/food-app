package com.example.food.Schedule;

import com.example.food.Job.CaculatePointsJob;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class CaculatePoints {

    @Value("${job.startDelay}")
    private Long startDelay;

    @Value("${job.repeatInterval}")
    private Long repeatInterval;

    @Value("${job.description}")
    private String description;

    @Value("${job.key}")
    private String key;


    @Bean(name = "caculatePointsTriggerBean")
    public SimpleTriggerFactoryBean caculatePointsTriggerBean() {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(caculateJobDetails().getObject());
        factoryBean.setStartDelay(startDelay);
        factoryBean.setRepeatInterval(repeatInterval);
        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return factoryBean;
    }

    @Bean(name = "cronCaculatePointsTriggerBean")
    public CronTriggerFactoryBean cronCaculatePointsTriggerBean() {
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(caculateJobDetails().getObject());
        stFactory.setStartDelay(startDelay);
        stFactory.setCronExpression("* * * ? * *");
        return stFactory;
    }

    @Bean(name = "caculateJobDetails")
    public JobDetailFactoryBean caculateJobDetails() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(CaculatePointsJob.class);
        jobDetailFactoryBean.setDescription(description);
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setName(key);

        return jobDetailFactoryBean;
    }

}

