package kr.or.ddit.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.vo.AttachFileVO;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@GetMapping("/uploadAjax")
	public String fileAjax() {
		return "uploadAjax";
	}
	
	@ResponseBody
	@PostMapping("/uploadAjax")
	public List<AttachFileVO> fileAjaxPro(MultipartFile[] uploadFile) {
		List<AttachFileVO> list = new ArrayList<>();
		
		String path = "/Users/andaegeun/Desktop/dditSpring/springProj/src/main/webapp/resources/images";
		
		File uploadPath = new File(path, getFolder());
		
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();			
		}
		
		for(MultipartFile f : uploadFile) {
			AttachFileVO vo = new AttachFileVO();
			
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString() + "_" + f.getOriginalFilename();

			vo.setFileName(f.getOriginalFilename());
			vo.setUploadPath(uploadFileName);
			vo.setUuid(uploadFileName);
			//File file = new File(path, f.getOriginalFilename());
			File file = new File(uploadPath, uploadFileName);
			
			try {
				f.transferTo(file);
				
				if(checkImageType(file)) {
					FileOutputStream fos = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(f.getInputStream(), fos, 100, 100);
					fos.close();
					vo.setImage(true);
				}
			} catch (IllegalStateException | IOException e) {
				logger.error(e.getMessage());
			}
			list.add(vo);
		}
		
		return list;
	}
	
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		return sdf.format(date).replace("-", File.separator);
	}
	
	private boolean checkImageType(File file) {
		//MIME타입을 통해 이지미 여부 확인
		//file.toPath() : 파일객체를 path객체로 변환
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			logger.info("contentType : " + contentType);
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}


























