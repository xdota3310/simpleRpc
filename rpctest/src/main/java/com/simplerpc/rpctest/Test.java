package com.simplerpc.rpctest;

import java.io.File;

/**
 * @author xu.shijie
 * @since 2020/9/20
 */
public class Test {
    public static void main(String[] args) {
        File file = new File("env");
        System.out.println(file.exists());
    }
}
