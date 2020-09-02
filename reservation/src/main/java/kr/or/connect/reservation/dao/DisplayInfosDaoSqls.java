package kr.or.connect.reservation.dao;

public class DisplayInfosDaoSqls {
	public final static String SELECT_DISPLAYINFOS=
			"select display_info_id as id,category_id,display_info_id,name,description,content,event,opening_hours,place_name,place_lot,place_street,tel,homepage,email,create_date,modify_date,file_id"
			+"from (select category.id as category_id,product.id as product_id,category.name as name,description,content,event from category,product where category.id=product.category_id) as a"
			+",(select display_info.product_id as product_id,display_info_id,opening_hours,place_name,place_lot,place_street,tel,homepage,email,file_id,create_date,modify_date from display_info,display_info_image where display_info.id=display_info_image.display_info_id) as b"
			+"where a.product_id=b.product_id and a.category_id=:categoryId limit :start, :limit";
	public final static String SELECT_COUNT="select count(*) from product where category_id=:categoryId";
}

