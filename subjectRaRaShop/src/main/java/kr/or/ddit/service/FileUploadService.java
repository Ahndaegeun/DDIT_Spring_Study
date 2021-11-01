package kr.or.ddit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.dao.ProductDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {
	
	private final ProductDAO productDAO;
	private static final String SAVE_PATH = "/Users/andaegeun/Desktop/dditSpring/subjectRaRaShop/src/main/webapp/resources/images";
	

	public boolean upload(MultipartFile productImage, Map<String, Object> map) {
		boolean result = writeFile(productImage);		
		for(String key : map.keySet()) {
			System.out.println(key);
		}
		if(result) {
			map.put("filename", productImage.getOriginalFilename());
			result = productDAO.save(map);
		}
	
		return result;
	}
	
	private boolean writeFile(MultipartFile multipartFile) {
		try {
			
			File saveFile = new File(SAVE_PATH, multipartFile.getOriginalFilename());
			multipartFile.transferTo(saveFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
