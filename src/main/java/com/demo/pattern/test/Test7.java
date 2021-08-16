package com.demo.pattern.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author huaihai.guan
 * @since 2021/8/10 15:27
 */
public class Test7 {

    private static Map<String, Thread> threadMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
//        Thread p = new IThread();
//        p.setDaemon(true);
//        p.start();
//        Thread.sleep(2000);

//        threadMap.put("a", new IThread());
//        threadMap.put("b", new IThread());
//        threadMap.put("c", new IThread());
//        threadMap.forEach((k, v) -> {
//            v.start();
//            v.interrupt();
//        });
        new Thread(My::lock).start();
        new Thread(My::lock2).start();
    }

    static class My {
        private static int a = 0;
        private Object o = new Object();
        public synchronized static void lock() {
            if (a == 0) {
                while (true) ;
            }
            System.out.println("lock" + a);
        }

        public synchronized static void lock2() {
            a++;
            System.out.println("lock2" + a);
        }
    }

    static class IThread extends Thread {
        @Override
        public void run() {
            int sum = 0;
            for (long i = 0; i < 100; i++) {
                System.out.println(sum);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
                sum++;
            }
        }


    }

}
