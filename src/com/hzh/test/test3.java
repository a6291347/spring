package com.hzh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzh.aop.booser;

public class test3 {
	
	@Test
	public void buy(){
		ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
		booser bean = (booser) context.getBean("ser");
		bean.add();
		System.out.println(bean);
	}

}
