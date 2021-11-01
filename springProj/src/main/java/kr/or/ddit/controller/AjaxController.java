package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxController {
	
	@GetMapping("/uploadAjax")
	public String fileAjax() {
		return "uploadAjax";
	}
	
	@ResponseBody
	@PostMapping("/uploadAjax")
	public String fileAjaxPro(MultipartFile[] uploadFile) {
		String path = "/Users/andaegeun/Desktop/dditSpring/springProj/src/main/webapp/resources/images";
		
		
		
		return "";
	}
}
