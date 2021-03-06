package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
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
		mav.addObject("bookId", bookId.get("bookId"));
		
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(
			@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> data = bookService.select(map);
		mav.setViewName("book/update");
		mav.addObject("data", data);
		mav.addObject("bookId", map.get("bookId"));
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(
			@RequestParam Map<String, Object> map,
			ModelAndView mav) {
		boolean result = bookService.update(map);
		System.out.println(result);
		if(result) {
			mav.setViewName("redirect:/detail?bookId=" + map.get("bookId"));
		} else {
			mav = this.update(map);
		}
				
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(
			@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView("book/list");
		
		List<Map<String,Object>> selectAll = bookService.selectAll(map);
		mav.addObject("list", selectAll);
		
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(
			@RequestParam String bookId,
			ModelAndView mav) {
		boolean result = bookService.delete(bookId);
		if(result) {
			mav.setViewName("redirect:/list");
		} else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		
		return mav;
	}
}
