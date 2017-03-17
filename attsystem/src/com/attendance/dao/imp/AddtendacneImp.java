package com.attendance.dao.imp;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.attendance.dao.IAttendance;
import com.attendance.model.Attendance;
import com.attendance.utils.BaseDao;

@Repository
public class AddtendacneImp extends BaseDao<Attendance> implements IAttendance{

	
	@Override
	public void addAttendance(Attendance user) {
		
	}

	@Override
	public void deleteAttendance(int id) {
		
		
	}

	@Override
	public Attendance searchAttendance(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
