package com.demo.pattern.structure.decorator;

/**
 * 提供一个装饰类去装载基本类,并扩展新功能
 * @author huaihai.guan
 * @since 2021/2/19 20:01
 */
public class Test {

    public static void main(String[] args) {
        BaseRoom baseRoom = new BaseRoom();

        VIPRoom vipRoom = new VIPRoom(baseRoom);
        vipRoom.book();

        SVIPRoom svipRoom = new SVIPRoom(vipRoom);
        svipRoom.book();
    }
}
