package com.kindhope.dao;

import java.math.BigInteger;
import java.util.List;

/**
 * Generic dao.
 *
 * @param <T>
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface GenericDAO<T> {
    /**
     * Add specific object to respective table.
     *
     * @param object object
     * @return Boolean
     */
    Boolean create(T object);

    /**
     * Get object from respective table by id.
     *
     * @param id object id
     * @param tClass T class
     * @return T object
     */
    T read(Class<T> tClass, BigInteger id);

    /**
     * Update object in respective table.
     *
     * @param object object to update
     * @return Boolean
     */
    Boolean update(T object);

    /**
     * Delete object from respective table by id.
     *
     * @param object object to delete
     * @return Boolean
     */
    Boolean delete(Object object);

    /**
     * Get all objects from table.
     *
     * @return List<T>
     */
    List<T> readAll();
}
