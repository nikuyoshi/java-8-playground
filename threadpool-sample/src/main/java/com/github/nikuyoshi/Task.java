package com.github.nikuyoshi;

public class Task implements Runnable{
    
    private int taskId;
    
    public Task(int id){
        this.taskId = id;
    }

    public void run() {
        System.out.println("Task ID: " + this.taskId + "performed by" + Thread.currentThread().getName());
    }
    
}
