package com.javazk.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.javazk.api.IDemoApi;


@org.springframework.stereotype.Service("demoApi")
@Service(interfaceClass=com.javazk.api.IDemoApi.class, protocol = {"rest"}, retries = 0)
public class DemoApiImpl implements IDemoApi {

	@Override
	public String demo(String param) {
		return "{\"Hello\":\""+param+"\"}" ;
	}

}

