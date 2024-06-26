package vn.edu.likelion.manageBank.storage;

import vn.edu.likelion.manageBank.models.Bank;
import vn.edu.likelion.manageBank.models.abstracts.Account;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Bank> banks = new ArrayList<>();
    public static List<Account> accounts = new ArrayList<>();
}
