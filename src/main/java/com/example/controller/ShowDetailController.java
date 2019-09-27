package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowDetailService;

/**
 * アイテム詳細画面を表示するコントローラー.
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/detail")
public class ShowDetailController {
	
	@Autowired
	private ShowDetailService showDetailService;
	
	/**
	 * アイテム詳細を主キー検索する.
	 * @param id　
	 * @return　アイテム詳細画面
	 */
	@RequestMapping("")
	public String load(String id,Model model) {
		Item item=showDetailService.load(id);
		model.addAttribute("item",item);
		return "detail";
	}

}
