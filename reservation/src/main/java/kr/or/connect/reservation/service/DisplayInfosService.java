package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfos;

public interface DisplayInfosService {
	public static final Integer LIMIT=4;
	public List<DisplayInfos> getDisplayInfos(Integer categoryId, Integer start);
	public int getCount(Integer categoryId);
}
