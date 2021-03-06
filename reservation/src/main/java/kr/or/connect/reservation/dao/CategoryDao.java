package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CategoryDaoSqls.SELECT_PAGING;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper <Category> rowMapper=BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDao(DataSource dataSource) {
		jdbc=new NamedParameterJdbcTemplate(dataSource);
		insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Category> selesctAll(){
		return jdbc.query(SELECT_PAGING, Collections.emptyMap(),rowMapper);
	}
}
