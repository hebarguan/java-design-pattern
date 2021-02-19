package com.demo.pattern.structure.decorator;

/**
 * @author huaihai.guan
 * @since 2021/2/19 19:54
 */
public abstract class Decorator extends BookRoom {

    private BookRoom bookRoom;

    public Decorator(BookRoom bookRoom) {
        this.bookRoom = bookRoom;
    }

    @Override
    void book() {
        this.bookRoom.book();
    }
}
