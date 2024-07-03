package vn.edu.likelion.project.day26062024.manageBank.models;

import vn.edu.likelion.project.day26062024.manageBank.enums.InterestRateOf;
import vn.edu.likelion.project.day26062024.manageBank.models.abstracts.Account;

public class SavingAccount extends Account {
    public SavingAccount(double balance, InterestRateOf interestRate) {
        super(balance);
        super.setInterestRateOf(interestRate);
        super.setAllowWithdraw(false);
        super.setAllowDeposit(false);
        super.setAllowWithdrawal(true);
    }


    @Override
    public void show() {
        System.out.println("Account type: Saving Account");
        super.show();
    }
}
