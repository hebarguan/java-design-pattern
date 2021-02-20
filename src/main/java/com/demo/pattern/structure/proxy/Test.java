package com.demo.pattern.structure.proxy;

/**
 * @author huaihai.guan
 * @since 2021/2/20 11:35
 */
public class Test {

    public static void main(String[] args) {
        WorldInternet worldInternet = new WorldInternet();

        ChinaInternet chinaInternet = new ChinaInternet(worldInternet);
        chinaInternet.access("www.google.com");
        chinaInternet.access("www.baidu.com");
    }
}
