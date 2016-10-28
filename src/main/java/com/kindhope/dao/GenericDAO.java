package com.kindhope.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;

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
     * @return T object
     */
    T read(BigInteger id);

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
     * @param id object id
     * @return Boolean
     */
    Boolean delete(Long id);

    /**
     * Find entity from respective table by field and value.
     *
     * @param field user field
     * @param value user value
     * @return T
     */
    T read(String field, Object value);

    /**
     * Get all objects from table.
     *
     * @return ArrayList<T>
     */
    ArrayList<T> readAll();
}
