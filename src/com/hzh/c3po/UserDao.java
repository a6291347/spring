package com.hzh.c3po;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void shui(){
		System.out.println("��Ҫ��ò��ܽ��������");
		String sql="INSERT INTO `idol` VALUES(?,?)";
		jdbcTemplate.update(sql, "����","ˮ�Ǽ�");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
