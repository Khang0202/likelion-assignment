package vn.edu.likelion.project.day26062024.manageBank.services;

import vn.edu.likelion.helpers.DoubleFormat;
import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day26062024.manageBank.Main;
import vn.edu.likelion.project.day26062024.manageBank.enums.InterestRateOf;
import vn.edu.likelion.project.day26062024.manageBank.models.NormalAccount;
import vn.edu.likelion.project.day26062024.manageBank.models.SavingAccount;
import vn.edu.likelion.project.day26062024.manageBank.storage.Storage;
import vn.edu.likelion.project.day26062024.manageBank.models.Bank;
import vn.edu.likelion.project.day26062024.manageBank.models.abstracts.Account;

public class AccountService implements IService<Account> {
    @Override
    public void inputOne() {
        try {
            Bank choiceBankBeforeAdd = choiceBankBeforeAdd();
            System.out.println("Choose account type");
            System.out.println("1: Normal account\n" +
                    "2: Saving account\n" +
                    "0: Exit");
            int choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        System.err.println("Normal account won have interest\n" +
                                "Input 0 to exit");
                        System.out.print("Input amount for normal account: ");
                        double amountN = Input.inputDouble();
                        if (amountN != 0) {
                            Account check = save(new NormalAccount(amountN));
                            if (check != null) {
                                choiceBankBeforeAdd.addAccount(check);
                                System.out.println("Account successfully created at " + check.getCreatedDate().toLocalTime() + "\n" +
                                        "Your account id is: " + check.getId());
                                break;
                            } else {
                                System.out.println("Account creation failed");
                            }
                        } else {
                            System.out.println("Exiting....");
                            break;
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        System.err.println("Saving account can not deposit or withdraw in saving time\n" +
                                "Input 0 to exit");
                        System.out.print("Input amount for saving account: ");
                        double amountS = Input.inputDouble();
                        if (amountS != 0) {
                            for (int i = 1; i < InterestRateOf.values().length; i++) {
                                System.out.println(i + ": Interest rate of " + InterestRateOf.values()[i].getMonthAmount() +
                                        " month is " + DoubleFormat.format(InterestRateOf.values()[i].getIterestRate() * 100) + "%");
                            }
                            System.out.print("Select your choice: ");
                            int choice2 = Input.inputInt();
                            if (choice2 > 0 && choice2 < InterestRateOf.values().length) {
                                System.out.println("your choice is " + InterestRateOf.values()[choice2].getMonthAmount() + " month");
                                Account check = save(new SavingAccount(amountS, InterestRateOf.values()[choice2]));
                                if (check != null) {
                                    choiceBankBeforeAdd.addAccount(check);
                                    System.out.println("Account successfully created at " + check.getCreatedDate().toLocalTime() + "\n" +
                                            "Your account id is: " + check.getId());
                                } else {
                                    System.out.println("Account creation failed");
                                }
                            } else {
                                System.out.println("Error input, exiting....");
                            }
                        } else {
                            System.out.println("Exiting....");
                        }
                        break;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                default:
                    System.err.println("Error input, exiting....");
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void inputMany() {
        try {
            System.out.print("Input number of accounts you want to create: ");
            int n = Input.inputInt();
            for (int i = 0; i < n; i++) {
                inputOne();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void getAll() {
        for (Account a : Storage.accounts) {
            a.show();
            System.out.println("----------------------------------------------");
        }
    }

    @Override
    public Account get(String id) {
        for (Account a : Storage.accounts) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        throw new RuntimeException("Account with " + id + " does not exist!");
    }

    @Override
    public Account save(Account account) {
        try {
            Storage.accounts.add(account);
            return account;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create account", e);
        }
    }

    @Override
    public boolean delete(Account account) {
        try {
            if (Storage.accounts.contains(account)) {
                return Storage.accounts.remove(account);
            } else {
                throw new RuntimeException("Account with " + account.getId() + " does not exist!");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        } finally {
            return false;
        }
    }

    public Bank choiceBankBeforeAdd() {
        Main.bankService.getAll();
        System.out.println("Input a bank id you want for creating account");
        return Main.bankService.get(Input.inputString());
    }
}
