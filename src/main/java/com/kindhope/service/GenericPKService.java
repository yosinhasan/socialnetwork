package com.kindhope.service;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>.
 */
public interface GenericPKService<T, PK> {
    T read(Class<T> tClass, PK pk);

    PK save(T object);
}
