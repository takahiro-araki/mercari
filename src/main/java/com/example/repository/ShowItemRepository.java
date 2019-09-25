package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;
import com.example.domain.Item;

/**
 * アイテム一覧表示をする.
 * @author takahiro.araki
 *
 */
@Repository
public class ShowItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public final static RowMapper<Item>ITEM_ROW_MAPPER=(rs,i)->{
		Item item= new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setCondition(rs.getInt("condition"));
		item.setCategoryId(rs.getInt("category"));
		item.setBrand(rs.getString("brand"));
		item.setPrice(rs.getDouble("price"));
		item.setShipping(rs.getInt("shipping"));
		item.setDescription(rs.getString("description"));
		Category category=new Category();
		
	};
	
}