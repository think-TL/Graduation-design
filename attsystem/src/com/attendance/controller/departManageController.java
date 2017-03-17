package com.attendance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.attendance.model.Department;
import com.attendance.model.User;
import com.attendance.service.DepartmentService;
import com.attendance.service.UserService;
import com.attendance.utils.totype;

@Controller
@RequestMapping("/depart")
public class departManageController {

	@Resource
	private UserService userService;
	@Resource
	private DepartmentService departService;

	@RequestMapping("/delDepartment")
	public ModelAndView departdDel(HttpServletRequest request,
			HttpServletResponse response) {
		String uid = request.getParameter("did");
		System.out.println(uid);
		departService.deldepartMent(totype.toInt(uid));
		return queryAll();
	}

	@RequestMapping("/selectpage")
	public String returntoUserInformation(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String did = request.getParameter("did");
		Department department = departService.SearchDepartmentById(totype
				.toInt(did));
		User user = userService.firndUserById(department.getD_fuZeRenId());
		model.addAttribute(department);
		model.addAttribute(user);
		return "department/departmentAdd";
	}

	@RequestMapping("/saveDepartment")
	public ModelAndView departMentAdd(HttpServletRequest request,
			HttpServletResponse response) {
		int d_id = totype.toInt(request.getParameter("d_id"));
		String depatName = request.getParameter("depart_name");
		String fuzeRen = request.getParameter("depart_fuZeRen");
		Department depart = new Department();
		User user = userService.findUserByName(d_id);
		// 差用户ID判断受否存在和界面进行处理
		depart.setD_fuZeRenId(user.getU_id());
		depart.setD_name(depatName);
		if (d_id==0) {
			departService.AddDepartMent(depart);
		} else {
			depart.setD_id(d_id);
			departService.updateDepartMent(depart);
		}
		return queryAll();
	}

	/*
	 * 查找所有得信息
	 */
	@RequestMapping("/departManage")
	public ModelAndView userMangeAll(HttpServletRequest request,
			HttpServletResponse response) {
		return queryAll();
	}

	public ModelAndView queryAll() {
		List<User> list = userService.selectUserAll();
		List<Department> departList = new ArrayList<Department>();
		departList = departService.query();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("department/departquery");
		mav.addObject("departlist", departList);
		mav.addObject("list", list);
		return mav;
	}
}
