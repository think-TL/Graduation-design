package com.attendance.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class getParameter {
	 public static Map<String,String> getparameters(HttpServletRequest request){
		 Map<String,String> param = new HashMap<String,String>() ;
			Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()) {
				String nextElement = (String) parameterNames.nextElement();
				param.put(nextElement, request.getParameter(nextElement));
			}
		   return param;
	   }
}
