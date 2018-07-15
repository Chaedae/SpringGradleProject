package com.chaedae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaedae.dao.UserDAO;
import com.chaedae.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public User selectByUserId(User vo) {
		return userDAO.selectByUserId(vo);
	}
	
	public List<User> selectList(User vo) {
		return userDAO.selectList(vo);
	}
	
	
}
