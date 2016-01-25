package com.chlol.gstone.dao.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chlol.gstone.dao.common.GenericDao;
import com.chlol.gstone.dao.common.GenericModel;
import com.chlol.gstone.dao.common.PageResult;
import com.chlol.gstone.dao.common.impl.StringIdModel;
import com.chlol.gstone.dao.common.utils.PageUtils;

@Repository
public class MybatisDao<T> extends SqlSessionDaoSupport implements GenericDao<T, Serializable> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<T> getAll(Class<T> objectClass) {
		return getSqlSession().selectList(
				objectClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_GET_ALL);
	}

	@Override
	public T get(Class<T> objectClass, Serializable id) {
		return getSqlSession()
				.selectOne(objectClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_GET, id);
	}

	@Override
	public boolean exists(Class<T> objectClass, Serializable id) {
		T t = get(objectClass, id);
		return t == null ? false : true;
	}

	@Override
	public T save(T object) {
		if (object instanceof StringIdModel) {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			logger.debug("uuid:" + uuid);
			((StringIdModel) object).setId(uuid);
		}
		getSqlSession().insert(
				object.getClass().getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_INSERT,
				object);
		return object;
	}

	@Override
	public void saveBatch(List<T> objects) {
		for (T t : objects) {
			this.save(t);
		}
	}

	@Override
	public T update(T object) {
		getSqlSession().update(
				object.getClass().getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_UPDATE,
				object);
		return null;
	}

	@Override
	public void updateBatch(List<T> objects) {
		for (T t : objects) {
			this.update(t);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void remove(T object) {
		Serializable parameter = null;
		if (object instanceof GenericModel) {
			parameter = ((GenericModel) object).getId();
		}
		getSqlSession().delete(
				object.getClass().getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_DELETE,
				parameter);
	}

	@Override
	public void removeBatch(List<T> objects) {
		for (T t : objects) {
			this.remove(t);
		}
	}

	@Override
	public void remove(Class<T> objectClass, Serializable id) {
		getSqlSession()
				.delete(objectClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_DELETE, id);
	}

	@Override
	public void removeBatchByPK(Class<T> objectClass, List<Serializable> pks) {
		for (Serializable pk : pks) {
			this.remove(objectClass, pk);
		}
	}

	public List<T> search(String statementId) {
		return getSqlSession().selectList(statementId);
	}

	public List<T> search(String statementId, Object parameter) {
		return getSqlSession().selectList(statementId, parameter);
	}

	private List<T> searchForPagging(String statementId, Object parameter, int offset, int size) {
		if (parameter == null) {
			return getSqlSession().selectList(statementId, new RowBounds(offset, size));
		} else {
			return getSqlSession().selectList(statementId, parameter, new RowBounds(offset, size));
		}
	}
	
	public PageResult<T> search(String statementId, int offset, int size) {
		int totalRecords = MyBatisUtils.getTotalCount(getSqlSession(), statementId,null);

		PageResult<T> pr = new PageResult<T>();
		pr.setTotalRecords(totalRecords);
		pr.setTotalPages(PageUtils.getTotalPages(totalRecords, size));
		pr.setData(this.searchForPagging(statementId,null, offset, size));
		return pr;
	}

	public PageResult<T> search(String statementId, Object parameter, int offset, int size) {
		int totalRecords = MyBatisUtils.getTotalCount(getSqlSession(), statementId, parameter);

		PageResult<T> pr = new PageResult<T>();
		pr.setTotalRecords(totalRecords);
		pr.setTotalPages(PageUtils.getTotalPages(totalRecords, size));
		pr.setData(this.searchForPagging(statementId, parameter, offset, size));
		return pr;
	}
	
	public PageResult<T> search(String statementId, Map<String, Object> parameters, int offset, int size) {
		return this.search(statementId, parameters, offset, size);
	}

	public Object searchOne(String statementId, Object parameter) {
		return getSqlSession().selectOne(statementId, parameter);
	}

	public Object update(String statementId, Object parameter) {
		return getSqlSession().update(statementId, parameter);
	}

	public Object delete(String statementId, Object parameter) {
		return getSqlSession().delete(statementId, parameter);
	}

	public Object insert(String statementId, Object parameter) {
		return getSqlSession().insert(statementId, parameter);
	}
}
