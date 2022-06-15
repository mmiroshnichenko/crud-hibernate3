package org.crudhibernate3.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id);
    List<T> getAll();
    T save(T item);
    T update(T item);
    void deleteById(ID id);
}
