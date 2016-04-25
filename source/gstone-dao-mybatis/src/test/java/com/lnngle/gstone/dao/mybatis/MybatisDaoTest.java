package com.lnngle.gstone.dao.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lnngle.gstone.dao.mybatis.model.TestTable1Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/**/*.xml" })
public class MybatisDaoTest {
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
	
	@Test
	public void testUpdate() {
		TestTable1Model model = new TestTable1Model();
		model.setName("henry");
		model.setAge(8);
		
		dao.save(model);
		
		model.setAge(9);
		
		dao.update(model);
		
		TestTable1Model getModel = dao.get(TestTable1Model.class,model.getId());
		
		assert model.getName().equals(getModel.getName());
		assert getModel.getAge() == 9;
	}
	
	@Test
	public void testRemove() {
		TestTable1Model model = new TestTable1Model();
		model.setName("henry");
		model.setAge(8);
		
		dao.save(model);
		
		TestTable1Model getModel = dao.get(TestTable1Model.class,model.getId());
		
		assert model.getName().equals(getModel.getName());
		assert model.getAge() == getModel.getAge();
		
		dao.remove(TestTable1Model.class,model.getId());
		TestTable1Model removeModel = dao.get(TestTable1Model.class,model.getId());
		assert removeModel == null;
	}
	
	@Test
	public void testExist() {
		TestTable1Model model = new TestTable1Model();
		model.setName("henry");
		model.setAge(8);
		
		dao.save(model);
		
		boolean exists = dao.exists(TestTable1Model.class,model.getId());
		assert exists == true;
		
		dao.remove(TestTable1Model.class,model.getId());
		exists = dao.exists(TestTable1Model.class,model.getId());
		assert exists == false;
	}
	
	@Test
	public void testGetAll() {
		TestTable1Model model = new TestTable1Model();
		model.setName("henry");
		model.setAge(8);
		
		dao.save(model);
		
		List<TestTable1Model> all = dao.getAll(TestTable1Model.class);
		
		assert all.size() >= 1;
	}

}
