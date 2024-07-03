package vn.edu.likelion.project.day26062024.manageBank.services;

public interface IService<T> {
    void inputOne();

    void inputMany();

    void getAll();

    T get(String id);

    T save(T t);

    boolean delete(T t);
}
