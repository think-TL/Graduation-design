package com.attendance.dao;

import java.util.List;

import com.attendance.model.Vaction;

public interface IVaction {
	public void addVaction(Vaction user);

	public void deleteVaction(int id);

	public void updateVaction(Vaction user);

	public Vaction searchVaction(int id);

	public List<Vaction> findAll();
}
