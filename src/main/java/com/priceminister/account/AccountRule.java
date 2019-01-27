package com.priceminister.account;

/**
 * Checks if the requested operation is permitted.
 */
public interface AccountRule {
    
    /**
     * Checks if the resulting account balance after a withdrawal is OK
     * for the specific type of account.
     * @param resultingAccountBalance - the amount resulting of the withdrawal
     * @return true if the operation is permitted, false otherwise
     */
    boolean withdrawPermitted(Double resultingAccountBalance);

    /**
     * Checks that the amount added or withdrawn is not negative.
     * @param amount the amount to add or withdraw
     * @return true if the amount is positive, false otherwise.
     */
    boolean amountPermitted(Double amount);
}
