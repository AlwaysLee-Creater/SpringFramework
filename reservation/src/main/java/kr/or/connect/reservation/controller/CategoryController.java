package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path="/api/categories")
	public String category(ModelMap model) { 
		List<Category> list=categoryService.getCategory();
		int size;
		
		size=list.size();

		model.addAttribute("size",size);
		model.addAttribute("list",list);
		
		return "category";
	}
}
