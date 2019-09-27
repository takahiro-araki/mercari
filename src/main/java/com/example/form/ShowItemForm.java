package com.example.form;

/**
 * 商品検をする際のフォーム.
 * @author takahiro.araki
 *
 */
public class ShowItemForm {
	
	/**曖昧検索の名前*/
	private String name;
	/**大カテゴリー */
	private String bigCate;
	/**中カテゴリー */
	private String middleCate;
	/**小カテゴリー */
	private String smallCate;
	/**ブランド */
	private String brand;
	
	/**ページ */
	private String page;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBigCate() {
		return bigCate;
	}
	public void setBigCate(String bigCate) {
		this.bigCate = bigCate;
	}
	public String getMiddleCate() {
		return middleCate;
	}
	public void setMiddleCate(String middleCate) {
		this.middleCate = middleCate;
	}
	public String getSmallCate() {
		return smallCate;
	}
	public void setSmallCate(String smallCate) {
		this.smallCate = smallCate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "ShowItemForm [name=" + name + ", bigCate=" + bigCate + ", middleCate=" + middleCate + ", smallCate="
				+ smallCate + ", brand=" + brand + ", page=" + page + "]";
	}
	
	
	
	
	
}
