package kr.or.ddit.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerByParameter(
			String userId, String password) {
		logger.info("userId = " + userId);
		logger.info("password = " + password);
		
		return "success";
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String memberList() {
		return "member/list";
	}
	
	@RequestMapping(value = "/register01", method = RequestMethod.GET)
	public String register01(
			@RequestParam Map<String, Object> map,
			Model model) {
		logger.info("register01");
		
		model.addAttribute("map", map);
		return "member/register01";
	}
}
