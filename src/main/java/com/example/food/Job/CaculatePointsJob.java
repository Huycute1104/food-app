package com.example.food.Job;

import com.example.food.Service.Service.CaculatePointsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class CaculatePointsJob implements Job {

    @Autowired
    private CaculatePointsService cronService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        cronService.caculatePoints();
    }

}

