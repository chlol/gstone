package com.chlol.gstone.dao.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlol.gstone.dao.jpa.JpaDao;
import com.chlol.gstone.dao.jpa.model.UserModel;

@Service
public class UserService {
	@Autowired
	private JpaDao<UserModel> dao;

	public void save(UserModel model) {
		dao.save(model);
		
	}

	public UserModel get(Class<UserModel> class1, String id) {
		return dao.get(class1, id);
	}
}
