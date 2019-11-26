package com.hzh.jdbcTemplate;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Add {
	
	@Test
	public void add(){
		//1.设置数据库信息
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
		dataSource.setUsername("root");
		dataSource.setPassword("123654");
		//2.创建JdbcTemplate对象
		JdbcTemplate  template=new JdbcTemplate(dataSource);
		String sql="insert into idol values(?,?)";
		//2.1使用JdbcTemplate内置方法
		int update = template.update(sql, "林宥嘉","背影");
		System.out.println(update);
	}
	@Test
	public void update(){
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
		dataSource.setUsername("root");
		dataSource.setPassword("123654");
		JdbcTemplate template=new JdbcTemplate(dataSource);
		String sql="update idol set production=? where name=?";
		int update = template.update(sql, "说谎","林宥嘉");
		System.out.println(update);
		
	}
	@Test
	public void datele(){
		DriverManagerDataSource date=new DriverManagerDataSource();
		DriverManagerDataSource  dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
		dataSource.setUsername("root");
		dataSource.setPassword("123654");
		JdbcTemplate template=new JdbcTemplate(dataSource);
		String sql="delete from idol where name = ?";
		int update = template.update(sql, "林宥嘉");
		System.out.println(update);
	}
	@Test
	public void testcount(){
		DriverManagerDataSource  date=new DriverManagerDataSource();
		date.setDriverClassName("com.mysql.jdbc.Driver");
		date.setUrl("jdbc:mysql://localhost:3306/mybatis");
		date.setUsername("root");
		date.setPassword("123654");
		
		JdbcTemplate temp=new JdbcTemplate(date);
		String sql="SELECT COUNT(*) FROM idol";
		//query 查询  queryForObject（'sql语句'，返回类型的class） 为最高查询  
		Integer i = temp.queryForObject(sql, Integer.class);
		System.out.println(i);
	}
	//jdbc版
	@Test
	public void select() throws SQLException{
		Connection c=null;
		//已预编译过 可以多次执行
		java.sql.PreparedStatement ment=null;
		ResultSet su=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//配置信息
			c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123654");
			String sql="select * from idol where name=?";
			//预编译声明
			ment= c.prepareStatement(sql);
		    ment.setString(1, "林宥嘉");
		   su= ment.executeQuery();
		   while (su.next()) {
			   String name = su.getString("name");
			   String production =  su.getString("production");
			   User u=new User();
			   u.setName(name);
			   u.setProduction(production);
			   System.out.println(u);
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ment.close();
		}
		
	}
	@Test
	//spring JdbcTemplate返回对象
	public void selectob(){
		DriverManagerDataSource  date=new DriverManagerDataSource();
		date.setDriverClassName("com.mysql.jdbc.Driver");
		date.setUrl("jdbc:mysql://localhost:3306/mybatis");
		date.setUsername("root");
		date.setPassword("123654");
		
		JdbcTemplate temp=new JdbcTemplate(date);
		String sql="select * from idol where name=?";
		//queryForObject返回单个对象
	    User user = temp.queryForObject(sql, new myrowMapper(), "林宥嘉");
	    System.out.println(user);
	}
	@Test
	public void selectlist(){
		//ComboPooledDataSource c3p0连接池
	/*	ComboPooledDataSource cc=new ComboPooledDataSource();
		cc.setDriverClass("");
		cc.setJdbcUrl("");
		cc.setUser("");
		cc.setPassword("");*/
		
		
		
		DriverManagerDataSource  date=new DriverManagerDataSource();
		date.setDriverClassName("com.mysql.jdbc.Driver");
		date.setUrl("jdbc:mysql://localhost:3306/mybatis");
		date.setUsername("root");
		date.setPassword("123654");
		JdbcTemplate temp=new JdbcTemplate(date);
		String sql="select * from idol";
		//query返回list集合 new myrowMapper()需要手动写RowMapper的实现类
		List<User> query = temp.query(sql, new myrowMapper());
		System.out.println(query);
		
	}
	
}
class myrowMapper implements RowMapper<User>{
	@Override
	//ResultSet res结果集  int num返回结果集的行数
	public User mapRow(ResultSet res, int num) throws SQLException {
		String name = res.getString("name");
		String production = res.getString("production");      
		User u= new User();
		u.setName(name);
		u.setProduction(production);
		return u;
	}
	
}
