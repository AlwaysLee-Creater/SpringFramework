package kr.or.connect.reservation.dao;

public class PromotionsDaoSqls {
	public final static String SELECT_PROMOTIONS_INFOS="select id:id a.product_id,category_id,category_name,description,file_id from (select product.id as product_id,category.id as category_id,category.name as category_name,description from category,product where category.id=product.category_id) as a,(select file_id,display_info.product_id as product_id from display_info,display_info_image where display_info.id=display_info_image.display_info_id) as b where a.product_id=b.product_id";
}
