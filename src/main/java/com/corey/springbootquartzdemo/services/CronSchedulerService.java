package com.corey.springbootquartzdemo.services;

import com.corey.springbootquartzdemo.jobs.TestCronJob;
import com.corey.springbootquartzdemo.jobs.TestCronJob2;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class CronSchedulerService {
    public void testCronSchedule() throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(TestCronJob.class)
                                        .withIdentity(TestCronJob.class.getSimpleName(), "group1")
                                        .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                                        .withIdentity(TestCronJob.class.getSimpleName(), "group1")
                                        .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                                        .build();

        scheduler.scheduleJob(jobDetail, trigger);

        JobDetail jobDetail2 = JobBuilder.newJob(TestCronJob2.class)
                                        .withIdentity(TestCronJob2.class.getSimpleName(), "group1")
                                        .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                                        .withIdentity(TestCronJob2.class.getSimpleName(), "group1")
                                        .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                                        .build();


        scheduler.scheduleJob(jobDetail2, trigger2);
    }
}
