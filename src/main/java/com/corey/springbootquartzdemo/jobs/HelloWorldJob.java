package com.corey.springbootquartzdemo.jobs;

import com.corey.springbootquartzdemo.info.TimerInfo;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        log.info(info.getCallBackData());
    }
    
    
}
