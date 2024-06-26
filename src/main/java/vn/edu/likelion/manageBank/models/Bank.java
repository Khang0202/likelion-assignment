package vn.edu.likelion.manageBank.models;

import vn.edu.likelion.manageBank.helpers.IdHelper;
import vn.edu.likelion.manageBank.models.abstracts.Account;

import java.util.HashSet;
import java.util.Set;

public class Bank {
    private String id;
    private String bankName;
    private Set<Account> accounts;

    public Bank(String bankName) {
        this.id = IdHelper.uuid();
        this.bankName = bankName;
        this.accounts = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        try {
            return this.accounts.add(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void show(){
        System.out.println("" +
                "Bank id: " + this.id + "\n" +
                "Name: " + this.bankName + "\n" +
                "Accounts in bank: " + this.accounts.size());
    }
}
