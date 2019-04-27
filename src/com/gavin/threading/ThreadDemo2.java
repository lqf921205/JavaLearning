package com.gavin.threading;

public class ThreadDemo2 {
    public static void main(String[] args) {

        RunnableDemo runnable = new RunnableDemo("test");
        runnable.run();
    }
}

class RunnableDemo implements Runnable {
    private String threadName;


    public RunnableDemo() {
    }

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName+" run thread!");
        }
    }
}
