package com.hzh.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class bookdao {
	public void add(){
		System.out.println("ǰ��֪ͨ..............");
	}
	//����֪ͨ
	//����Ŀ�귽��ִ��
	public void  buy(ProceedingJoinPoint a) throws Throwable{
		//����ǰ
		System.out.println("�׺�����������");
		//����ǿ�ķ���
		a.proceed();//proceed����������������Ŀ�귽��ִ�е�
		//������
		System.out.println("������ů������");
	}

}
