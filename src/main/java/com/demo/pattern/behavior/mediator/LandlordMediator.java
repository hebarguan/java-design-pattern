package com.demo.pattern.behavior.mediator;

import com.demo.pattern.behavior.mediator.landlord.ALandlord;
import com.demo.pattern.behavior.mediator.landlord.BLandlord;

/**
 * 中介模式
 * @author huaihai.guan
 * @since 2021/1/21 18:01
 */
public class LandlordMediator {

    private String user;

    private ALandlord aLandlord = new ALandlord();

    private BLandlord bLandlord = new BLandlord();

    LandlordMediator(String user) {
        this.user = user;
    }

    public void lookHouse() {
        System.out.println(this.user + " ALandlord");
        aLandlord.supply();
        System.out.println(this.user + " BLandlord");
        bLandlord.supply();
    }
}
