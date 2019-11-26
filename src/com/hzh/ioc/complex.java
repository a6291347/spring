package com.hzh.ioc;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class complex {
	private Map<Integer,String> map;
	private String[] array;
	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	private List<String> list;
	
	public void test(){
		System.out.println("map-"+map);
		System.out.println("arry-"+array);
		System.out.println("list-"+list);
	}

}
