package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.PromotionsDaoSqls.SELECT_PROMOTIONS_INFOS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.PromotionInfos;

@Repository
public class PromotionsDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<PromotionInfos> rowMapper=BeanPropertyRowMapper.newInstance(PromotionInfos.class);
	
	public PromotionsDao(DataSource dataSource) {
		jdbc=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<PromotionInfos> selectPromotionsInfos(){
		return jdbc.query(SELECT_PROMOTIONS_INFOS, Collections.emptyMap(),rowMapper);
	}
}