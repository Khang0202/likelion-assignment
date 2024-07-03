package vn.edu.likelion.generic;

import java.util.List;

public interface IGenericService<T> {
    void inputConsole();

    void inputConsoleMany();

    List<T> findAll();

    T findOne(String id);

    T insert(T t);

    boolean delete(String id);
}
