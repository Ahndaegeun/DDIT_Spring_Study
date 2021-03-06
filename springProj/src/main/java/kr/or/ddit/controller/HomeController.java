package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.vo.BookVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public void home() {
		logger.info("home");
	}
	
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET)
	public void home0101() {
		logger.info("home0101");
	}
	
	@RequestMapping(value = "/goHome0102", method = RequestMethod.GET)
	public void home0102() {
		logger.info("home0102");
	}
	
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String home0201() {
		logger.info("home0102");
		return "home0201";
	}
	
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String home0202() {
		logger.info("home0202");
		return "goHome0202";
	}
	
	@RequestMapping(value = "/goHome0204", method = RequestMethod.GET)
	public String home0204() {
		logger.info("home0204");
		return "redirect:/sub/goHome0202";
	}
	
	@ResponseBody
	@RequestMapping(value = "/goHome0301", method = RequestMethod.GET)
	public BookVO home0301() {
		logger.info("home0301");
		BookVO vo = new BookVO();
		vo.setBOOK_ID(20211029);
		vo.setTITLE("JPA...1");
		vo.setCATEGORY("TT");
		vo.setPRICE(10000);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/goHome0302", method = RequestMethod.GET)
	public List<BookVO> home0302() {
		logger.info("home04");
		List<BookVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			BookVO vo = new BookVO();
			vo.setBOOK_ID(20211029 + i);
			vo.setTITLE("JPA..." + i);
			vo.setCATEGORY("TT");
			vo.setPRICE(10000 + i * 1000);
			list.add(vo);
		}
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/goHome0303", method = RequestMethod.GET)
	public Map<String, BookVO> home05() {
		logger.info("home05");
		
		Map<String, BookVO> map = new HashMap<>();
		
		for(int i = 1; i <= 10; i++) {
			BookVO vo = new BookVO();
			vo.setBOOK_ID(20211029 + i);
			vo.setTITLE("JPA..." + i);
			vo.setCATEGORY("TT");
			vo.setPRICE(10000 + i * 1000);
			map.put("book-" + i, vo);
		}
		
		return map;
	}
}






















