package com.hzh.aopzhujie;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//aopע������ǿ��������в��� @Aspect����aopע��
@Aspect
public class myBooK {
	//ǰ��֪ͨ@Before
	@Before(value="execution(* com.hzh.aopzhujie.Book.*(..))")
	public void buy(){
		System.out.println("ÿ������������˵����");
	}

}
