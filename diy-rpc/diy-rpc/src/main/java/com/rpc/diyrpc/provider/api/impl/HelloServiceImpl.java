package com.rpc.diyrpc.provider.api.impl;

import com.rpc.diyrpc.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

	@Override
	public void save() {
		System.out.println("save success!!");
	}

}
