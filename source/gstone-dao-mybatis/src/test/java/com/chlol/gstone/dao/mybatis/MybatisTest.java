package com.chlol.gstone.dao.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chlol.gstone.dao.mybatis.model.TestTable1Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/**/*.xml" })
public class MybatisTest {
	@Autowired
	private MybatisDao<TestTable1Model> dao;
	
	@Test
	public void testSave() {
		TestTable1Model model = new TestTable1Model();
		model.setName("henry");
		model.setAge(8);
		
		dao.save(model);
		
		TestTable1Model getModel = dao.get(TestTable1Model.class,model.getId());
		
		assert model.getName().equals(getModel.getName());
		assert model.getAge().equals(getModel.getAge());
	}

}
