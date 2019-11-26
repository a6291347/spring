package com.hzh.affair;

import org.springframework.transaction.annotation.Transactional;

//分层思想 service 业务层多数用来编写业务逻辑操作
//dao数据层 一般用来操作数据库
//Transactional事务处理
@Transactional
public class iiservice {
	private iiDao dao;
	public void setDao(iiDao dao) {
		this.dao = dao;
	}
	public void automenoy(){
		dao.lessmenoy();
		//int i=10/0;
		dao.moremenoy();
		
	}

}
