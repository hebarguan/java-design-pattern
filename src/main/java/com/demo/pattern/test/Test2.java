package com.demo.pattern.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author huaihai.guan
 * @since 2021/3/29 15:03
 */
public class Test2 {

    private static Test2 testTemp2 = new Test2();

    public static void main(String[] args) {
        ArrayList<String> g = new ArrayList<>();
        g.add("name");
        String a = "name";
        String b = "name";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        int h;

        for (int i = 0; i < 16; i++) {
            a = UUID.randomUUID().toString().replace("-", "");
            System.out.println(a.hashCode());
            System.out.println(((h = a.hashCode()) ^ (h >>> 16)) & 15);
        }
    }

    public static String printBinary(int intVal) {
        return printBinary(Integer.toBinaryString(intVal), 4, " ");
    }

    public static String printBinary(String binary, int blockSize, String separator) {

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < (32 - binary.length()); i++) {
            tmp.append("0");
        }
        binary = tmp.toString() + binary;

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }

}
