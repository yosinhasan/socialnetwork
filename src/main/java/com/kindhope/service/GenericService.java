package com.kindhope.service;

import java.math.BigInteger;
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
     * Adds specific object to respective table.
     *
     * @param object object
     * @return BigInteger
     */
    BigInteger create(T object);

    /**
     * Gets object from respective table by id.
     *
     * @param id object id
     * @return T object
     */
    T read(BigInteger id);

    /**
     * Updates object in respective table.
     *
     * @param object object to update
     */
    void update(T object);

    /**
     * Deletes object from respective table by id.
     *
     * @param object object id
     */
    void delete(Object object);

    /**
     * Gets all objects from table.
     *
     * @return List<T>
     */
    List<T> readAll();
}
