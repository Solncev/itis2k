package com.solncev.daos;

import java.util.List;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    List<T> getAll(int page, int pageSize);
}
