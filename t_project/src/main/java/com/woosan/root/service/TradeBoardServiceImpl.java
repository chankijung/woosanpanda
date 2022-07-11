package com.woosan.root.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.woosan.root.configuration.S3Util;
import com.woosan.root.configuration.UploadFileUtils;
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

	@Override
	public void writeBoard(TradeBoardDTO dto, MultipartHttpServletRequest mul) {
		MultipartFile file = mul.getFile("image_addr");
		if(file!=null) {
			String uploadpath="trade/thumbnail";
			ResponseEntity<String> img_path = null;
			try {
				img_path = new ResponseEntity<>(
						UploadFileUtils.uploadFile(uploadpath, file.getOriginalFilename(), file.getBytes()),
						HttpStatus.CREATED);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String user_imgPath = (String) img_path.getBody();
			dto.setImg_addr(user_imgPath);
		}
		tbm.writeBoard(dto);
		
	}

	@Override
	public TradeBoardDTO searchNum(String write_no) {
		TradeBoardDTO dto = tbm.searchNum(write_no);
		return dto;
	}

	@Override
	public void updateHit(String write_no) {
		tbm.updateHit(write_no);
	}

	@Override
	public String cateSetting(String cate) {
		switch (cate) {
		case "1":
			return "가전제품";
		case "2":
			return "운동용품";
		case "3":
			return "사무용품";
		case "4":
			return "주방용품";
		case "5":
			return "취미용품";
		default:
			return "기타";
		}
	}

}
