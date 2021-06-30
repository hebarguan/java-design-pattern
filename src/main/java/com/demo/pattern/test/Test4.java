package com.demo.pattern.test;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huaihai.guan
 * @since 2021/6/29 10:22
 */
public class Test4 {


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Student> a = new ArrayList<>();
        HashMap<String, String> b = new HashMap<>();
        HashSet<String> d = new HashSet<>();
        LinkedBlockingQueue<String> c = new LinkedBlockingQueue<>();

        ReentrantLock reentrantLock = new ReentrantLock();
        if (reentrantLock.tryLock(2, TimeUnit.SECONDS)) {
            // do something
        }
        reentrantLock.unlock();

        a.add(new Student("2", 3));
        a.add(new Student("1", 2));
        a.add(new Student("3", 9));
        a.add(new Student("3", 10));
        a.add(new Student("4", 4));
        Collections.sort(a);
        a.forEach(x ->
        System.out.println(x.getId()+ ":" + x.getScore()));

        Map<String, List<Student>> h = a.stream().collect(Collectors.groupingBy(Student::getId));
        h.values().stream().map(x -> new CountStudent(x.get(0).getId(), x.size())).sorted(Comparator.comparing(CountStudent::getTimes).reversed()).forEach(x -> {

            System.out.println(x.getId() + " - " + x.getTimes());
        });
        a.stream().sorted(Comparator.comparing(Student::getScore).reversed()).forEach(y -> {
            System.out.println(y.getId());
        });

        System.out.println(h);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        int page = 0;
        for (Student x : a) {
            page++;
            if (page%2 == 0) {
                List<Student> t = a.subList(page - 2, page);
                CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    MainWorker mainWorker = new MainWorker();
                    return mainWorker.work(t);
                }, executor);
                futures.add(future);
            }
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}));
        try {
            completableFuture.get(2, TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        futures.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    interface IWorker<T, K> {
        T work(List<K> a);
    }

    static class MainWorker implements IWorker<Integer, Student> {

        @Override
        public Integer work(List<Student> a) {
            AtomicReference<Integer> r = new AtomicReference<>(0);
            a.forEach(x -> {
                r.set(r.get() + x.getScore());
            });
            return r.get();
        }
    }


    static  class CountStudent {
        String id;
        Integer times;

        CountStudent(String id, Integer times) {
            this.id = id;
            this.times = times;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getTimes() {
            return times;
        }

        public void setTimes(Integer times) {
            this.times = times;
        }
    }

    static class Student implements Comparable<Student> {

        String id;

        Integer score;

        Student(String id, Integer score) {
            this.id = id;
            this.score = score;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.getScore().compareTo(this.getScore());
        }
    }
}
