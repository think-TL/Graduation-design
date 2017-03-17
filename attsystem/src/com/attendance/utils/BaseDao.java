package com.attendance.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import com.attendance.utils.PageModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class BaseDao<T> {
	@Resource
	private NamedParameterJdbcTemplate namedTemplate;

	public String PAGE_SQL_PRE = "select * from (select rownum num,m.* from(";

	public String PAGE_SQL_END = ") m where rownum<=?) where num>?";

	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int queryForInt(String sql, Object... params) {
		int i = namedTemplate.getJdbcOperations().queryForObject(sql,
				Integer.class, params);
		return i;
	}

	/**
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int updateCommon(String sql, T obj) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);
		int i = namedTemplate.update(sql, paramSource);
		return i;
	}

	public int updateCommon(String sql, Object... params) {
		int i = namedTemplate.getJdbcOperations().update(sql, params);
		return i;
	}

	public Object queryForJavaBean(String sql, Class javaBeanClass,
			Object... params) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(javaBeanClass);
		try {
			T obj = namedTemplate.getJdbcOperations().queryForObject(sql,
					rowMapper, params);
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public List<T> queryForJavaBeanList(String sql, Class javaBeanClass,
			Object... params) {
		List<T> list = new ArrayList();
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(javaBeanClass);
		System.out.println(rowMapper);
		list = namedTemplate.getJdbcOperations().query(sql, rowMapper, params);
		System.out.println(list);
		return list;
	}
}
