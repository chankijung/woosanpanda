package com.woosan.root.member.service;

import java.sql.Date;

import org.springframework.ui.Model;

import com.woosan.root.member.dto.MemberDTO;

public interface MemberService {
	public int logChk(String id, String pw);
	public void memberInfo(Model model);
	public void info(Model model,String id);
	public int register(MemberDTO dto);
	public void keepLogin(String id, Date limitDate, String sessionId);
	public MemberDTO getSessionId(String s_id);
	
}
