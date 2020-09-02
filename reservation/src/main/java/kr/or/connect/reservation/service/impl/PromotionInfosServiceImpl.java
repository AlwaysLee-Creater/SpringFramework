package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionsDao;
import kr.or.connect.reservation.dto.PromotionInfos;
import kr.or.connect.reservation.service.PromotionInfosService;

@Service
public class PromotionInfosServiceImpl implements PromotionInfosService{
	@Autowired
	PromotionsDao promotionDao;
	PromotionInfos p;
	
	@Override
	@Transactional
	public List<PromotionInfos> getPromotionInfos(){
		List<PromotionInfos> list=promotionDao.selectPromotionsInfos();
		for(int i=0;i<list.size();i++) {		
			p=list.get(i);
			p.setId(i+1);
			list.set(i, p);
		}
		return list;
	}
}
