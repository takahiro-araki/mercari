package com.example.domain;

/**
 * 商品情報ドメイン.
 * @author takahiro.araki
 *
 */
public class Item {
	
	/**ID */
	private Integer id;
	/**名前 */
	private String name;
	/**コンディション */
	private Integer condition;
	/**カテゴリーID*/
	private Integer categoryId;
	/**ブランド */
	private String brand;
	/**値段 */
	private Double price;
	/**送付方法 */
	private Integer shipping;
	/**説明 */
	private String description;
	/**カテゴリードメイン */
	private Category category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getShipping() {
		return shipping;
	}
	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", condition=" + condition + ", categoryId=" + categoryId
				+ ", brand=" + brand + ", price=" + price + ", shipping=" + shipping + ", description=" + description
				+ ", category=" + category + "]";
	}
	
	
}