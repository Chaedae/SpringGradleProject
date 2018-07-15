package com.chaedae.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chaedae.model.User;

@Repository
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User selectByUserId(User vo) {
		return this.sessionFactory.getCurrentSession().get(User.class, vo.getUserId());
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> selectList(User vo) {
		return this.sessionFactory.getCurrentSession().createQuery("FROM TB_USER").list(); 
	}


}
