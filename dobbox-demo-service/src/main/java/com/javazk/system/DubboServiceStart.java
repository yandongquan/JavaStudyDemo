package com.javazk.system;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 *  启动发布Dubbo 服务
 */
public class DubboServiceStart {
	private static final Logger LOG = LogManager
			.getLogger(DubboServiceStart.class.getName());
	private static void startDubboService() {
		LOG.info("开始启动  Dubbo 服务---------------------------");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:spring/applicationContext.xml" });
		context.start();
		LOG.info(" Dubbo 服务启动完毕---------------------------");
		try {
			System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {
		startDubboService();
	}
}
