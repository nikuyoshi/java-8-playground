package com.github.nikuyoshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String... args){
        try {
            executeNewSingleThreadExecutor();
            executeNewFixedThreadPool();
            executeNewCachedThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static void executeNewSingleThreadExecutor() throws InterruptedException{
        System.out.println("---newSingleThreadExecutor---");
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++){
            service.submit(new Task(i));
        }
        Thread.sleep(10000);
        service.shutdown();
    }
    
    private static void executeNewFixedThreadPool() throws InterruptedException{
        System.out.println("---newFixedThreadPool---");
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 100; i++){
            service.submit(new Task(i));
        }
        Thread.sleep(10000);
        service.shutdown();
    }
    
    private static void executeNewCachedThreadPool() throws InterruptedException{
        System.out.println("---newCachedThreadPool---");
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++){
            service.submit(new Task(i));
        }
        Thread.sleep(1000);
        service.shutdown();
            
    }
    
}
