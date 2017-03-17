package com.attendance.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.attendance.dao.imp.DepartemntDaoImp;
import com.attendance.model.Department;
import com.attendance.model.User;

@Service
public class DepartmentService {
	@Resource
	private DepartemntDaoImp departmentdao;
	
	public Department SearchDepartmentById(int id){
		Department department = departmentdao.searchDepartment(id);
		return department;
	}

	
	public int updateDepartMent(Department depart){
		departmentdao.updateDepartment(depart);
		return 0;
	}
	
	/**
	 * 添加用户
	 * @param depart
	 * @return
	 */
	public int AddDepartMent(Department depart){
		departmentdao.addDepartment(depart);
		return 0;
	}
	
	/**
	 * 删除
	 * @param did
	 * @return
	 */
	public int deldepartMent(int did){
		departmentdao.deleteDepartment(did);
		return 0;
	}
	/**
	 * 查找出所有的部门信息
	 * @param user
	 * @return
	 */
	public List<Department> query(){
		return departmentdao.findAll();
	}
	
	public Department SearchDepartmentByName(String name){
		Department department = departmentdao.findDepartmentByName(name);
		return department;
	}
}
