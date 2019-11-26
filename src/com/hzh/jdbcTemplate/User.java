package com.hzh.jdbcTemplate;

public class User {
	
	private String name;
	private String production;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduction() {
		return production;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", production=" + production + "]";
	}
	public void setProduction(String production) {
		this.production = production;
	}

}
