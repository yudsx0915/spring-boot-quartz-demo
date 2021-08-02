package com.corey.springbootquartzdemo.playground;


import com.corey.springbootquartzdemo.services.CronSchedulerService;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {
    
    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private CronSchedulerService cronSchedulerService;

    @PostMapping("runhelloworld")
    public void runHelloWorld() {
        playgroundService.runHelloWorldJob();
    }

    @PostMapping("testcron")
    public void testCron() throws SchedulerException {
        cronSchedulerService.testCronSchedule();
    }
}
