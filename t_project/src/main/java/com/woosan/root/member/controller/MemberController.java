package com.woosan.root.member.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woosan.root.member.common.SessionName;
import com.woosan.root.member.dto.MemberDTO;
import com.woosan.root.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController implements SessionName {
	@Autowired MemberService ms;
	
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
		
	}
	
	@PostMapping("/logChk")
	public String logChk(@RequestParam String id,
						@RequestParam String pw,
						@RequestParam(required = false) String autoLogin,
						RedirectAttributes ra,
						Model model,
						HttpSession session
						) {
		int result = ms.logChk(id, pw);
		if(result == 0 ) {
			
			session.setAttribute("id", id);
			//session.setAttribute("pw", pw);
			session.setAttribute("autoLogin", autoLogin);
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	
	
	@GetMapping( "/successLogin" )
	public String successLogin(
						HttpServletRequest req,
						HttpSession session,
						HttpServletResponse rep) {
		session.setAttribute(LOGIN, session.getAttribute("id"));
		
		System.out.println(
			"auto : "+session.getAttribute("autoLogin"));
		if(session.getAttribute("autoLogin") != null) {
			int time = 60*60*24*90; //90일
			Cookie cook = 
				new Cookie("loginCookie", session.getId());
			cook.setPath("/");
			cook.setMaxAge(time);
			rep.addCookie(cook);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime( new java.util.Date() );
			cal.add(Calendar.MONTH, 3);
			
			java.sql.Date limitDate = 
					new java.sql.Date(cal.getTimeInMillis());
			ms.keepLogin(session.getId(), limitDate,
						(String)session.getAttribute("id"));
		}
		return "member/successLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response,
							@CookieValue(required =false) Cookie loginCookie) {
		if(loginCookie != null) {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			ms.keepLogin("nan", 
					new Date(System.currentTimeMillis()),
					(String)session.getAttribute(LOGIN));
		}
		session.invalidate();
		return "redirect:/index";
	}
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberInfo(model);
		return "member/memberInfo";
		
	}
	
	@GetMapping("info")
	public String info(Model model, @RequestParam String id) {
		ms.info(model, id);
		return "member/info";
	}
	@GetMapping("registerForm")
	public String registerForm() {
		return "member/registerForm";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		int result= ms.register(dto);
		if(result==1) {
			return "redirect:login";
		}
		return "redirect:registerForm";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		int cnt= ms.idCheck(id);
		return cnt;
	}
}