package com.demo.pattern.structure.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huaihai.guan
 * @since 2021/2/20 11:32
 */
public class ChinaInternet implements Internet {

    private List<String> disabled = new ArrayList<>();

    private WorldInternet worldInternet;

    public ChinaInternet(WorldInternet worldInternet) {
        this.disabled.add("www.google.com");
        this.disabled.add("www.facebook.com");
        this.worldInternet = worldInternet;
    }

    @Override
    public void access(String domain) {
        if (this.disabled.contains(domain)) {

            System.out.println("禁止访问" + domain);
        } else {
            this.worldInternet.access(domain);
        }
    }
}
