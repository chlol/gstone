package com.chlol.gstone.dao.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chlol.gstone.dao.common.GenericDao;
import com.chlol.gstone.dao.common.impl.StringIdModel;

@Repository
public class JpaDao<T> implements GenericDao<T, Serializable> {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String PERSISTENCE_UNIT_NAME = "ApplicationEntityManager";
	@PersistenceContext(unitName=PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> objectClass) {
		return this.entityManager.createQuery(
                "select obj from " + objectClass.getName() + " obj")
                .getResultList();
	}

	@Override
	public T get(Class<T> objectClass, Serializable id) {
		T entity = this.entityManager.find(objectClass, id);
		return entity;
	}

	@Override
	public boolean exists(Class<T> objectClass, Serializable id) {
		T entity = this.entityManager.find(objectClass, id);
        return entity != null;
	}

	@Override
	public T save(T object) {
		if (object instanceof StringIdModel) {
    		String uuid = UUID.randomUUID().toString().replace("-", "");
    		logger.debug("uuid:" + uuid);
    		((StringIdModel) object).setId(uuid);
		}
		this.entityManager.persist(object);
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
		this.entityManager.merge(object);
		return object;
	}

	@Override
	public void updateBatch(List<T> objects) {
		for (T t : objects) {
            this.update(t);
        }	
	}

	@Override
	public void remove(T object) {
		this.entityManager.remove(entityManager.contains(object) ? object : entityManager.merge(object)); 
		
	}

	@Override
	public void removeBatch(List<T> objects) {
		for (T t : objects) {
            this.remove(t);
        }	
	}

	@Override
	public void remove(Class<T> objectClass, Serializable id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeBatchByPK(Class<T> objectClass, List<Serializable> pks) {
		throw new UnsupportedOperationException();
	}

}
