package com.github.nikuyoshi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

class Thread2 implements Runnable{

    private Count count;
    private Lock lock;
    
    public Thread2(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(this.getClass().getName() + " " + count.toString());
            count.increment();
            System.out.println(this.getClass().getName() + " " + count.toString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getClass().getName() + " " + count.toString());
            count.increment();
            System.out.println(this.getClass().getName() + " " + count.toString());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getClass().getName() + " " + count.toString());
            count.increment();
            System.out.println(this.getClass().getName() + " " + count.toString());
        }finally {
            System.out.println(this.getClass().getName() + " スレッドを開放します");
            lock.unlock();
        }
    }
}
