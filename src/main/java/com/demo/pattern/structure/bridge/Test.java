package com.demo.pattern.structure.bridge;

/**
 * @author huaihai.guan
 * @since 2021/2/8 18:24
 */
public class Test {

    public static void main(String[] args) {
        Firefox firefox = new Firefox();
        Chrome chrome = new Chrome();
        AndroidPhone androidPhone = new AndroidPhone(firefox);
        androidPhone.openSoftware();
        androidPhone.setSoftware(chrome);
        androidPhone.openSoftware();


        IosPhone iosPhone = new IosPhone(firefox);
        iosPhone.openSoftware();
        iosPhone.setSoftware(chrome);
        iosPhone.openSoftware();

    }
}
