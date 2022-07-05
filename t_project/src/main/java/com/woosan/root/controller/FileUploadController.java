package com.woosan.root.controller;

import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woosan.root.service.AwsS3Biz;

@Controller
public class FileUploadController {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private AwsS3Biz s3Service;
	@Value("${aws.accesskey}")
	private String accessKey;
	
	// ���� ���ε� ó��
	@RequestMapping(value = "/image.do", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(HttpServletRequest request, MultipartFile file) throws Exception {
		
		String originalFileName = file.getOriginalFilename(); 
		
		// ========= ���ϸ� �ߺ� ���� ó�� ========= //
		String uuidFileName = getUuidFileName(originalFileName);
		
		// ========= �̹��� ���� ������ üũ ========= //  
		int[] imageSize = checkImageSize(file);
		System.out.println("width = "+ imageSize[0] + "height = " + imageSize[1]);
		
		// ========= ������ ���� ���� ========= // 
		String res = s3Service.uploadObject(file, uuidFileName);
		System.out.println(res);
		return "<��Ŷ�ּ�>"+uuidFileName;
	}

	private static String getUuidFileName(String originalFileName) {
		return UUID.randomUUID().toString() + "_" + originalFileName;
	}  
}