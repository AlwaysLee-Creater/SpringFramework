package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfosDao;
import kr.or.connect.reservation.dto.DisplayInfos;
import kr.or.connect.reservation.service.DisplayInfosService;

@Service
public class DisplayInfosServiceImpl implements DisplayInfosService{
	@Autowired
	DisplayInfosDao displayInfosDao;
	
	@Override
	@Transactional
	public List<DisplayInfos> getDisplayInfos(Integer categoryId, Integer start){
		List<DisplayInfos> list=displayInfosDao.selectDisplayInfos(categoryId, start);
		return list;
	}
	
	@Override
	@Transactional
	public int getCount(Integer categoryId) {
		int count=displayInfosDao.selectCount(categoryId);
		return count;
	}
}
