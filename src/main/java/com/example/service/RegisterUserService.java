package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.repository.UserRepository;

/**
 * ユーザー情報を登録するサービス.
 * @author takahiro.araki
 *
 */
@Service
public class RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param form ユーザー情報
 	 */
	public void insert(RegisterUserForm form) {
		User user=new User();
		BeanUtils.copyProperties(form,user);
		userRepository.insert(user);
	}
	
	
}