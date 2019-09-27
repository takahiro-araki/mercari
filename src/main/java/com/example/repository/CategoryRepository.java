package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;

/**
 * カテゴリテーブルを操作するレポジトリ.
 * @author takahiro.araki
 *
 */
@Repository
public class CategoryRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public final static RowMapper<Category>CATEGORY_ROW_MAPPER=(rs,i)->{
		Category category=new Category();
		category.setId(rs.getInt("id"));
		category.setParent(rs.getInt("parent"));
		category.setName(rs.getString("name"));
		category.setNameAll(rs.getString("name_all"));
		return category;
	};
	
	/**
	 * 
	 * 検索欄のカテゴリー名を抽出するためのロウマッパ―.
	 */
	public final static RowMapper<Category>CATEGORY_NAME_ROW_MAPPER=(rs,i)->{
		Category category=new Category();
		category.setName(rs.getString("cateName"));
		return category;
	};
	
	
	/**
	 * 大カテゴリ名を取得する.
	 * 
	 * @return 大カテゴリ名
	 */
	public List<Category>showBigCate(){
		String sql="select split_part(name_all,'/',1) as cateName from category where name_all is not null group by cateName order by cateName;";
		List<Category> categoryList=template.query(sql,CATEGORY_NAME_ROW_MAPPER);
		return categoryList;
	}
	
	/**
	 * 大カテに紐づいた、中カテゴリ名を取得する.
	 * @param bigCate 大カテゴリ名
	 * @return　中カテゴリ名リスト
	 */
	public List<Category>showMiddleCate(String bigCate){
		StringBuilder sql= new StringBuilder();
		sql.append("select split_part(name_all,'/',2) as cateName ");
		sql.append("from category where name_all LIKE :bigCate  group by cateName order by cateName");
		SqlParameterSource param= new MapSqlParameterSource().addValue("bigCate",bigCate+"%");
		List<Category> categoryList=template.query(sql.toString(), param,CATEGORY_NAME_ROW_MAPPER);
		return categoryList;
	}
	
	/**
	 * 大カテと中カテに紐づいた、小カテゴリ名を取得する.
	 * @param bigCate 大カテ
	 * @param middleCate　中カテ
	 * @return　小カテゴリ名リスト
	 */
	public List<Category>showSmallCate(String bigCate,String middleCate){
		StringBuilder sql= new StringBuilder();
		sql.append("select split_part(name_all,'/',3) as cateName ");
		sql.append("from category where name_all LIKE :bigCate||:middleCate  group by cateName order by cateName");
		SqlParameterSource param=new MapSqlParameterSource().addValue("bigCate",bigCate+"/").addValue("middleCate",middleCate+"%");
		List<Category>categoryList=template.query(sql.toString(),param,CATEGORY_NAME_ROW_MAPPER);
		return categoryList;
	}
	
	
	
}
