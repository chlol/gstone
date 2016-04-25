package com.lnngle.gstone.dao.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lnngle.gstone.dao.common.GenericDao;
import com.lnngle.gstone.dao.common.PageResult;
import com.lnngle.gstone.dao.common.impl.StringIdModel;
import com.lnngle.gstone.dao.common.utils.PageUtils;

@Component
public class JpaDao<T> implements GenericDao<T, Serializable> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String PERSISTENCE_UNIT_NAME = "ApplicationEntityManager";

	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> objectClass) {
		return this.entityManager.createQuery("select obj from " + objectClass.getName() + " obj").getResultList();
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
	
	@SuppressWarnings("unchecked")
	public List<T> search(String queryName) {
		Query query = this.entityManager.createNamedQuery(queryName);

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> search(String queryName,Object parameter) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> search(String queryName,Object parameter1,Object parameter2) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter1);
		query.setParameter(2, parameter2);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> search(String queryName,Object parameter1,Object parameter2,Object parameter3) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter1);
		query.setParameter(2, parameter2);
		query.setParameter(3, parameter3);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> search(String queryName, Map<String, Object> parameters) {
		Query query = this.entityManager.createNamedQuery(queryName);
		if (parameters != null) {
			Set<Entry<String, Object>> entrySet = parameters.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return query.getResultList();
	}

	public PageResult<T> search(String queryName, int offset, int size) {
		Query query = this.entityManager.createNamedQuery(queryName);

		return toPagging(query, offset, size);
	}
	
	public PageResult<T> search(String queryName,Object parameter, int offset, int size) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter);
		return toPagging(query, offset, size);
	}
	
	public PageResult<T> search(String queryName,Object parameter1,Object parameter2, int offset, int size) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter1);
		query.setParameter(2, parameter2);
		return toPagging(query, offset, size);
	}
	
	public PageResult<T> search(String queryName,Object parameter1,Object parameter2,Object parameter3, int offset, int size) {
		Query query = this.entityManager.createNamedQuery(queryName);
		query.setParameter(1, parameter1);
		query.setParameter(2, parameter2);
		query.setParameter(3, parameter3);
		return toPagging(query, offset, size);
	}

	public PageResult<T> search(String queryName, Map<String, Object> parameters, int offset, int size) {
		Query query = this.entityManager.createNamedQuery(queryName);
		if (parameters != null) {
			Set<Entry<String, Object>> entrySet = parameters.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return toPagging(query, offset, size);
	}

	private PageResult<T> toPagging(Query query, int offset, int size) {
		int totalRecords = query.getResultList().size();
		if (offset >= 0 && size > 0) {
			query.setFirstResult(offset);
			query.setMaxResults(size);
		}
		@SuppressWarnings("unchecked")
		List<T> resultList = query.getResultList();

		PageResult<T> pr = new PageResult<T>();
		pr.setTotalRecords(totalRecords);
		pr.setTotalPages(PageUtils.getTotalPages(totalRecords, size));
		pr.setData(resultList);

		return pr;
	}

}
