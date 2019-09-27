package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.ShowItemForm;
import com.example.service.ShowItemService;

/**
 * 商品一覧を表示するコントローラー.
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/show")
public class ShowItemController {
	
	@Autowired
	private ShowItemService showItemService;
	
	
	
	private static final Integer LIMIT=30;
	
	/**
	 * 商品一覧を表示する.
	 * @param page ページ数
	 * @param LIMIT　表示する商品数
	 * @param model　リクエストパラメータ
	 * @return
	 */
	@RequestMapping("")
	public String showItem(ShowItemForm form,Model model) {
		//初めにページを表示するときにページと名前と大中小カテをセット
		if(form.getPage()==null) {
			form.setPage("1");
		}
		if(form.getName()==null) {
			form.setName("");
		}
		if(form.getBigCate()==null) {
			form.setBigCate("%");
		}
		if(form.getMiddleCate()==null) {
			form.setMiddleCate("%");
		}
		if(form.getSmallCate()==null) {
			form.setSmallCate("%");
		}
		
		
		Integer intPage= Integer.parseInt(form.getPage());
		Integer startPoint=(intPage-1)*LIMIT;
		List<Item> itemList=showItemService.showItem(startPoint, LIMIT,form.getName(),form.getBigCate(),form.getMiddleCate(),form.getSmallCate());
		model.addAttribute("itemList",itemList);
		
		
		return "list";
	}
	
	
	
	
}