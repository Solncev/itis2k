package com.solncev.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    void save (T t);
}
