package com.hzh.affair;

import org.springframework.transaction.annotation.Transactional;

//�ֲ�˼�� service ҵ������������дҵ���߼�����
//dao���ݲ� һ�������������ݿ�
//Transactional������
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
