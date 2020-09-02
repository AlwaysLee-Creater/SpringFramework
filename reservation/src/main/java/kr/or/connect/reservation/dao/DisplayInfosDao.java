package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.DisplayInfosDaoSqls.SELECT_COUNT;
import static kr.or.connect.reservation.dao.DisplayInfosDaoSqls.SELECT_DISPLAYINFOS;
import static kr.or.connect.reservation.service.DisplayInfosService.LIMIT;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfos;

@Repository
public class DisplayInfosDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfos> rowMapper=BeanPropertyRowMapper.newInstance(DisplayInfos.class);
	
	public DisplayInfosDao(DataSource dataSource) {
		jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<DisplayInfos> selectDisplayInfos(Integer categoryId, Integer start){
		Map<String,Integer> map=new HashMap<>();
		map.put("categoryId",categoryId);
		map.put("start",start);
		map.put("limit",LIMIT);
		return jdbc.query(SELECT_DISPLAYINFOS, map,rowMapper);
	}
	
	public int selectCount(Integer categoryId) {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(),Integer.class);
	}
}
