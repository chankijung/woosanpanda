package com.woosan.root.controller;

import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.util.IOUtils;
import com.woosan.root.configuration.S3Util;
import com.woosan.root.dto.TradeBoardDTO;
import com.woosan.root.service.TradeBoardService;

@Controller
public class TradeBoardController {
	@Autowired
	TradeBoardService tbs;
	S3Util s3 = new S3Util();
	String bucketName = "aws-woosan-test01";

	@GetMapping("tradeboard")
	public String board(Model model) {
		model.addAttribute("list", tbs.tradeBoardView());
		return "tradeboard";
	}

	@GetMapping("chat")
	public String chat() {
		return "chat";
	}

	@GetMapping("write")
	public String write(Model model, HttpServletRequest req) {
		model.addAttribute("id", "admin");
		model.addAttribute("addr", (String) req.getAttribute("addr"));
		model.addAttribute("addr2", (String) req.getAttribute("addr2"));
		return "tradeWriteForm";
	}

	@PostMapping("writeAdmit")
	public String writeBoard(HttpServletRequest req, MultipartHttpServletRequest mul) {
		TradeBoardDTO dto = new TradeBoardDTO();
		dto.setTitle(req.getParameter("title"));
		dto.setId(req.getParameter("id"));
		dto.setContent(req.getParameter("content"));
		dto.setImg_addr(req.getParameter("img_addr"));
		dto.setCate(req.getParameter("cate"));
		dto.setPrice(Integer.valueOf(req.getParameter("price")));
		dto.setAddr(req.getParameter("addr"));
		dto.setAddr2(req.getParameter("addr2"));
		tbs.writeBoard(dto, mul);
		return "tradeboard";
	}

	// 이미지 파일 띄우기
	@SuppressWarnings("resource")
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName, String directory) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		HttpURLConnection uCon = null;
		String inputDirectory = null;
		if (directory.equals("thumbnail")) {
			inputDirectory = "trade/thumbnail";
		} else if (directory.equals("profile")) {
			inputDirectory = "member/profile";
		} else {
			inputDirectory = "almom/coverImage";
		}

		try {
			HttpHeaders headers = new HttpHeaders();
			java.net.URL url;
			try {
				url = new java.net.URL(s3.getFileURL(bucketName, inputDirectory + fileName));
				uCon = (HttpURLConnection) url.openConnection();
				in = uCon.getInputStream(); // 이미지를 불러옴
			} catch (Exception e) {
				url = new java.net.URL(s3.getFileURL(bucketName, "default.jpg"));
				uCon = (HttpURLConnection) url.openConnection();
				in = uCon.getInputStream();
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@GetMapping("tradeboardView")
	public String tradeboardView(HttpServletRequest req, Model model) {
		String write_no = req.getParameter("write_no");
		TradeBoardDTO dto = tbs.searchNum(write_no);
		model.addAttribute("id", dto.getId());
		model.addAttribute("image_addr", dto.getImg_addr());
		model.addAttribute("title", dto.getTitle());
		model.addAttribute("content", dto.getContent());
		model.addAttribute("price", dto.getPrice());
		model.addAttribute("cate",tbs.cateSetting(dto.getCate()));
		model.addAttribute("addr", dto.getAddr());
		model.addAttribute("addr2", dto.getAddr2());
		tbs.updateHit(write_no);
		model.addAttribute("list",tbs.tradeReplyView(write_no));
		model.addAttribute("write_no",dto.getWrite_no());
		return "tradeboardView";
	}
	
	@PostMapping("writeReply")
	public String writeReply(@RequestParam String level, HttpServletRequest req, @RequestParam String reply_no, @RequestParam String reply_chkNum) {
		tbs.writeReply(req, level, reply_no, reply_chkNum);
		return "tradeboardView";
	}

}
