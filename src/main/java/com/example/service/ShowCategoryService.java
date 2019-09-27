package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;

/**
 * カテゴリー検索をするサービス.
 * 
 * @author takahiro.araki
 *
 */
@Service
public class ShowCategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	/**
	 * 大カテゴリーを表示する.
	 * 
	 * @return　大カテゴリー名
	 */
	public List<Category>showBigCate(){
		List<Category> categoryList=categoryRepository.showBigCate();
		return categoryList;
	}
	
	/**
	 * 大カテゴリと紐づいた中カテゴリを表示する.
	 * @param bigCate　大カテゴリ
	 * @return　中カテゴリ名
	 */
	public List<Category>showMiddleCate(String bigCate){
		List<Category> categoryList=categoryRepository.showMiddleCate(bigCate);
		return categoryList;
	}
	
	/**
	 * 大・中カテゴリと紐づいた小カテゴリを表示する.
	 * @param bigCate 大カテゴリ
	 * @param middleCate　中カテゴリ
	 * @return　小カテゴリ名
	 */
	public List<Category>showSmallCate(String bigCate,String middleCate){
		List<Category> categoryList=categoryRepository.showSmallCate(bigCate,middleCate);
		return categoryList;
	}
	
}
