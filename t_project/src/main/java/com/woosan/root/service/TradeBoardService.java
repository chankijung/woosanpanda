package com.woosan.root.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.woosan.root.dto.TradeBoardDTO;

public interface TradeBoardService {
	public List<TradeBoardDTO> tradeBoardView();
	public void writeBoard(TradeBoardDTO dto, MultipartHttpServletRequest mul);
}
