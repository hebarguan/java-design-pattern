package com.demo.pattern.test;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huaihai.guan
 * @since 2021/6/23 16:30
 */
public class TestTemp3 {


    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors
                .newScheduledThreadPool(1);

        scheduler.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("Do something useful");
            }
        }, 0, 1, TimeUnit.SECONDS);

        ArrayList<String> a = new ArrayList<>();
        a.add("oh");
        a.add("op");

        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
        } catch (Throwable var1) {
            lock.unlock();
        }


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                4,
                3000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Map<String, CompletableFuture<String>> futureMap = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            CompletableFuture<String> futureTask = CompletableFuture.supplyAsync(TestTemp3::get, threadPoolExecutor);
            futureMap.put("t" + i, futureTask);
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureMap.values().toArray(new CompletableFuture[]{}));
        try {
            completableFuture.get(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        Map<String, String> result = new HashMap<>();
        futureMap.forEach((x, y) -> {
            try {
                result.put(x, y.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(result.get("t0"));

    }


    private static String get() {
        return "ok";
    }
}
