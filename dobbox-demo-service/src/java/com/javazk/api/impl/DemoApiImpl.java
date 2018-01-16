package com.javazk.api.impl;

import com.javazk.api.DemoApi;

public class DemoApiImpl implements DemoApi {

    @Override
    public String Demo(String phone) {
        return phone;
    }
}
