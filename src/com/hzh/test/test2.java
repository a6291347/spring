package com.hzh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzh.zhujie.annio;
import com.hzh.zhujie.annser;
import com.hzh.zhujie.bookser;

public class test2 {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
	bookser bean = (bookser) context.getBean("bookser");
	bean.add();
	System.out.println(bean);
}
}
