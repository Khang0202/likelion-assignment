package vn.edu.likelion.project.day26062024.manageBank.models;

import vn.edu.likelion.project.day26062024.manageBank.enums.InterestRateOf;
import vn.edu.likelion.project.day26062024.manageBank.models.abstracts.Account;

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
