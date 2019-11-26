package com.hzh.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class bookdao {
	public void add(){
		System.out.println("前置通知..............");
	}
	//环绕通知
	//是让目标方法执行
	public void  buy(ProceedingJoinPoint a) throws Throwable{
		//方法前
		System.out.println("沧海明珠月有泪");
		//被增强的方法
		a.proceed();//proceed方法就是用于启动目标方法执行的
		//方法后
		System.out.println("蓝田玉暖日生烟");
	}

}
