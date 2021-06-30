package com.demo.pattern.test;

import java.util.concurrent.TimeUnit;

/**
 * @author huaihai.guan
 * @since 2021/4/29 10:59
 */
public class VolatileTest {

    private static boolean a = false;

    private static VolatileTest volatileTest = null;

    public VolatileTest() {

        System.out.println("VolatileTest been Constructor " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TestC()).start();
        new Thread(new TestC()).start();
        new Thread(new TestC()).start();
        new Thread(new TestC()).start();
//        new Thread(new TestA()).start();
//        TimeUnit.SECONDS.sleep(1);
//        new Thread(new TestB()).start();
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
