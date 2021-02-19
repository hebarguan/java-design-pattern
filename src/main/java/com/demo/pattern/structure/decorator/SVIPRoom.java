package com.demo.pattern.structure.decorator;

/**
 * @author huaihai.guan
 * @since 2021/2/19 19:58
 */
public class SVIPRoom extends Decorator {

    public SVIPRoom(BookRoom bookRoom) {
        super(bookRoom);
    }

    @Override
    public void book() {
        super.book();
        System.out.println("送按摩+99元");
    }
}
