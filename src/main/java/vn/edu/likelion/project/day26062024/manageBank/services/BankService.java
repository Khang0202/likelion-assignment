package vn.edu.likelion.project.day26062024.manageBank.services;

import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day26062024.manageBank.storage.Storage;
import vn.edu.likelion.project.day26062024.manageBank.models.Bank;

public class BankService implements IService<Bank> {
    @Override
    public void inputOne() {
        try {
            System.out.println("Input your bank name");
            Bank check = save(new Bank(Input.inputString()));
            if (check != null) {
                System.out.println("Bank successfully created\n" +
                        "Your bank id is: " + check.getId());
            } else {
                System.out.println("Bank creation failed");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void inputMany() {
        try {
            System.out.print("Input number of banks you want to create: ");
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
        for (Bank b : Storage.banks) {
            b.show();
            System.out.println("----------------------------------------------");
        }
    }

    @Override
    public Bank get(String id) {
        for (Bank b : Storage.banks) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        throw new RuntimeException("Bank with id " + id + " does not exist!");
    }

    @Override
    public Bank save(Bank bank) {
        try {
            if (Storage.banks.add(bank)) {
                return bank;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create bank", e);
        }
    }

    @Override
    public boolean delete(Bank bank) {
        try {
            if (Storage.banks.contains(bank)) {
                return Storage.accounts.remove(bank);
            } else {
                throw new RuntimeException("Bank with " + bank.getId() + " does not exist!");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        } finally {
            return false;
        }
    }
}
