package kr.or.ddit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.FileUploadService;
import kr.or.ddit.service.ProductService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final FileUploadService fileUploadService;
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Map<String, Object>> list = productService.findAll();
		model.addAttribute("list", list);
		return "products";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "addProduct";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPro(MultipartFile productImage,
						@RequestParam Map<String, Object> map) {
		
		boolean result = fileUploadService.upload(productImage, map);
		
		return "redirect:/product/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Model model) {
		List<Map<String, Object>> list = productService.findAll();
		
		model.addAttribute("edit", "update");
		model.addAttribute("list", list);
		return "editProduct";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) {
		List<Map<String, Object>> list = productService.findAll();
		model.addAttribute("edit", "delete");
		model.addAttribute("list", list);
		return "editProduct";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, String id) {
		Map<String, Object> map = null;
		try {
			map = productService.findOne(id);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("item", map);
		return "product";
	}
	
	@GetMapping("/modifyView")
	public String modify(String id, Model model) {
		Map<String, Object> findOne = null;
		try {
			findOne = productService.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("item", findOne);
		return "/updateProduct";
	}
	
	
	@PostMapping("/modifyView")
	public String modifyPro(@RequestParam Map<String, Object> map,
					Model model) {
		
		for(String key : map.keySet()) {
			System.out.println(key);
		}
		
		productService.update(map);
		model.addAttribute("id", map.get("productId"));
		
		return "redirect:/product/detail";
	}
	
	@GetMapping("/deletePro")
	public String deletePro(String id) {
		productService.delete(id);
		return "redirect:/product/delete";
	}
	
	@PostMapping("/addCart")
	public String addCart(String id, Model model,
				HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String, Object> item = null;
		try {
			item = productService.findOne(id);
			List<Map<String, Object>> list = 
					(List<Map<String, Object>>)session.getAttribute("itemList");
			
			if(list == null) {
				list = new ArrayList<>();
				item.put("quantity", 1);
				list.add(item);
				session.setAttribute("itemList", list);
			} else {
				for(Map<String, Object> i : list) {
					String pId = i.get("P_ID") + "";
					if(pId.equals(id)) {
						int quan = Integer.parseInt(i.get("quantity") + "");
						i.put("quantity", quan + 1);
						break;
					} else if(list.indexOf(i) == list.size() - 1) {
						item.put("quantity", 1);
						list.add(item);
						session.setAttribute("itemList", list);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("id", id);
		return "redirect:/product/detail";
	}
	
	@GetMapping("/showCart")
	public String showCart() {
		
		return "";
	}
}
