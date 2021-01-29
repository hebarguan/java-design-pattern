package com.demo.pattern.behavior.template;

/**
 * @author huaihai.guan
 * @since 2021/1/22 19:56
 */
public abstract class ShoeInstallTemplate {

    public abstract void installSole();

    public abstract void installInsole();

    public abstract void installVamp();

    public abstract void installShoelace();

    public void installShot() {
        installShoelace();
        installInsole();
        installSole();
        installVamp();
    }

}
