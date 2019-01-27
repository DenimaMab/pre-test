package com.priceminister.account;


public class IllegalNegativeAmountException extends Exception {

    private static final long serialVersionUID = -9204191749972551988L;

    public String toString() {
        return "The amount to withdraw or to add must be positive.";
    }
}
