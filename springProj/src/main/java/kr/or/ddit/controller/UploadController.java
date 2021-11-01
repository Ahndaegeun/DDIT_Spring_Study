package kr.or.ddit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
}
