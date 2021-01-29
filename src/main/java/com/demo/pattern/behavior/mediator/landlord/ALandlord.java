package com.demo.pattern.behavior.mediator.landlord;

import com.demo.pattern.behavior.mediator.Landlord;

/**
 * @author huaihai.guan
 * @since 2021/1/21 17:58
 */
public class ALandlord extends Landlord {

    @Override
    public void supply() {
        System.out.println(this.getClass().getName());
    }
}
