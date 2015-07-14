package com.github.nikuyoshi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Thread1 implements Runnable {
    
    Count count = new Count();
    Lock lock = new ReentrantLock();
    
    public Thread1(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    
    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(this.getClass().getName() + " " + count.toString());
                count.increment();
                TimeUnit.SECONDS.sleep(1);
                System.out.println(this.getClass().getName() + " " + count.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(this.getClass().getName() + " スレッドを開放します");
                lock.unlock();
            }
        }
    }
}