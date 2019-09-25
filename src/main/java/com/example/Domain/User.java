package com.example.domain;

/**
 * ユーザー情報のドメイン.
 * 
 * @author takahiro.araki
 *
 */
public class User {
	
	/**ID */
	private Integer id;
	/**名前 */
	private String name;
	/**パスワー	ド */
	private String password;
	/**ユーザー権限 */
	private String authority;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", authority=" + authority + "]";
	}
	
	
	
	
	
}
