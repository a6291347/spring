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
		//1.�������ݿ���Ϣ
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
		dataSource.setUsername("root");
		dataSource.setPassword("123654");
		//2.����JdbcTemplate����
		JdbcTemplate  template=new JdbcTemplate(dataSource);
		String sql="insert into idol values(?,?)";
		//2.1ʹ��JdbcTemplate���÷���
		int update = template.update(sql, "��嶼�","��Ӱ");
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
		int update = template.update(sql, "˵��","��嶼�");
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
		int update = template.update(sql, "��嶼�");
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
		//query ��ѯ  queryForObject��'sql���'���������͵�class�� Ϊ��߲�ѯ  
		Integer i = temp.queryForObject(sql, Integer.class);
		System.out.println(i);
	}
	//jdbc��
	@Test
	public void select() throws SQLException{
		Connection c=null;
		//��Ԥ����� ���Զ��ִ��
		java.sql.PreparedStatement ment=null;
		ResultSet su=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//������Ϣ
			c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123654");
			String sql="select * from idol where name=?";
			//Ԥ��������
			ment= c.prepareStatement(sql);
		    ment.setString(1, "��嶼�");
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
	//spring JdbcTemplate���ض���
	public void selectob(){
		DriverManagerDataSource  date=new DriverManagerDataSource();
		date.setDriverClassName("com.mysql.jdbc.Driver");
		date.setUrl("jdbc:mysql://localhost:3306/mybatis");
		date.setUsername("root");
		date.setPassword("123654");
		
		JdbcTemplate temp=new JdbcTemplate(date);
		String sql="select * from idol where name=?";
		//queryForObject���ص�������
	    User user = temp.queryForObject(sql, new myrowMapper(), "��嶼�");
	    System.out.println(user);
	}
	@Test
	public void selectlist(){
		//ComboPooledDataSource c3p0���ӳ�
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
		//query����list���� new myrowMapper()��Ҫ�ֶ�дRowMapper��ʵ����
		List<User> query = temp.query(sql, new myrowMapper());
		System.out.println(query);
		
	}
	
}
class myrowMapper implements RowMapper<User>{
	@Override
	//ResultSet res�����  int num���ؽ����������
	public User mapRow(ResultSet res, int num) throws SQLException {
		String name = res.getString("name");
		String production = res.getString("production");      
		User u= new User();
		u.setName(name);
		u.setProduction(production);
		return u;
	}
	
}
