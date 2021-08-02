package com.corey.springbootquartzdemo.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// @Component
@WebListener
public class SpringInitialListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Spring End!!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Spring Start!!");
    }



}
