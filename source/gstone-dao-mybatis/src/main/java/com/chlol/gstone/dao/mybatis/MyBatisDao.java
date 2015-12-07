package com.chlol.gstone.dao.mybatis;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chlol.gstone.dao.common.GenericDao;

@Repository
public class MyBatisDao<T> extends SqlSessionDaoSupport implements GenericDao<T, Serializable> {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	Class<T> tClass;

	@SuppressWarnings("unchecked")
	public MyBatisDao() {
		super();
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		tClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public MyBatisDao(Class<T> tClass) {
		this.tClass = tClass;
	}

	@Override
	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<T> getAll() {
		return getSqlSession()
				.selectList(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_GET_ALL);
	}

	@Override
	public T get(Serializable id) {
		return getSqlSession()
				.selectOne(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_GET, id);
	}

	@Override
	public T get(Class<T> objectClass, Serializable id) {
		return getSqlSession()
				.selectOne(objectClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_GET, id);
	}

	@Override
	public boolean exists(Serializable id) {
		T t = get(id);
		return t == null ? false : true;
	}

	@Override
	public T save(T object) {
		getSqlSession().insert(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_INSERT, object);
		return null;
	}

	@Override
	public void saveBatch(List<T> objects) {
		for (T t : objects) {
			this.save(t);
		}
	}

	@Override
	public T update(T object) {
		getSqlSession().update(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_UPDATE, object);
		return null;
	}

	@Override
	public void updateBatch(List<T> objects) {
		for (T t : objects) {
			this.update(t);
		}
	}

	@Override
	public void remove(T object) {
		getSqlSession().delete(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_REMOVE, object);
	}

	@Override
	public void removeBatch(List<T> objects) {
		for (T t : objects) {
			this.remove(t);
		}
	}

	@Override
	public void remove(Serializable id) {
		getSqlSession().delete(tClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_REMOVE, id);
	}

	@Override
	public void removeBatchByPK(List<Serializable> pks) {
		for (Serializable pk : pks) {
			this.remove(pk);
		}
	}
}
