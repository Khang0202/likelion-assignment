package vn.edu.likelion.manageBank.models;

import vn.edu.likelion.manageBank.enums.InterestRateOf;
import vn.edu.likelion.manageBank.models.abstracts.Account;

public class NormalAccount extends Account {
    public NormalAccount(double balance) {
        super(balance);
        super.setInterestRateOf(InterestRateOf.NONE);
        super.setAllowDeposit(true);
        super.setAllowWithdraw(true);
    }

    @Override
    public void show() {
        System.out.println("Account type: Normal Account");
        super.show();
    }
}
