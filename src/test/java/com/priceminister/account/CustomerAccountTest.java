package com.priceminister.account;


import com.priceminister.account.implementation.CustomerAccount;
import com.priceminister.account.implementation.CustomerAccountRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * <p>
 * We want to see how you "think code", and how you organize and structure a simple application.
 * <p>
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */
public class CustomerAccountTest {

    private Account customerAccount;
    private AccountRule rule;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     */
    @Before
    public void setUp() {
        customerAccount = new CustomerAccount();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotNull(customerAccount.getBalance());
        assertEquals(new Double(0), customerAccount.getBalance());
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() throws IllegalNegativeAmountException {
        Double expectedBalance = customerAccount.getBalance() + 50.50;
        customerAccount.add(50.50);
        assertEquals(expectedBalance, customerAccount.getBalance());
    }

    /**
     * Adds negative amount to the account and checks that throws expected exception.
     */
    @Test(expected = IllegalNegativeAmountException.class)
    public void testAddNegativeAmountIllegalNegativeAmount() throws IllegalNegativeAmountException {
        customerAccount.add(-50.50);
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance()
            throws IllegalBalanceException, IllegalNegativeAmountException {
        rule = new CustomerAccountRule();
        customerAccount.withdrawAndReportBalance(5.0, rule);
    }

    /**
     * Withdrawn money from the account and checks that the new balance is as expected and ok with the rules.
     */
    @Test
    public void testWithdrawAndReportBalance()
            throws IllegalBalanceException, IllegalNegativeAmountException {
        Double expectedBalance = customerAccount.getBalance() - 50.50;
        rule = new CustomerAccountRule();

        Double newBalance = customerAccount.withdrawAndReportBalance(50.50, rule);

        assertEquals(expectedBalance, newBalance);
    }

    /**
     * Withdraw a negative amount and check if that throws the expected exception.
     */
    @Test(expected = IllegalNegativeAmountException.class)
    public void testWithdrawAndReportBalanceIllegalNegativeAmount()
            throws IllegalNegativeAmountException, IllegalBalanceException {
        rule = new CustomerAccountRule();
        customerAccount.withdrawAndReportBalance(-50.50, rule);
    }
}
