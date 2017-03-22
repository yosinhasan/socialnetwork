package com.kindhope.dao;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
public interface GenericPKDAO<T, PK> {
    T read(Class<T> tClass, PK pk);

    PK save(T object);
}
