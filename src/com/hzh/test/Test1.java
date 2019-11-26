package com.hzh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzh.ioc.Ptest;
import com.hzh.ioc.Test;
import com.hzh.ioc.User;
import com.hzh.ioc.bookser;
import com.hzh.ioc.complex;

public class Test1 {
	public static void main(String[] args) {
		//加载spring配置文件  得到ioc容器对象
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		
		/*//得到配置的对象
		User bean = (User)context.getBean("user");
		System.out.println(bean);
		bean.add();*/
		/*Test bean = (Test) context.getBean("dome");
		bean.test();*/
	/*	bookser bean = (bookser) context.getBean("ser");
		bean.test();*/
		complex bean = (complex) context.getBean("compex");
		bean.test();
		
	}
	
}
