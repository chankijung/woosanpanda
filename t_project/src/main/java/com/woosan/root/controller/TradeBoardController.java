package com.woosan.root.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.woosan.root.service.TradeBoardService;

@Controller
public class TradeBoardController {
	@Autowired TradeBoardService tbs;

	@GetMapping("tradeboard")
	public String board(Model model) {
		model.addAttribute("list",tbs.tradeBoardView());
		return "tradeboard";
	}
	
	@GetMapping("chat")
	public String chat() {
		return "chat";
	}
	
	@GetMapping("write")
	public String write() {
		return "tradeWriteForm";
	}
	
	@PostMapping("writeAdmit")
	public String writeBoard(HttpServletRequest req) {
		return "tradeboard";
	}
	
	
}
