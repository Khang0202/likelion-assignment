package vn.edu.likelion.project.day26062024.manageBank.models.abstracts;

import vn.edu.likelion.helpers.DoubleFormat;
import vn.edu.likelion.helpers.IdHelper;
import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day26062024.manageBank.enums.InterestRateOf;

import java.time.LocalDateTime;

public class Account implements IAccount {
    private String id;
    private double balance;
    private InterestRateOf interestRateOf;
    private LocalDateTime createdDate;
    private double overdraftLimit;
    private LocalDateTime updatedDate;
    private boolean isAllowDeposit;
    private boolean isAllowWithdraw;
    private boolean isAllowWithdrawAll;

    public Account() {
    }

    public Account(double balance) {
        this.id = IdHelper.uuid();
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new RuntimeException("Balance cannot be negative");
        }
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
        this.isAllowDeposit = false;
        this.isAllowWithdraw = false;
        this.isAllowWithdrawAll = false;
        this.overdraftLimit = 1000;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public InterestRateOf getInterestRateOf() {
        return interestRateOf;
    }

    public void setInterestRateOf(InterestRateOf interestRateOf) {
        this.interestRateOf = interestRateOf;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean isAllowDeposit() {
        return isAllowDeposit;
    }

    public void setAllowDeposit(boolean allowDeposit) {
        isAllowDeposit = allowDeposit;
    }

    public boolean isAllowWithdraw() {
        return isAllowWithdraw;
    }

    public void setAllowWithdraw(boolean allowWithdraw) {
        isAllowWithdraw = allowWithdraw;
    }

    public boolean isAllowWithdrawal() {
        return isAllowWithdrawAll;
    }

    public void setAllowWithdrawal(boolean allowWithdrawal) {
        isAllowWithdrawAll = allowWithdrawal;
    }

    @Override
    public void show() {
        System.out.println("Account balance: $" + this.balance +
                "\nInterest Rate: " + DoubleFormat.format(this.interestRateOf.getIterestRate() * 100) + "%\n" +
                "Created Date: " + this.createdDate.toLocalDate() + "\n" +
                "Overdraft Limit: $" + this.overdraftLimit + "\n" +
                "Last Updated: " + this.updatedDate.toLocalDate() + " at " + this.updatedDate.toLocalTime());
    }

    @Override
    public void deposit(double amount) {
        if (isAllowDeposit) {
            if (amount > 0) {
                this.updatedDate = LocalDateTime.now();
                this.balance += amount;
            } else {
                throw new RuntimeException("Amount need to more than 0");
            }
        } else {
            throw new RuntimeException("This account not allowed to deposit");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (isAllowWithdraw) {
            if (amount > 0) {
                if (amount > this.overdraftLimit) {
                    if (this.balance >= amount) {
                        this.updatedDate = LocalDateTime.now();
                        this.balance -= amount;
                    } else {
                        throw new RuntimeException("Amount more than your account balance, can not withdraw");
                    }
                } else {
                    throw new RuntimeException("You can not withdraw more than your account overdraft limit");
                }
            } else {
                throw new RuntimeException("Amount need to more than 0");
            }
        } else {
            throw new RuntimeException("This account not allowed to withdraw");
        }
    }

    @Override
    public void withdrawAll() {
        String acceptKey = IdHelper.uuid();
        System.out.println("Your accept key: " + acceptKey);
        System.out.print("Please enter the key to accept withdraw all: ");
        if (acceptKey.equals(Input.inputString())) {
            this.isAllowWithdrawAll = true;
            this.updatedDate = LocalDateTime.now();
            if (isAllowWithdraw) {
                this.balance -= this.balance;
            } else {
                throw new RuntimeException("Wrong key,You can not withdraw all right now");
            }
        } else {
            throw new RuntimeException("This account not allowed to withdraw all");
        }
    }

    @Override
    public double calculateInterestRate(int month) {
        if (month > interestRateOf.getMonthAmount()) {
            double interestAmount = 0;
            int months = month / interestRateOf.getMonthAmount();
            for (int i = 1; i <= months; i++) {
                if (i == 1) {
                    interestAmount += this.balance * interestRateOf.getIterestRate() + this.balance;
                } else {
                    interestAmount += interestAmount * interestRateOf.getIterestRate();
                }
            }
            return interestAmount;
        } else {
            throw new RuntimeException("Amount need at least 3 month");
        }
    }
}
