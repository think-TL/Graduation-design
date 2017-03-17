package com.attendance.dao;

import java.util.List;

import com.attendance.model.Department;



public interface IDepartment {
	public void addDepartment(Department user);

	public void deleteDepartment(int id);

	public void updateDepartment(Department user);


	public Department searchDepartment(int id);

	public List<Department> findAll();
}
