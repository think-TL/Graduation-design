package com.attendance.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.attendance.dao.IUserDao;
import com.attendance.model.User;
import com.attendance.utils.BaseDao;
import com.attendance.utils.PageModel;

@Repository
public class UserDaoImp extends BaseDao<User> implements IUserDao {

	@Override
	public void addUser(User user) {
		String sql = "insert into user(u_name,u_password,u_sex,u_phone,u_address,u_job,u_email,u_QQ,u_quanxian,d_id)values(?,?,?,?,?,?,?,?,?,?)";
		int i = this.updateCommon(sql, user.getU_name(), user.getU_password(),
				user.getU_sex(), user.getU_phone(), user.getU_address(),
				user.getU_job(), user.getU_email(), user.getU_QQ(),
				user.getU_quanxian(), user.getD_id());
	}

	@Override
	public void deleteUser(int id) {
		String sql = "delete from user where u_id =?";
		super.updateCommon(sql, id);
	}

	@Override
	public void updateUser(User user) {
		String sql = "update user set u_phone=?, u_QQ=?,u_email=?,u_address=? where u_id=?";
		super.updateCommon(sql, user.getU_phone(), user.getU_QQ(),
				user.getU_email(), user.getU_address(), user.getU_id());
	}

	@Override
	public String searchUserName(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUser(int id) {
		String sql = "select u_id,u_name,u_password,u_sex,u_QQ,u_phone,u_address,u_job,u_email,u_quanxian,d_id from user where u_id = ?";
		return (User) super.queryForJavaBean(sql, User.class, id);
	}

	@Override
	public List<User> findAll() {
		String sql = "select u_id,u_name,u_password,u_QQ,u_sex,u_phone,u_address,u_job,u_email,u_quanxian,d_id from user";
		return super.queryForJavaBeanList(sql, User.class);
	}

	@Override
	public User Login(int u_userid) {
		String sql = "select u_userid,u_id,u_name,u_password,u_QQ,u_sex,u_phone,u_address,u_job,u_email,u_quanxian,d_id from user where u_userid = ?";
		return (User) super.queryForJavaBean(sql, User.class, u_userid);
	}
}
