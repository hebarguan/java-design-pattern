package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:17
 */
public class AndroidPhone extends Phone {

    public AndroidPhone(Software software) {
        this.setSoftware(software);
        this.setSystem("安卓系统");
    }

    @Override
    public void openSoftware() {
        this.software.open(this);
    }
}
