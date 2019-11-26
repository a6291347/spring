package com.hzh.c3po;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void shui(){
		System.out.println("还要多久才能进入你的心");
		String sql="INSERT INTO `idol` VALUES(?,?)";
		jdbcTemplate.update(sql, "郭顶","水星记");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
