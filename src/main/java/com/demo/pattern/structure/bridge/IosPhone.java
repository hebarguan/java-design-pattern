package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:20
 */
public class IosPhone extends Phone {

    public IosPhone(Software software) {
        this.setSoftware(software);
        this.setSystem("IOS系统");
    }

    @Override
    public void openSoftware() {
        this.getSoftware().open(this);
    }
}
