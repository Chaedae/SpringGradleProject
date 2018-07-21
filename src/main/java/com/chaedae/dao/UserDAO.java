package com.chaedae.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chaedae.model.User;

@Mapper
public interface UserDAO {
	
	public User selectByUserId(User vo);
	
	public List<User> selectUserList(User vo);


}
