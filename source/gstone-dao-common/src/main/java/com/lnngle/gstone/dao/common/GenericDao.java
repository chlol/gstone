package com.lnngle.gstone.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, PK extends Serializable> {
	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @param objectClass
	 * @return List of populated objects
	 */
	List<T> getAll(Class<T> objectClass);

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param objectClass
	 * @param id
	 * @return a populated object
	 */
	T get(Class<T> objectClass, PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param objectClass
	 * @param id
	 *            the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(Class<T> objectClass, PK id);

	/**
	 * Generic method to save an object
	 * 
	 * @param object
	 *            the object to save
	 * @return the persisted object
	 */
	T save(T object);

	/**
	 * Persist one or more objects
	 * 
	 * @param objects
	 */
	void saveBatch(List<T> objects);

	/**
	 * Generic method to update an object
	 * 
	 * @param object
	 *            the object to save
	 * @return the persisted object
	 */
	T update(T object);

	/**
	 * Update one or more objects
	 * 
	 * @param objects
	 */
	void updateBatch(List<T> objects);

	/**
	 * Generic method to delete an object
	 * 
	 * @param object
	 *            the object to remove
	 */
	void remove(T object);

	/**
	 * remove one or more objects
	 * 
	 * @param objects
	 */
	void removeBatch(List<T> objects);

	/**
	 * Generic method to delete an object
	 * 
	 * @param objectClass
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(Class<T> objectClass, PK id);

	/**
	 * remove one or more objects by pk
	 * 
	 * @param pks
	 */
	void removeBatchByPK(Class<T> objectClass, List<PK> pks);
	
	/**
	 * search by query statement
	 * @param identifier the query statement identifier
	 * @return
	 */
	public List<T> search(String identifier);
	
	/**
	 * search by query statement
	 * @param identifier
	 * @param parameter
	 * @return
	 */
	public List<T> search(String identifier, Object parameter);
	
	/**
	 * search by query statement for pagging
	 * @param identifier the query statement identifier
	 * @param offset 
	 * @param size
	 * @return
	 */
	public PageResult<T> search(String identifier, int offset, int size);
	
	/**
	 * search by query statement for pagging
	 * @param identifier the query statement identifier
	 * @param parameter
	 * @param offset
	 * @param size
	 * @return
	 */
	public PageResult<T> search(String identifier, Object parameter, int offset, int size);
	
	/**
	 * search by query statement for pagging
	 * @param identifier the query statement identifier
	 * @param parameters
	 * @param offset
	 * @param size
	 * @return
	 */
	public PageResult<T> search(String identifier, Map<String, Object> parameters, int offset, int size);

}
