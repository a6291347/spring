package com.hzh.c3po;

public class UserService {
	
	private UserDao user;

	public void setUser(UserDao user) {
		this.user = user;
	}
	
	public void xin(){
		System.out.println("��߿������Ǹ���ȴ�޷�ӵ����");
		user.shui();
	}
	
	

}
