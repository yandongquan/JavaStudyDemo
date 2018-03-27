package com.javazhan.utils;


import java.util.UUID;

public class UUIDUtil {

    public static String genId32() {
        return UUID.randomUUID().toString();
    }

    public static String genIdToUpperCase() {
        return UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
    }

    public static int genShortId() {
        return Math.abs(genId32().hashCode());
    }

    public static void main(String[] args) {
        System.out.println(genId32());
        System.out.println(genIdToUpperCase());
        System.out.println(genShortId());
    }
}