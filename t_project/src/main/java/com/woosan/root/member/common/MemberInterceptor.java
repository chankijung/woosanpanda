package com.woosan.root.member.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter implements SessionName{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("index 실행 전 실행");
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) ==null) {
			response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path= request.getContextPath();
		out.print("<script> alert('로그인 필요');"
				+ "location.href='"+path+"/member/login'</script>");
		
		return false;
		}
		return true;
	}
	
}
