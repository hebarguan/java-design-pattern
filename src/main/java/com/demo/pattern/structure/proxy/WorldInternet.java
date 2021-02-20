package com.demo.pattern.structure.proxy;

/**
 * @author huaihai.guan
 * @since 2021/2/20 11:30
 */
public class WorldInternet implements Internet {

    @Override
    public void access(String domain) {

        System.out.println("访问域名" + domain + "的内容");
    }
}
