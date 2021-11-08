package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TilesController {
	
	@GetMapping("/body1")
	public String tiles1() {
		return "test1/body1";
	}
	
	@GetMapping("/body2")
	public String tiles2() {
		return "test2/body2";
	}
}
