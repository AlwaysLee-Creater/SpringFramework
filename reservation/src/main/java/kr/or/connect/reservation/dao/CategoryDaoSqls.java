package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_PAGING="select id,name, (select count(category_id) from product where category_id=category.id) as count from category";
}
