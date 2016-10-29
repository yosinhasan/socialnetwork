package com.kindhope.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic dao.
 *
 * @param <T>
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface GenericService<T> {
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
     * @param object object id
     * @return Boolean
     */
    Boolean delete(Object object);

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
     * @return List<T>
     */
    List<T> readAll();
}
