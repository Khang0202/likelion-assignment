package vn.edu.likelion.manageBank.models.abstracts;

public interface IAccount {
    void show();
    void deposit(double amount);
    void withdraw(double amount);
    void withdrawAll();
    double calculateInterestRate(int month);
}
