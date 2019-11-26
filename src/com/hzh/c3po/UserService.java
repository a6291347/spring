package com.hzh.c3po;

public class UserService {
	
	private UserDao user;

	public void setUser(UserDao user) {
		this.user = user;
	}
	
	public void xin(){
		System.out.println("咫尺靠近的那个人却无法拥有你");
		user.shui();
	}
	
	

}
