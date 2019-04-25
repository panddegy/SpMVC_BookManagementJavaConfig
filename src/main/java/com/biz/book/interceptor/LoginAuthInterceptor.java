package com.biz.book.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.biz.book.model.AdminVO;

public class LoginAuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		AdminVO adminVO=(AdminVO) session.getAttribute("Admin");
		
		if(adminVO == null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true;
	
	}

}
