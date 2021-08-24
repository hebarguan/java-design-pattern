package com.demo.pattern.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author huaihai.guan
 * @since 2021/4/29 10:59
 */
public class VolatileTest {

    private static boolean a = false;

    private static VolatileTest volatileTest = null;

    private static boolean check = true;

    public VolatileTest() {

        System.out.println("VolatileTest been Constructor " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new TestC());
        Thread thread2 = new Thread(new TestC());
        Thread thread3 = new Thread(() -> {
            while (check);
            System.out.println("ooooooo");
        });
        Thread thread4 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);

                System.out.println("start set check = false");
                check = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        thread3.start();
        thread4.start();

        System.out.println("END");
    }


    private static VolatileTest getInstance() {

        System.out.println(Thread.currentThread().getName() + " before locked " + volatileTest);
        if (volatileTest == null) {
            synchronized (VolatileTest.class) {
                System.out.println(Thread.currentThread().getName() + " after locked " + volatileTest);
                if (volatileTest == null) {
                    volatileTest = new VolatileTest();
                }
            }
        }
        return volatileTest;
    }

    public void echo() {

        System.out.println(Thread.currentThread().getName() + "-OK");
    }

    public static class TestC implements Runnable {

        @Override
        public void run() {
            VolatileTest volatileTest = getInstance();
            volatileTest.echo();
        }
    }

    public static class TestA implements Runnable {
        @Override
        public void run() {
            int b = 1;
            while (!a) {
                b++;
            }
            System.out.println("From A b = " + b);
        }
    }

    public static class TestB implements Runnable {
        @Override
        public void run() {
            a = true;
        }
    }
}
