package com.example.controller;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserService;

/**
 * ユーザー登録をするコントローラー.
 * 
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterUserController {
	@Autowired
	private RegisterUserService registerUserService;
	
	@ModelAttribute
	public RegisterUserForm setRegisterUserForm() {
		return new RegisterUserForm();
	}
	
	/**
	 * 登録画面を表示する.
	 * @return 登録画面
	 */
	@RequestMapping("")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated RegisterUserForm form,BindingResult result) {
		if(result.hasErrors()) {
			return showRegister();
		}
		registerUserService.insert(form);
		return showRegister();
	}
}
