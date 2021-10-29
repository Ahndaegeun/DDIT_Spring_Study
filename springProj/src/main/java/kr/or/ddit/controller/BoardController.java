package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	
	@RequestMapping("/register")
	public void registerForm() {
		logger.info("registerForm");
	}
	
	@RequestMapping("/modify")
	public void modifyForm() {
		logger.info("modifyForm");
	}
	
	@RequestMapping("/list")
	public void list() {
		logger.info("list");
	}
	
	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") String boardNo) {
		logger.info("read : " + boardNo);
		
		return "board/read";
	}
	
	@RequestMapping(value = "/get", 
					method = RequestMethod.GET,
					params = "register")
	public String getForm() {
		logger.info("getForm");
		
		return "board/register";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "register")
	public String register() {
		logger.info("register");
		return "board/list";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "modify")
	public String modify() {
		logger.info("modify");
		return "board/list";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "modify")
	public String modifyGet() {
		logger.info("modifyGet");
		
		return "board/modify";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "remove")
	public String removeGet() {
		logger.info("removeGet");
		
		return "board/remove";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "list")
	public String listGet() {
		logger.info("listGet");
		
		return "board/list";
	}
	
}















