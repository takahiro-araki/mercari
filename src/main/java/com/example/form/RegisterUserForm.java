package com.example.form;

import javax.validation.constraints.NotBlank;

/**
 * ユーザーフォーム.
 * 
 * @author takahiro.araki
 *
 */
public class RegisterUserForm {
	
	/**名前 */
	@NotBlank(message = "名前は必須です。")
	private String name;
	/**パスワード */
	@NotBlank(message = "パスワードは必須です。")
	private String password;
	
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
	@Override
	public String toString() {
		return "RegisterUserForm [name=" + name + ", password=" + password + "]";
	}
	
	
	
}
