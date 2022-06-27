package com.woosan.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.woosan.root.dto.TradeBoardDTO;
import com.woosan.root.mapper.TradeBoardMapper;

@Primary
@Service
public class TradeBoardServiceImpl implements TradeBoardService {
	@Autowired TradeBoardMapper tbm;
	
	@Override
	public List<TradeBoardDTO> tradeBoardView() {
		List<TradeBoardDTO> arr = tbm.tradeBoardView();
		return arr;
	}

}
