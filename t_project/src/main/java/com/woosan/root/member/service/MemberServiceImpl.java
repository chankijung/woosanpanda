package com.woosan.root.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woosan.root.member.dto.MemberDTO;
import com.woosan.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder en = new BCryptPasswordEncoder();
	
	public int logChk(String id, String pw) {
		int result = 1;
		// select * from table where id=id
		MemberDTO dto = mapper.logChk(id);
		if(dto != null) {
			if( en.matches( pw, dto.getPw()) || dto.getPw().equals(pw)) {
				return 0;
			}
		}
		return result;
	}
	@Override
	public void memberInfo(Model model) {
		model.addAttribute("memberList", mapper.memberInfo());
		
	}
	@Override
	public int register(MemberDTO dto) {
		System.out.println("변경 전: "+dto.getPw());//복호화 전
		String se = en.encode(dto.getPw());
		System.out.println("변경 후 : "+se);
		
		int result=0;
		try {
			result=mapper.register(dto);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		return result;
	}
	@Override
	public void info(Model model, String id) {
		model.addAttribute("info", mapper.logChk(id));
	}
	
	public void insertMember(MemberDTO dto) {
		
	}
	
	public void keepLogin(String sessionId, 
			java.sql.Date limitDate,
			String id) {
		Map<String, Object> map = 
			new HashMap<String, Object>();
		map.put("s", sessionId );
		map.put("d", limitDate );
		map.put("id", id);

			mapper.keepLogin(map);
}
	@Override
	public MemberDTO getSessionId(String s_id) {
		return mapper.getSessionId(s_id);
	}
	@Override
	public int idCheck(String id) {
		int cnt = mapper.idCheck(id);
		System.out.println("cnt:"+cnt);
		return cnt;
	}
	



}
