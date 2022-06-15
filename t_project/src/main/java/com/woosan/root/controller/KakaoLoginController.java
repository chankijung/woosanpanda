package com.woosan.root.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class KakaoLoginController {
	@GetMapping("kakaologin")
	public String kakaoLogin(String code) {
	  return "kakaologin";
	}
	@PostMapping("loginAction")
	public String loginAction(String code, HttpServletRequest req) {
		String kakaoid=req.getParameter("kakaoemail");
		req.setAttribute("kakaoid", req.getParameter("kakaoemail"));
		req.setAttribute("kakaoemail", req.getParameter("kakaoemail"));
		
		return "redirect:home";
	}

}
