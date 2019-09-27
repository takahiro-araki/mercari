package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;
import com.example.domain.Item;

/**
 * アイテム一覧表示をする.
 * 
 * @author takahiro.araki
 *
 */
@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("i_id"));
		item.setName(rs.getString("i_name"));
		item.setCondition(rs.getInt("i_condition"));
		item.setCategoryId(rs.getInt("i_category"));
		item.setBrand(rs.getString("i_brand"));
		item.setPrice(rs.getDouble("i_price"));
		item.setShipping(rs.getInt("i_shipping"));
		item.setDescription(rs.getString("i_description"));
		Category category = new Category();
		category.setId(rs.getInt("c_id"));
		category.setName(rs.getString("c_name"));
		category.setNameAll(rs.getString("c_name_all"));
		category.setParent(rs.getInt("c_parent"));
		item.setCategory(category);
		return item;
	};

	/**
	 * 商品一覧を表示する.
	 * 
	 * @param page  ページ数
	 * @param LIMIT 表示する商品数
	 * @return 商品情報
	 */
	public List<Item> showAll(Integer startPoint, Integer LIMIT, String name, String bigCate, String middleCate,
			String smallCate) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT i.id as i_id,i.name as i_name,i.condition as i_condition,i.category as i_category,i.brand as i_brand,");
		sql.append(
				"i.price as i_price,i.shipping as i_shipping,i.description as i_description,c.id as c_id,c.parent as c_parent, c.name as c_name,c.name_all as c_name_all");
		sql.append(
				" from items i LEFT OUTER JOIN  category c ON i.category=c.id where c.name_all LIKE :bigCate || :middleCate || :smallCate||'%' AND i.name LIKE :name ORDER BY i_id LIMIT :LIMIT OFFSET :startPoint ;");
		SqlParameterSource param = new MapSqlParameterSource().addValue("LIMIT", LIMIT)
				.addValue("startPoint", startPoint).addValue("name", "%" + name + "%")
				.addValue("bigCate", bigCate+"/").addValue("middleCate", middleCate+"/").addValue("smallCate", smallCate);
		List<Item> itemList = template.query(sql.toString(), param, ITEM_ROW_MAPPER);
		return itemList;
	}
	
	/**
	 * アイテムを主キー検索する.
	 * @param id 主キー
	 * @return　アイテム情報
	 */
	public Item load(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT i.id as i_id,i.name as i_name,i.condition as i_condition,i.category as i_category,i.brand as i_brand,");
		sql.append(
				"i.price as i_price,i.shipping as i_shipping,i.description as i_description,c.id as c_id,c.parent as c_parent, c.name as c_name,c.name_all as c_name_all");
		sql.append(
				" from items i LEFT OUTER JOIN  category c ON i.category=c.id where i.id=:id;");
		SqlParameterSource param=new MapSqlParameterSource().addValue("id",id);
		Item item=template.queryForObject(sql.toString(), param, ITEM_ROW_MAPPER);
		return item;
	}
	
//	public Integer countItem() {
//		StringBuilder sql=new StringBuilder();
//		sql.append("select count(*) from items i LEFT OUTER JOIN  category c ON i.category=c.id ");
//		Integer count =template.queryForList(sql);
//		
//	}
	
	

}