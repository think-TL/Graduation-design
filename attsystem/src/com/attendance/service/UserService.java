package com.attendance.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.attendance.dao.imp.UserDaoImp;
import com.attendance.model.Department;
import com.attendance.model.User;
import com.attendance.utils.totype;

@Service
public class UserService {
	@Resource
	private UserDaoImp userDaoImp;
	@Resource
	private DepartmentService departService;

	public User updateUser(User user) {
		try {
			userDaoImp.updateUser(user);
			user = userDaoImp.searchUser(user.getU_id());
		} catch (Exception e) {
			return null;
		}
		return user;
	}

	public int delUser(int u_id) {
		userDaoImp.deleteUser(u_id);
		return 0;
	}

	
	public User findUserByName(int name){
		return userDaoImp.Login(name);
	}
	
	/**
	 * 保存用戶
	 * 
	 * @param map
	 */
	public void saveUser(Map<String, String> map) {
		User user = new User();
		String interim = null;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().indexOf("name") != -1) {
				user.setU_name(entry.getValue());
			}
			if (entry.getKey().indexOf("phone") != -1) {
				user.setU_phone(totype.toInt(entry.getValue()));
			}
			if (entry.getKey().indexOf("address") != -1) {
				user.setU_address(entry.getValue());
			}
			if (entry.getKey().indexOf("job") != -1) {
				user.setU_job(entry.getValue());
			}
			if (entry.getKey().indexOf("password") != -1) {
				user.setU_password(entry.getValue());
			}
			if (entry.getKey().indexOf("QQ") != -1) {
				user.setU_QQ(totype.toInt(entry.getValue()));
			}
			if (entry.getKey().indexOf("email") != -1) {
				user.setU_email(entry.getValue());
			}
			if (entry.getKey().indexOf("user_sex") != -1) {
				user.setU_sex(entry.getValue());
			}
			if (entry.getKey().indexOf("depart") != -1) {
				interim = entry.getValue();
			}
			if (entry.getKey().indexOf("quanxian") != -1) {
				user.setU_quanxian(totype.toInt(entry.getValue()));
			}
		}
		Department department = departService.SearchDepartmentByName(interim);
		user.setD_id(department.getD_id());
		userDaoImp.addUser(user);
	}

	public User firndUserById(int u_id) {
		User user = userDaoImp.searchUser(u_id);
		return user;
	}

	public List<User> selectUserAll() {
		return userDaoImp.findAll();
	}

}
