package com.chlol.gstone.dao.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chlol.gstone.dao.common.GenericDao;
import com.chlol.gstone.dao.common.GenericModel;
import com.chlol.gstone.dao.common.impl.StringIdModel;

@Repository
public class MybatisDao<T> extends SqlSessionDaoSupport implements GenericDao<T, Serializable> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public boolean exists(Class<T> objectClass,Serializable id) {
        T t = get(objectClass,id);
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
    public void remove(Class<T> objectClass,Serializable id) {
        getSqlSession().delete(
        		objectClass.getName() + MybatisConstants.SYMBOL_DOT + MybatisConstants.EXECUTE_TYPE_DELETE, id);
    }

    @Override
    public void removeBatchByPK(Class<T> objectClass,List<Serializable> pks) {
        for (Serializable pk : pks) {
            this.remove(objectClass,pk);
        }
    }
}
