package com.chlol.gstone.dao.jpa;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chlol.gstone.dao.jpa.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/**/*.xml" })
public class JpaDaoTest {
	@Autowired
	private JpaDao<UserModel> dao;

	@Test
	@Transactional
	public void testSave() {
		UserModel model = new UserModel();
		model.setName("henry");
		model.setEnabled(true);

		dao.save(model);

		UserModel getModel = dao.get(UserModel.class, model.getId());

		assert model.getName().equals(getModel.getName());
		assert model.isEnabled() == getModel.isEnabled();
	}
}
