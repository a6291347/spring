package com.hzh.aopzhujie;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//aop注解在增强类上面进行操作 @Aspect开启aop注解
@Aspect
public class myBooK {
	//前置通知@Before
	@Before(value="execution(* com.hzh.aopzhujie.Book.*(..))")
	public void buy(){
		System.out.println("每当听见她和他说我们");
	}

}
