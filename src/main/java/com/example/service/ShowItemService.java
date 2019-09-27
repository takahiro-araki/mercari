package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品一覧を表示するサービス.
 * @author takahiro.araki
 *
 */
@Service
public class ShowItemService {
	
	@Autowired
	private ItemRepository showItemRepository;
	
	/**
	 * 商品一覧を表示する.
	 * @param page ページ数
	 * @param LIMIT　表示する商品数
	 * @return　表示する商品データ
	 */
	public List<Item> showItem(Integer startPoint,Integer LIMIT,String name,String bigCate,String middleCate,String smallCate){
		
		List<Item> itemList=showItemRepository.showAll(startPoint, LIMIT,name,bigCate,middleCate,smallCate);
		return itemList;
	}
	
}