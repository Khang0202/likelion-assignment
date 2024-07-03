package vn.edu.likelion.project.day26062024.manageBank;

import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day26062024.manageBank.models.NormalAccount;
import vn.edu.likelion.project.day26062024.manageBank.models.SavingAccount;
import vn.edu.likelion.project.day26062024.manageBank.storage.Storage;
import vn.edu.likelion.project.day26062024.manageBank.enums.InterestRateOf;
import vn.edu.likelion.project.day26062024.manageBank.models.Bank;
import vn.edu.likelion.project.day26062024.manageBank.models.abstracts.Account;
import vn.edu.likelion.project.day26062024.manageBank.services.AccountService;
import vn.edu.likelion.project.day26062024.manageBank.services.BankService;

public class Main {
    public static AccountService accountService = new AccountService();
    public static BankService bankService = new BankService();

    public static void main(String[] args) {
        do {
            System.out.println("Input a number to start");
            int start = Input.inputInt();
            if (start == 0) {
                break;
            }
            System.out.println("1: With sample data\n" +
                    "2: Input data");
            switch (Input.inputInt()) {
                case 1:
                    bankService.save(new Bank("VCB"));
                    Bank b = Storage.banks.get(0);
                    b.addAccount(accountService.save(
                            new SavingAccount(12000, InterestRateOf.THREE_MONTH)));
                    b.addAccount(accountService.save(
                            new NormalAccount(10000)));
                    b.addAccount(accountService.save(
                            new SavingAccount(20000, InterestRateOf.NINE_MONTH)
                    ));
                    switchCaseManageData();
                    break;
                case 2:
                    bankService.inputOne();
                    Bank b2 = Storage.banks.get(0);
                    accountService.inputMany();
                    for (Account a : Storage.accounts) {
                        b2.addAccount(a);
                    }
                    switchCaseManageData();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error input, Exit...");
                    break;
            }
        } while (true);
    }

    public static void switchCaseManageData() {
        int choice;
        do {
            System.err.println(
                    "Manage\n" +
                            "1: Manage Bank\n" +
                            "2: Manage Account\n" +
                            "3: List Bank\n" +
                            "4: List Account\n" +
                            "5: Add 1 bank\n" +
                            "6: Add 1 account\n" +
                            "0: Exits");
            choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    try {
                        switchCaseManageBank();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        switchCaseManageAccount();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        bankService.getAll();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        accountService.getAll();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 5:
                    try {
                        bankService.inputOne();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 6:
                    try {
                        accountService.inputOne();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                default:
                    System.out.println("Error input, Exit...");
                    break;
            }
        } while (true);
    }

    public static void switchCaseManageAccount() {
        accountService.getAll();
        System.out.println("Input id you want manage");
        Account e = accountService.get(Input.inputString());
        System.out.println("Account you wish to manage");
        e.show();
        int choice;
        do {
            System.err.println(
                    "1: Deposit\n" +
                            "2: Withdraw\n" +
                            "3: Withdraw all\n" +
                            "4: Calculate Interest Rate\n" +
                            "5: Delete Account\n" +
                            "0: Exit");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        e.deposit(Input.inputDouble());
                        System.out.println("Info Updated");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        e.withdraw(Input.inputDouble());
                        System.out.println("Info Updated");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        e.withdrawAll();
                        System.out.println("Info Updated");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        System.out.println("Input num of month you want to calculate");
                        System.out.println("Need more than 3 month");
                        System.out.println("Result: " + e.calculateInterestRate(Input.inputInt()));
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 5:
                    try {
                        if (accountService.delete(e)) {
                            System.out.println("Account delete successfully");
                        } else {
                            System.out.println("Account delete failed");
                        }
                        System.out.println("List after update");
                        accountService.getAll();
                        choice = 0;
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Error input, Again...");
                    break;
            }
        } while (choice != 0);
    }

    public static void switchCaseManageBank() {
        bankService.getAll();
        System.out.println("Input bank id you want to manage");
        Bank e = bankService.get(Input.inputString());
        System.out.println("Bank you wish to manage");
        e.show();
        int choice;
        do {
            System.err.println(
                    "1: Delete bank\n" +
                            "0: Exit");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        if (bankService.delete(e)) {
                            System.out.println("Bank delete successfully");
                        } else {
                            System.out.println("Bank delete failed");
                        }
                        System.out.println("List after update");
                        bankService.getAll();
                        choice = 0;
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Error input, Again...");
                    break;
            }
        } while (choice != 0);
    }
}