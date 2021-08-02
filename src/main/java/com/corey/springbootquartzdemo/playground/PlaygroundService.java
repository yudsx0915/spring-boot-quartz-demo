package com.corey.springbootquartzdemo.playground;

import com.corey.springbootquartzdemo.info.TimerInfo;
import com.corey.springbootquartzdemo.jobs.HelloWorldJob;
import com.corey.springbootquartzdemo.services.SchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {
    
    @Autowired
    private SchedulerService schedulerService;


    public void runHelloWorldJob() {
        TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffSetMs(1000);
        info.setCallBackData("My Callback Data");
        
        schedulerService.schedule(HelloWorldJob.class, info);
    }
}
