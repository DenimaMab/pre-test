package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {
    private Double balance;

    public CustomerAccount(Double balance) {
        this.balance = balance;
    }

    /**
     * Default constructor to set the balance always at 0.0
     */
    public CustomerAccount() {
        this(0.0);
    }

    public void add(Double addedAmount, AccountRule rule) throws IllegalNegativeAmountException {
        if (rule.amountPermitted(addedAmount))
            balance += addedAmount;
        else
            throw new IllegalNegativeAmountException();
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException, IllegalNegativeAmountException {
        Double newBalance = balance - withdrawnAmount;
        // check that withdrawnAmount is positive
        if (!rule.amountPermitted(withdrawnAmount)) {
            throw new IllegalNegativeAmountException();
        }// check that the resulting balance is permitted
        else if (!rule.withdrawPermitted(newBalance)) {
            throw new IllegalBalanceException(newBalance);
        }
        // if all rules check is OK replace the balance.
        balance = newBalance;
        return balance;
    }

}
