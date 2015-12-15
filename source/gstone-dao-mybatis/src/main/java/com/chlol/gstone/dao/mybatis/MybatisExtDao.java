package com.chlol.gstone.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisExtDao extends SqlSessionDaoSupport {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Resource(name = "sqlSessionTemplate")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@SuppressWarnings("rawtypes")
	public List search(final String statementId) {
		return getSqlSession().selectList(statementId);
	}
	
	@SuppressWarnings("rawtypes")
	public List search(final String statementId,final Object parameter) {
		return getSqlSession().selectList(statementId, parameter);
	}

	@SuppressWarnings("rawtypes")
	public List search(final String statementId,final Object parameter, final int offset, final int size) {
		return getSqlSession().selectList(statementId, parameter, new RowBounds(offset, size));
	}
	
	public Object[] searchForPagging(final String statementId,final Object parameter, final int offset, final int size) {
		Object[] result = new Object[2];
		result[0] = this.search(statementId, parameter, offset, size);
		result[1] = MyBatisUtils.getTotalCount(getSqlSession(), statementId, parameter);
		return result;
	}
	
	public Object searchOne(final String statementId,final Object parameter) {
		return getSqlSession().selectOne(statementId, parameter);
	}
	
	public Object update(final String statementId,final Object parameter) {
		return getSqlSession().update(statementId, parameter);
	}
	
	public Object delete(final String statementId,final Object parameter) {
		return getSqlSession().delete(statementId, parameter);
	}
	
	public Object insert(final String statementId,final Object parameter) {
		return getSqlSession().insert(statementId, parameter);
	}
}
