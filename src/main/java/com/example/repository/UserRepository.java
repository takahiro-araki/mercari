package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * ユーザー情報レポジトリ.
 * 
 * @author takahiro.araki
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	
	/**
	 * ユーザー情報を登録する.
	 * @param takahiro.araki
	 */
	public void insert (User user) {
		String sql="INSERT INTO users(name,password) VALUES (:name,:password) ";
		SqlParameterSource param=new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	} 
	
	
	
}
