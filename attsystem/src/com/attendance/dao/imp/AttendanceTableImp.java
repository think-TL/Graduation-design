package com.attendance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attendance.dao.IAddtendanceTable;
import com.attendance.model.AddtendanceTable;
import com.attendance.utils.BaseDao;

@Repository
public class AttendanceTableImp extends BaseDao<AddtendanceTable> implements IAddtendanceTable {

	@Override
	public void addAddtendanceTable(AddtendanceTable user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddtendanceTable(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddtendanceTable(AddtendanceTable user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AddtendanceTable searchAddtendanceTable(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddtendanceTable> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
