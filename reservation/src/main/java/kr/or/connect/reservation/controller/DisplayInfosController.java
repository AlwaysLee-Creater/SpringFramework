package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.reservation.dto.DisplayInfos;
import kr.or.connect.reservation.service.DisplayInfosService;

@Controller
public class DisplayInfosController {
	@Autowired
	DisplayInfosService displayInfosService;
	
	@GetMapping(path="/api/displayinfos")
	public String displayInfos(Integer categoryId,Integer start,ModelMap model) {
		List<DisplayInfos> list=displayInfosService.getDisplayInfos(categoryId, start);
		int totalCount;
		int productCount;
		
		totalCount=displayInfosService.getCount(categoryId);
		productCount=list.size();
	
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("productCount",productCount);
		model.addAttribute("list",list);
		
		return "displayInfos";
	}
}
