package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.reservation.dto.PromotionInfos;
import kr.or.connect.reservation.service.PromotionInfosService;

@Controller
public class PromotionController {
	@Autowired 
	PromotionInfosService promotionInfosService;
	
	@GetMapping(path="/api/promotions")
	public String promotionInfos(ModelMap map) {
		List<PromotionInfos> list=promotionInfosService.getPromotionInfos();
		int size=list.size();
		
		map.put("size",size);
		map.put("items",list);
		
		
		return "promotions";
	}
}
