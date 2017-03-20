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
     * Adds specific object to respective table.
     *
     * @param object object
     * @return BigInteger
     */
    BigInteger create(T object);

    /**
     * Gets object from respective table by id.
     *
     * @param id     object id
     * @param tClass T class
     * @return T object
     */
    T read(Class<T> tClass, BigInteger id);

    /**
     * Updates object in respective table.
     *
     * @param object object to update
     * @return Boolean
     */
    void update(T object);

    /**
     * Deletes object from respective table by id.
     *
     * @param object object to delete
     * @return Boolean
     */
    void delete(Object object);

    /**
     * Gets all objects from table.
     *
     * @return List<T>
     */
    List<T> readAll();
}
