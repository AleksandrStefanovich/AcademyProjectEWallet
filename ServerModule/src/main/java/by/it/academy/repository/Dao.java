package by.it.academy.repository;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
    void create(T t);
    T read(Class clazz, Serializable id);
    void update(T t);
    void delete(T t);
    List<T> readAll(String searchStr);
    T find(String s);
}


