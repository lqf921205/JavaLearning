package com.gavin.threadpool;

import java.util.concurrent.*;

/**
 * Java并发编程：4种线程池和缓冲队列BlockingQueue
 * https://www.cnblogs.com/leeSmall/p/7636980.html
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
      //  BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

        //ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 100, TimeUnit.MILLISECONDS, queue);

        //创建3个线程任务
        for (int i = 0; i <100; i++) {
            ThreadDemo thread = new ThreadDemo("thread "+i);
            executor.execute(thread);

        }
        // 关闭自定义线程池
        executor.shutdown();
    }


}

class ThreadDemo implements Runnable {
    private String threadName;

    public ThreadDemo() {
    }

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(threadName + " run thread!");
        }
    }
}
