package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * アイテム詳細画面を表示.
 * @author takahiro.araki
 *
 */
@Service
public class ShowDetailService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * アイテムの詳細情報を表示する.
	 * @param id 主キー
	 * @return　アイテム情報
	 */
	public Item load(String id) {
		Item item =itemRepository.load(Integer.parseInt(id));
		return item;
	}
	
}
