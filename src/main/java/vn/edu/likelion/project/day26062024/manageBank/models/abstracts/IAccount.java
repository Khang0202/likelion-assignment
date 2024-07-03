package vn.edu.likelion.project.day26062024.manageBank.models.abstracts;

public interface IAccount {
    void show();

    void deposit(double amount);

    void withdraw(double amount);

    void withdrawAll();

    double calculateInterestRate(int month);
}
