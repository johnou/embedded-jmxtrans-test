package com.sulake.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Johno Crawford (johno@sulake.com)
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jmxContext.xml");
        context.registerShutdownHook();

        TestStatisticsService statisticsService = context.getBean(TestStatisticsService.class);
        statisticsService.incrementTestCount();

        waitForever();
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public static void waitForever() {
        Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            }
            catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
