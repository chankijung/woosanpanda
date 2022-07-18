package com.woosan.root.mybatis.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.woosan.root.member.dto.MemberDTO;
@Repository
public interface MemberMapper {
		public MemberDTO logChk(String id);

		public List<MemberDTO> memberInfo();

		public int register(MemberDTO dto);

		public void keepLogin(Map<String, Object> map);
		
		public MemberDTO getSessionId(String s_id);
}

