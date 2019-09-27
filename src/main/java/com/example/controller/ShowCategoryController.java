package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Category;
import com.example.service.ShowCategoryService;

/**
 * カテゴリー連動をするコントローラー.
 * 
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/showCate")
public class ShowCategoryController {
	
	@Autowired
	private ShowCategoryService showCategoryService;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 大カテゴリを表示する.
	 * 
	 * @return 商品一覧ページ
	 */
	@RequestMapping("")
	public String showBigCate() {
		List<Category> bigCategoryList=showCategoryService.showBigCate();
		session.setAttribute("bigCategoryList",bigCategoryList);
		return "forward:/show";
	}
	
	/**
	 * 中カテゴリを表示する.
	 * @param model リクエストパラメーター
	 * @param bigCate　大カテゴリ
	 * @return　商品一覧ページ　
	 */
	public List<Category> showMiddleCate(Model model,String bigCate) {
		List<Category> middleCategoryList=showCategoryService.showMiddleCate(bigCate);
		//大カテを残す
		model.addAttribute("bigCate",bigCate);
		return middleCategoryList;
	}
	
	/**
	 * 小カテゴリを表示する.
	 * @param model リクエストパラメーター
	 * @param bigCate　大カテゴリ
	 * @param middleCate　中カテゴリ
	 * @return　小カテゴリー名
	 */
	public List<Category> showSmallCate(Model model,String bigCate,String middleCate) {
		List<Category> smallCategoryList=showCategoryService.showSmallCate(bigCate,middleCate);
		model.addAttribute("smallCategoryList",smallCategoryList);
		//大カテをに残す
		model.addAttribute("bigCate",bigCate);
		//中カテを残す
		model.addAttribute("middleCate",middleCate);
		return smallCategoryList;
	}
	
	
	/**
	 * 中カテのプルダウンの中身を変更する.
	 * 
	 * @param value 大カテ名
	 * @param model  
	 * @return 中カテ名
	 */
	@RequestMapping(value="/pulldown/middle/{value}",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String changeMiddlePulldown(@PathVariable("value")String value ,Model model) {
		
		//大カテゴリの名前に応じて中カテゴリの名前を詰める
		List<Category> categoryList=showMiddleCate(model,value);
		
		//JSファイルにレスポンスするJSON形式の文字列を作成する
		StringBuilder middleCate=new StringBuilder();
		middleCate.append("[");
		for (Category category:categoryList) {
			middleCate.append("{\"");
			middleCate.append("itemValue");
			middleCate.append("\"");
			middleCate.append(":");
			middleCate.append("\"");
			middleCate.append(category.getName());
			middleCate.append("\"");
			middleCate.append(",");
			middleCate.append("\"");
			middleCate.append("itemLabel");
			middleCate.append("\"");
			middleCate.append(":");
			middleCate.append("\"");
			middleCate.append(category.getName());
			middleCate.append("\"");
			middleCate.append("}");
			middleCate.append(",");
		}
		middleCate.deleteCharAt(middleCate.lastIndexOf(","));
		middleCate.append("]");
		String stringMiddleCate=middleCate.toString();
		return stringMiddleCate;
	}
	
	
	
	/**
	 * 小カテのプルダウンを変更.
	 * @param valueBigCate　大カテ名
	 * @param valueMiddleCate　中カテ名
	 * @param model
	 * @return　小カテ名
	 */
	@RequestMapping(value="/pulldown/small/{valueBigCate}/{valueMiddleCate}",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String changeSmallPulldown(@PathVariable("valueBigCate")String valueBigCate,@PathVariable("valueMiddleCate")String valueMiddleCate ,Model model) {
		
		//大カテゴリの名前に応じて中カテゴリの名前を詰める
		List<Category> categoryList=showSmallCate(model,valueBigCate,valueMiddleCate);
		
		//JSファイルにレスポンスするJSON形式の文字列を作成する
		StringBuilder smallCate=new StringBuilder();
		smallCate.append("[");
		for (Category category:categoryList) {
			smallCate.append("{\"");
			smallCate.append("itemValue");
			smallCate.append("\"");
			smallCate.append(":");
			smallCate.append("\"");
			smallCate.append(category.getName());
			smallCate.append("\"");
			smallCate.append(",");
			smallCate.append("\"");
			smallCate.append("itemLabel");
			smallCate.append("\"");
			smallCate.append(":");
			smallCate.append("\"");
			smallCate.append(category.getName());
			smallCate.append("\"");
			smallCate.append("}");
			smallCate.append(",");
		}
		smallCate.deleteCharAt(smallCate.lastIndexOf(","));
		smallCate.append("]");
		String stringMiddleCate=smallCate.toString();
		return stringMiddleCate;
	}
	
	
}
