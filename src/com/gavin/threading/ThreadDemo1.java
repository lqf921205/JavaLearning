package com.gavin.threading;

public class ThreadDemo1 extends Thread{


    @Override
    public void run() {
        super.run();
        for (int i = 0; i <100 ; i++) {
            System.out.println("run thread!");
        }

    }

    public static void main(String[] args) {
       Thread thread=new ThreadDemo1();
       thread.run();
    }
}
