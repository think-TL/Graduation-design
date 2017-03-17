package com.attendance.dao;

import java.util.List;

import com.attendance.model.User;

public interface IUserDao {
	public void addUser(User user);

	public void deleteUser(int id);

	public void updateUser(User user);

	public String searchUserName(int id);

	public User searchUser(int id);

	public List<User> findAll();
	public User Login(int u_userid);
}
