package com.demo.pattern.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author huaihai.guan
 * @since 2021/8/13 12:29
 */
public class Test8 {

    public static int inc = 0;

    public static void main(String[] args) {

        //新建一个线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //Java8 lambda表达式执行runnable接口
        service.execute(() -> {
            while (inc <= 0) {
            }
            System.out.println(inc);
        });
        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                inc++;
            });
        }
        //关闭线程池
        service.shutdown();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("inc = " + inc);
    }
}
