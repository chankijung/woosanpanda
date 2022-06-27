package com.woosan.root.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woosan.root.service.TradeBoardService;

@Controller
public class TradeBoardController {
	@Autowired TradeBoardService tbs;

	@GetMapping("tradeboard")
	public String board(Model model) {
		model.addAttribute("list",tbs.tradeBoardView());
		return "tradeboard";
	}
	
	
}
