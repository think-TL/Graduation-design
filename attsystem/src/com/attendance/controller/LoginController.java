package com.attendance.controller;

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
import com.attendance.service.LoginService;
import com.attendance.utils.getParameter;
import com.attendance.utils.totype;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginService loginService;
	@Resource
	private DepartmentService departService;
	 
	public static User user;
	public static Department department;
	
	@RequestMapping("/main")
	public ModelAndView Hello(HttpServletRequest httpRequet, HttpServletResponse httpresopne,
			Model model) {
		ModelAndView mav = new ModelAndView();
		String password = httpRequet.getParameter("password");
		int u_userid=totype.toInt(httpRequet.getParameter("username"));
		user = loginService.Login(u_userid, password);
		if (user == null) {
			mav.setViewName("index");
			return mav;
		} else if (!(user.getU_password().equals(password))) {
			mav.setViewName("index");
			return mav;
		} else {
			department =departService.SearchDepartmentById(user.getD_id());
			int a = 1; 
			int b = 2; 
			int c = 3; 
			mav.addObject("department", department);
			mav.addObject("user", user);
			mav.addObject("test01", a);
			mav.addObject("test02", b);
			mav.addObject("test03", c);
			mav.setViewName("main");
			return mav;
		}
	}
	
}
