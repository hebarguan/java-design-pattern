package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:04
 */
public abstract class Phone {

    public String system;

    public Software software;

    public abstract void openSoftware();

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
