package com.chlol.gstone.dao.common;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 *
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 */
	T get(PK id);

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
	 * @param id
	 *            the id of the entity
	 * @return - true if it exists, false if it doesn't
	 */
	boolean exists(PK id);

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
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */
	void remove(PK id);

	/**
	 * remove one or more objects by pk
	 * 
	 * @param pks
	 */
	void removeBatchByPK(List<PK> pks);

}
