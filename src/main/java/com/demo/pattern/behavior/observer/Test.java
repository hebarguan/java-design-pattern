package com.demo.pattern.behavior.observer;

/**
 * @author huaihai.guan
 * @since 2021/1/27 11:01
 */
public class Test {

    public static void main(String[] args) {
        Publisher publisher = new TVPublisher();

        Listener listener1 = new TV105Listener("小关");
        Listener listener2 = new TV106Listener("小张");
        Listener listener3 = new TV106Listener("小李");

        publisher.addListener(listener1);
        publisher.addListener(listener2);
        publisher.addListener(listener3);

        TV105Event tv105Event = new TV105Event();
        SpiderManShow spiderManShow = new SpiderManShow();
        spiderManShow.setName("蜘蛛侠");
        spiderManShow.setTime("晚上八点");
        tv105Event.addSource(spiderManShow);

        publisher.publishEvent(tv105Event);

        TV106Event tv106Event = new TV106Event();
        IronManShow ironManShow = new IronManShow();
        ironManShow.setName("钢铁侠");
        ironManShow.setTime("晚上八点半");
        tv106Event.addSource(ironManShow);

        publisher.publishEvent(tv106Event);
    }
}
