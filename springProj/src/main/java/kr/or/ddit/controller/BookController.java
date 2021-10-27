package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		// 웹브라우저에서 /create주소를 get방식으로 요청하면
		// book/create 경로의 view를 응답
		mav.setViewName("book/create");
		return mav;
		
//		return new ModelAndView("book/create");
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public ModelAndView createPost(
			@RequestParam HashMap<String, Object> map) {
		String bookId = this.bookService.insert(map);
		
		if(bookId == null) {
			return new ModelAndView("redirect:/create");			
		}
		return new ModelAndView("redirect:/detail?bookId=" + bookId);
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public ModelAndView detail(
			@RequestParam Map<String, Object> bookId) {
		
		Map<String, Object> detailMap = bookService.select(bookId);
		
		ModelAndView mav = new ModelAndView("book/detail");
		mav.addObject("data", detailMap);
		
		return mav;
	}
	
}