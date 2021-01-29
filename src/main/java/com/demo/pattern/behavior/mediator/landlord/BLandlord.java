package com.demo.pattern.behavior.mediator.landlord;

import com.demo.pattern.behavior.mediator.Landlord;

/**
 * @author huaihai.guan
 * @since 2021/1/21 17:59
 */
public class BLandlord extends Landlord {

    @Override
    public void supply() {
        System.out.println(this.getClass().getName());
    }
}
