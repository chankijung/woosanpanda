package com.woosan.root.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woosan.root.dto.TradeBoardDTO;

@Repository
public interface TradeBoardMapper {
	public List<TradeBoardDTO> tradeBoardView();
	public void writeBoard(TradeBoardDTO dto);
	public TradeBoardDTO searchNum(String write_no);
	public void updateHit(String write_no);
}
