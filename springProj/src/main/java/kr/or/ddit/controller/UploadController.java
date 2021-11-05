package kr.or.ddit.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping("/uploadFormAction")
	public String upload() {
		return "uploadForm";
	}
	
	// 단일 업로드
//	@PostMapping("/uploadFormAction")
//	public String uploadPro(MultipartFile uploadFile) {
//		String uploadFolder = "/Users/andaegeun/Desktop/dditSpring/springProj/src/main/webapp/resources/upload";
//		
//		logger.info(uploadFile.getOriginalFilename());
//		logger.info(uploadFile.getSize() + "");
//		
//		File saveFile = new File(uploadFolder, uploadFile.getOriginalFilename());
//		
//		try {
//			uploadFile.transferTo(saveFile);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//		
//		return "";
//	}
	
	// 다중 업로드
	@PostMapping("/uploadFormAction")
	public String uploadPro(MultipartFile[] uploadFile, Model model) {
		String uploadFolder = "/Users/andaegeun/Desktop/dditSpring/springProj/src/main/webapp/resources/upload";
		
		List<String> list = new ArrayList<>();
		
		for(MultipartFile file : uploadFile) {
			logger.info(file.getOriginalFilename());
			logger.info(file.getSize() + "");
			
			File saveFile = new File(uploadFolder, file.getOriginalFilename());
			
			try {
				file.transferTo(saveFile);
				list.add(file.getOriginalFilename());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		model.addAttribute("fileNames", list);
		return "uploadFormPost";
	}
	
	public void uploadAjax(MultipartFile[] multipartFile) {
		
		for(MultipartFile f : multipartFile) {
			logger.info("fileName : " + f.getOriginalFilename());
		}
	}
	
	@GetMapping("/downloadView")
	public String downloadView() {
		return "downloadView";
	}
	
	
	// File Download
	// import org.springframework.http.MediaType
	// import org.springframework.core.io.Resource;
	// import org.springframework.http.HttpHeaders;
	// APPLICATION_OCTET_STREAM_VALUE => download할 수 있는 mime type
	// User-Agent : HTTP Header Message 중 디바이스의 정보를 제공
	//				(웹 브라우저의 종류, 모바일, 데스크탑)
	//				IE에서 처리시 따로 처리가 필요함
	@GetMapping(value = "/download", 
				produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent,
			String fileName) {
		// file 위치
		String path = "/Users/andaegeun/Desktop/dditSpring/springProj/src/main/webapp/resources/upload/";
		
		logger.info("download file : " + fileName);
		
		Resource resource = new FileSystemResource(path + fileName);
		
		// 파일이 없을때
		if(!resource.exists()) {
			//jsp에서 에러페이지로 넘기기
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		logger.info("resource : " + resource);
		
		//file명 가져오기
		String resourceName = resource.getFilename();
		//file명이 한글이면	
		HttpHeaders headers = new HttpHeaders();
		
		try {
			String downloadName = null;
			
			
			if(userAgent.contains("Trident")) {// Trident : IE version 11
				logger.info("IE browser");
				downloadName = URLEncoder.encode(resourceName, "utf-8").replaceAll("\\+", " ");
			} else if(userAgent.contains("Edge")) {// Edge
				logger.info("Edge browser");
				downloadName = URLEncoder.encode(resourceName, "utf-8");
			} else {
				logger.info("Chrome browser");
				downloadName = new String(resourceName.getBytes("utf-8"), "ISO-8859-1");
			}
			
			// 첫번째 파라미터 Content-disposition : 다운로드 시 저장되는 이름
			// 두번째 파라미터 attachment;filename= : 한글일 경우 utf-8로 인코딩 해주기 위해서 잡아줌
			headers.add("Content-disposition", "attachment;filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// ressource : 첨부파일 객체
		// headers : 파일명 처리 정보
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
























