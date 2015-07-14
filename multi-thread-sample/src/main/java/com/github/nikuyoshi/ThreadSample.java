package com.github.nikuyoshi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSample {
    
    public static void main(String[] args) {
    
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new Thread1(count, lock));
        Thread thread2 = new Thread(new Thread2(count, lock));
        thread1.start();
        thread2.start();
    }
}


