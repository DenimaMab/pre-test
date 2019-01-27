/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccountRule implements AccountRule {

    /**
     * @see com.priceminister.account.AccountRule#withdrawPermitted(Double)
     */
    public boolean withdrawPermitted(Double resultingAccountBalance) {
        return resultingAccountBalance >= 0;
    }

    /**
     * @see com.priceminister.account.AccountRule#amountPermitted(Double)
     */
    public boolean amountPermitted(Double amount) {
        return amount >= 0;
    }
}
