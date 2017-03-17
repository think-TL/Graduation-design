package com.attendance.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.attendance.dao.imp.UserDaoImp;


public class JdbcTemplateTest {
    
	
	private static JdbcTemplate jdbcTemplate;

	@Test
	public void setUpClass() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sysdb?useUnicode=true&characterEncoding=gbk");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "create table ss(s_id int primary key,s_name varchar(60));";
		jdbcTemplate.execute(sql);
	}
	@Test
	public void insertClass(){
		//UserDaoImp s = new UserDaoImp();
		//s.Login("tl");
	}
}
