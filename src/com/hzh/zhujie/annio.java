package com.hzh.zhujie;

import org.springframework.stereotype.Component;

@Component(value="annio")
public class annio {
	public void add(){
		System.out.println("这是ioc注解方式。。。。。");
	}
}
