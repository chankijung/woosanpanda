package com.woosan.root.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woosan.root.dto.TradeBoardDTO;

@Repository
public interface TradeBoardMapper {
	public List<TradeBoardDTO> tradeBoardView();
}
