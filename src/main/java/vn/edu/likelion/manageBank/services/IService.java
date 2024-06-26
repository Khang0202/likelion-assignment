package vn.edu.likelion.manageBank.services;

public interface IService<T> {
    void inputOne();
    void inputMany();
    void getAll();
    T get(String id);
    T save(T t);
    boolean delete(T t);
}
