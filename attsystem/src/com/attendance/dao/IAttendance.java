package com.attendance.dao;

import java.util.List;

import com.attendance.model.Attendance;

public interface IAttendance {
	public void addAttendance(Attendance user);

	public void deleteAttendance(int id);


	public Attendance searchAttendance(int id);

	public List<Attendance> findAll();
}
