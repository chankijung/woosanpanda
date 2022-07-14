package com.woosan.root.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.woosan.root.dto.TradeBoardDTO;
import com.woosan.root.dto.TradeBoardReply;

public interface TradeBoardService {
	public List<TradeBoardDTO> tradeBoardView();
	public void writeBoard(TradeBoardDTO dto, MultipartHttpServletRequest mul);
	public TradeBoardDTO searchNum(String write_no);
	public void updateHit(String write_no);
	public String cateSetting(String cate);
	public List<TradeBoardReply> tradeReplyView(String write_no);
	public void writeReply(HttpServletRequest req, String level, String reply_no, String reply_chkNum);
	public int nextReplyNo();
}
