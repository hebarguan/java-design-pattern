package com.demo.pattern.test;

import java.nio.charset.StandardCharsets;

/**
 * @author huaihai.guan
 * @since 2021/2/1 17:06
 */
public class TestTemp1 {

    public static void main(String[] args) {

        // 简体字“国“在utf-8编码中为啥占3个字节呢？
        byte[] bytes = "国".getBytes(StandardCharsets.UTF_8);
        System.out.println(Integer.toHexString(22269));
        // 首先国字在字符集unicode中的编号为U+56FD，java可用\u56fd表示，十进制为22269 二进制表示为 1010110 11111101
        /*
         * UTF-8 的编码规则
         * 下图展示了不同字节下的编码，x表示payload,用来存放上面的二进制用的
         *  1字节 0xxxxxxx
         *  2字节 110xxxxx 10xxxxxx
         *  3字节 1110xxxx 10xxxxxx 10xxxxxx
         *  4字节 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
         *  5字节 111110xx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
         *  6字节 1111110x 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
         */
        // 国字二进制有15位，根據UTF-8的編碼規則可以推断出必须要用3個字節（有16个payload可存16位数）才能存下囯字的二进制数
        // 用国字的二进制从低位到高位填补1110xxxx 10xxxxxx 10xxxxxx中的x，可推断出国字在UTF-8中的二进制编码为: 11100101 10011011 10111101（没有填满的用0补足）

        // 下面验证上面的推断结果
        for (byte b : bytes) {
            // 先打印每个字节的整数值 第一个字节 11100101 最高位为1表示负数，整数计算（取反+1）为00011011 结果为27 所以下面打印结果为-27
            System.out.println(b);
            // 转换为Integer二进制（即字节b由8位转换为32位）根据java的补位规则负数补位1，正数补位0 所以下面打印结果为 11111111 11111111 11111111 11100101
            System.out.println(Integer.toBinaryString(b));
            // 最后只需要保留底8位就可以得出结果
            // 0xff表十六进制，二进制为00000000 00000000 00000000 11111111 根据与操作（0&1>0）得到 00000000 00000000 00000000 11100101
            System.out.println(Integer.toBinaryString(b & 0xff));
            // 打印出 11100101 和国字的UTF-8二进制编码的第一个字节的推断结果相同!

            System.out.println(" ");
        }
    }
}
