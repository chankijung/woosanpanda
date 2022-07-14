package com.woosan.root.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.woosan.root.dto.TradeBoardReply;
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

	@Override
	public List<TradeBoardReply> tradeReplyView(String write_no) {
		return tbm.tradeReplyView(write_no);
	}
	
	@Override
	public int nextReplyNo() {
		return tbm.nextReplyNo();
	}

	@Override
	public void writeReply(HttpServletRequest req, String level, String reply_no, String reply_chkNum) {
		TradeBoardReply tr = new TradeBoardReply();
		tr.setContent(req.getParameter("content"));
		tr.setReply_level(Integer.valueOf(level));
		tr.setWrite_no(Integer.valueOf(req.getParameter("write_no")));
		if(Integer.valueOf(level)==0) {
		tr.setRate(Integer.valueOf(req.getParameter("rate")));
		tr.setReply_chkNo(0);
		tr.setReply_no(nextReplyNo()+1);
		}else {
			tr.setRate(0);
			tr.setReply_chkNo(Integer.valueOf(reply_chkNum)+1);
			tr.setReply_no(Integer.valueOf(reply_no));
		}
		tr.setId("admin");
		tbm.writeReply(tr);
	}

}
