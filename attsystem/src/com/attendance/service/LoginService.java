package com.attendance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.attendance.dao.IUserDao;
import com.attendance.model.User;

@Service
public class LoginService {

	@Resource
	private IUserDao userdao;

	/**
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户
	 */
	public User Login(int u_userid, String password) {
		User user = new User();
		user.setU_userid(u_userid);
		user.setU_password(password);
		User u = userdao.Login(u_userid);
		return u;
	}
}
