package vn.edu.likelion.project.day19072024.service;

import vn.edu.likelion.project.day19072024.model.Users;

import java.util.List;

public interface IService<T> {
//    void inputOne();
//
//    void inputMany();

    List<T> getAll();

    T get(int id);

    boolean save(T t);

    boolean update(T t);

    boolean delete(int id);

}
