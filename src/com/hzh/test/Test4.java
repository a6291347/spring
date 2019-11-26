package com.hzh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzh.affair.iiservice;
import com.hzh.aopzhujie.Book;
import com.hzh.c3po.UserService;

public class Test4 {
	
	@Test
	public void test(){
		
		ApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
		Book bean = (Book) context.getBean("book");
		bean.add();
		
	}
	@Test
	public void test1(){
		ApplicationContext context=new ClassPathXmlApplicationContext("bean5c3p0.xml");
		UserService bean = (UserService) context.getBean("userservice");
		bean.xin();
		
	}
	@Test
	public void test2(){
		ApplicationContext context=new ClassPathXmlApplicationContext("bean6affair.xml");
		 iiservice bean = (iiservice) context.getBean("iiservice");
		 bean.automenoy();
	}
}
