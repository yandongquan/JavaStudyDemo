package com.javazk.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.javazk.api.IDemoApi;


@Service
public class DemoApiImpl implements IDemoApi {

	@Override
	public String demo(String param) {
		return "{\"Hello\":\""+param+"\"}" ;
	}

}

