package com.demo.pattern.structure.decorator;

/**
 * @author huaihai.guan
 * @since 2021/2/19 19:56
 */
public class VIPRoom extends Decorator {

    public VIPRoom(BookRoom bookRoom) {
        super(bookRoom);
    }

    @Override
    public void book() {
        super.book();
        System.out.println("送早餐+29元");
    }
}
