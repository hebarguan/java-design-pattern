package com.demo.pattern.test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author huaihai.guan
 * @since 2021/7/6 11:28
 */
public class Test5 {

    public static void main(String[] args) {

        int a = 13;
//        System.out.println(a >> 1);
//        System.out.println(a << 1);
//        System.out.println(a >> 2);
//        System.out.println(a << 2);


        Integer partitions = 492;
        Integer w = 5;
        int y = partitions % w;

        System.out.println(y);
        int p = (partitions - y) / w;
        System.out.println(p);

        for (int i = 1; i <= w; i++) {
            int ep = p * i;
            int sp = p * (i - 1);
            if (i == w) ep = ep + y;

            System.out.println(sp + "-" + ep);
        }


        DelayQueue<DelayedTask> dq = new DelayQueue<>();
        dq.add(new DelayedTask(6L, TimeUnit.SECONDS, new MyTaskCallBack()));
        dq.add(new DelayedTask(9L, TimeUnit.SECONDS, new MyTaskCallBack()));
        dq.add(new DelayedTask(3L, TimeUnit.SECONDS, x -> {
            System.out.println("在" + x + "秒后调用成功");
            return null;
        }));
        while (true) {
            try {
                DelayedTask delayedTask = dq.take();
                System.out.println(delayedTask.getCallBack().call(delayedTask.getTime()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    interface ICallBack<K, T> {
        T call(K arg);
    }

    static class MyTaskCallBack implements ICallBack<Long, String> {

        @Override
        public String call(Long arg) {
            return " OO--" + arg;
        }
    }

    static class DelayedTask implements Delayed {

        private Long time;

        private Long availableTime;

        private ICallBack callBack;

        DelayedTask(Long time, TimeUnit timeUnit, ICallBack callBack) {
            this.time = time;
            this.callBack = callBack;
            this.availableTime = TimeUnit.MILLISECONDS.convert(time, timeUnit) + System.currentTimeMillis();
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public Long getAvailableTime() {
            return availableTime;
        }

        public void setAvailableTime(Long availableTime) {
            this.availableTime = availableTime;
        }

        public ICallBack getCallBack() {
            return callBack;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long fromNow = this.availableTime - System.currentTimeMillis();
            return unit.convert(fromNow, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return this.availableTime.compareTo(((DelayedTask) o).getAvailableTime());
        }
    }
}
