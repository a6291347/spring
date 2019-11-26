package com.hzh.affair;

import org.springframework.jdbc.core.JdbcTemplate;

public class iiDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void lessmenoy(){
		String sql="UPDATE saray SET menoy=menoy-? WHERE name=?";
		jdbcTemplate.update(sql, "1000","ÀîÍñ");
		
	}
	public void moremenoy(){
		String sql="UPDATE saray SET menoy=menoy+? WHERE name=?";
		jdbcTemplate.update(sql, "1000","ÀîÏþÂ¶");
	}

}
