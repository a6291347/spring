package com.hzh.zhujie;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ser")
public class annser {
	//����ע�벻��Ҫ�ֶ�������set
	//ʹ��ע�ⷽʽ 1.@Autowired �Զ�װ��   2.@Resource(name=)ָ��ע����
	@Resource(name="dao")
	private anndao dao;
	
	public void add(){

		 System.out.println("ser...............");
		 dao.add();
		
	}

}
