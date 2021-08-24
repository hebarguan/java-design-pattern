package com.demo.pattern.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

/**
 * @author huaihai.guan
 * @since 2021/8/18 14:36
 */
public class Test9 {

    private static Random random = new Random(0);

    public static void main(String[] args) {
        Double sum = 0d;
        Double[] a = new Double[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = (double) i;
            sum += a[i];
        }

        System.out.println("SUM " + sum);

        ForkJoinPool joinPool = ForkJoinPool.commonPool();
        try {
            joinPool.invoke(new JoinSum(a, 0, 100));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        joinPool.shutdown();

    }

    static class JoinSum extends RecursiveTask<Double> {

        private Double[] arr;
        private int offset;
        private int length;

        JoinSum(Double[] arr, int offset, int len) {
            this.arr = arr;
            this.offset = offset;
            this.length = len;
        }

        @Override
        protected Double compute() {
            if (arr.length <= length) {
                return Stream.of(arr).reduce(Double::sum).orElse(0d);
            }


            List<JoinSum> a = new ArrayList<>();

            for (int i = 0; i < 10; i++ ) {
                Double[] dest = new Double[100];
                System.arraycopy(arr, offset, dest, 0, 100);
                offset += length;
                a.add(new JoinSum(dest, offset, length));
            }

            invokeAll(a.toArray(new JoinSum[]{}));

            return a.stream().map(x -> {
                Double r = x.join();
                System.out.println(r);
                return r;
            }).reduce(Double::sum).orElse(0d);
        }

    }


}
