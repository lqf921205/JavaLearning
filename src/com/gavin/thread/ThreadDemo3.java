package com.gavin.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 implements Callable<Integer> {


    public static void main(String[] args) {
        ThreadDemo3 thread = new ThreadDemo3();
        FutureTask<Integer> future = new FutureTask<Integer>(thread);
        new Thread(future, "有返回值的线程").start();
        try {

            System.out.println("线程的返回值：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {

        int temp = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                temp = i;
            }
        }
        return temp;

    }
}
