package com.attendance.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.filefilter.AgeFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.attendance.model.Department;
import com.attendance.model.User;
import com.attendance.service.DepartmentService;
import com.attendance.service.UserService;
import com.attendance.utils.PageModel;
import com.attendance.utils.getParameter;
import com.attendance.utils.totype;

@Controller
@RequestMapping("/user")
public class userManagerController {

	@Resource
	private UserService userService;
	@Resource
	private DepartmentService departService;

	@RequestMapping("/returnPage")
	public String returntoUserInformation(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String uid = request.getParameter("u_id");
		User user = userService.firndUserById(totype.toInt(uid));
		Department department = departService.SearchDepartmentById(user
				.getD_id());
		model.addAttribute(department);
		model.addAttribute(user);
		return "user/userInformation";
	}

	@RequestMapping("/userDel")
	public ModelAndView userDel(HttpServletRequest request,
			HttpServletResponse response) {
		String uid = request.getParameter("uid");
		userService.delUser(totype.toInt(uid));
		PageModel<User> page = new PageModel<User>();
		return setPageModel(page);
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> useMap = getParameter.getparameters(request);
		userService.saveUser(useMap);
		PageModel<User> page = new PageModel<User>();
		return setPageModel(page);
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/alertUser")
	public String alterUser(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		int id = totype.toInt(request.getParameter("u_id"));
		String email = request.getParameter("userEmail");
		int qq = totype.toInt(request.getParameter("userQQ"));
		int phone = totype.toInt(request.getParameter("userPhone"));
		String address = request.getParameter("userAddress");

		User user = new User();
		user.setU_id(id);
		user.setU_email(email);
		user.setU_address(address);
		user.setU_QQ(qq);
		user.setU_phone(phone);
		user = userService.updateUser(user);

		Department department = LoginController.department;
		model.addAttribute(department);
		model.addAttribute(user);

		return "main";
	}

	
	/*
	 * 查找所有得信息
	 */
	@RequestMapping("/userManage")
	public ModelAndView userMangeAll(HttpServletRequest request,
			HttpServletResponse response) {
		String strCurrentPage=request.getParameter("currentPage");
		PageModel<User> page = new PageModel<User>();
		if(strCurrentPage!=null){
			page.setCurrentPage(totype.toInt(strCurrentPage));
		}
	    return setPageModel(page);
	}

	
	/**
	 * 设置分页信息
	 * @param page
	 * @return
	 */
	public ModelAndView setPageModel(PageModel<User> page){
		List<User> list = userService.selectUserAll();
		List<User> sub=null;
		int startIndex = (page.getCurrentPage()-1) * page.getPageSize();//获取第一行
		int endIndex = page.getCurrentPage() * page.getPageSize(); //获取最后一个信息
		if(endIndex>=list.size()){ //最后的长度大于数据长度 
			sub=list.subList(startIndex, list.size());
		}else{
			sub=list.subList(startIndex, endIndex);
		}
		page.setAllCount(list.size());
	    page.setAllPage((list.size()-1)/page.getPageSize()+1);
	    page.setResult(sub);
		
	    return setModelAndView(page);
	}
	
	/**
	 * 设置Model信息
	 * @param pageModel
	 * @return
	 */
	public ModelAndView setModelAndView(PageModel<User> pageModel) {
		List<Department> departList = new ArrayList<Department>();
		departList = departService.query();
		ModelAndView mav = new ModelAndView();
		mav.addObject("departlist", departList);
		mav.addObject("pageMolde", pageModel);
		mav.setViewName("user/userquery");
		return mav;
	}
	
	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		if (!file.isEmpty()) {
			try {
	
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
			
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "main";
	}

	
	
	
	
	/**
	 * 用户查询 json返回
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findUser")
	public String findUser(HttpServletRequest request, HttpServletResponse response) {
		String uservalue = request.getParameter("uservalue");
		return null;
	}
	
	
	
	
	
	protected void write(HttpServletRequest request,
			HttpServletResponse response,Object object) throws IOException {
		String result = "";
		if (object instanceof Map || object instanceof List){
			result = JSON.toJSONString(object);
		} else if (object instanceof String || object instanceof StringBuffer || object instanceof StringBuilder  ){
			result = object.toString();
		} else {
			result = JSON.toJSONString(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.flush();
	}
	
	

}
