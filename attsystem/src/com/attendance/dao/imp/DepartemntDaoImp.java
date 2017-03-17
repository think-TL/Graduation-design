package com.attendance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attendance.controller.userManagerController;
import com.attendance.dao.IDepartment;
import com.attendance.model.Department;
import com.attendance.model.User;
import com.attendance.utils.BaseDao;

@Repository
public class DepartemntDaoImp extends BaseDao<Department> implements
		IDepartment {
	
	
	
	
	@Override
	public void addDepartment(Department depart) {
		String sql = "insert into department(d_name,d_fuZeRenId)values(?,?)";
		int i = this.updateCommon(sql,depart.getD_name(),depart.getD_fuZeRenId());
	}

	@Override
	public void deleteDepartment(int id) {
		String sql = "delete from department where d_id =?";
		super.updateCommon(sql, id);
	}

	@Override
	public void updateDepartment(Department depart) {
		String sql = "update department set d_name=?, d_fuZeRenId=? where d_id=?";
		super.updateCommon(sql,depart.getD_name(),depart.getD_fuZeRenId(),depart.getD_id());
	}

	public Department findDepartmentByName(String name) {
		String sql = "select d_id from department where d_name=?";
		return (Department) super.queryForJavaBean(sql, Department.class, name);
	}

	@Override
	public Department searchDepartment(int id) {
		String sql = "select d_id,d_name,d_fuZeRenId from department where d_id=?";
		return (Department) super.queryForJavaBean(sql, Department.class, id);
	}

	@Override
	public List<Department> findAll() {
		String sql = "select d_id,d_name,d_fuZeRenId from department";
		return super.queryForJavaBeanList(sql, Department.class);
	}

}
