package com.woosan.root.member.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.woosan.root.member.dto.MemberDTO;
import com.woosan.root.member.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter implements SessionName{
	@Autowired MemberService ms;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("자동로그인 과정");
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			MemberDTO dto = ms.getSessionId(loginCookie.getValue());
			if(dto != null) {
				request.getSession().setAttribute(LOGIN, dto.getId());
			}
		}
		return true;
	}
	
	
}