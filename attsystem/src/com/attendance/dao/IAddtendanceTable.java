package com.attendance.dao;

import java.util.List;

import com.attendance.model.AddtendanceTable;


public interface IAddtendanceTable {
	public void addAddtendanceTable(AddtendanceTable user);

	public void deleteAddtendanceTable(int id);

	public void updateAddtendanceTable(AddtendanceTable user);


	public AddtendanceTable searchAddtendanceTable(int id);

	public List<AddtendanceTable> findAll();
}
