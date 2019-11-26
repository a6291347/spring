package com.hzh.zhujie;

import javax.annotation.Resource;

public class bookser {
	
	@Resource(name="bookdaoi")
	private bookdaoi daoi;
	@Resource(name="bookdaor")
	private bookdaor daor;
	
	public void add(){
		System.out.println("bookser..............");
		daoi.in();
		daor.buy();
	}

}
