//package ru.entel.smiu.web;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//@WebListener
//public class Test implements ServletContextListener {
//    private ScheduledExecutorService scheduler;
//
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
////        scheduler = Executors.newSingleThreadScheduledExecutor();
////        scheduler.scheduleAtFixedRate(new UpdateTest(), 0, 1, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        scheduler.shutdownNow();
//    }
//
//    public class UpdateTest implements Runnable {
//
//        @Override
//        public void run() {
////            System.out.println("------------------dwadwada");
//        }
//    }
//}
