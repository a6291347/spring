package com.hzh.zhujie;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="ser")
public class annser {
	//属性注入不需要手动创建按set
	//使用注解方式 1.@Autowired 自动装配   2.@Resource(name=)指定注入类
	@Resource(name="dao")
	private anndao dao;
	
	public void add(){

		 System.out.println("ser...............");
		 dao.add();
		
	}

}
