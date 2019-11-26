package com.hzh.ioc;

public class bookser {
	private bookdao bookdao;

	public void setBookdao(bookdao bookdao) {
		this.bookdao = bookdao;
	}
	public void test(){
		System.out.println("≤‚ ‘°£°£°£");
		bookdao.test();
	}

}
