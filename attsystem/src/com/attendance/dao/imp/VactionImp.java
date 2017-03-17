package com.attendance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attendance.dao.IVaction;
import com.attendance.model.Vaction;
import com.attendance.utils.BaseDao;


@Repository
public class VactionImp extends BaseDao<Vaction> implements IVaction {

	@Override
	public void addVaction(Vaction user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVaction(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVaction(Vaction user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vaction searchVaction(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
