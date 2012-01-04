package com.auto.finance;

import junit.framework.*;

public class MoneyTest extends TestCase {
    private Money f12CHF;
    private Money f14CHF;

    protected void setUp() {
        f12CHF= new Money(12, "CHF");
        f14CHF= new Money(14, "CHF");
    }

    public void testMoneyEquals() {
        Assert.assertTrue(!f12CHF.equals(null));
        Assert.assertEquals(f12CHF, f12CHF);
        Assert.assertEquals(f12CHF, new Money(12, "CHF"));
        Assert.assertTrue(!f12CHF.equals(f14CHF));
    }

    public void testMoneyAdd() {
        Money expected= new Money(26, "CHF");
        IMoney result= f12CHF.add(f14CHF);
        Assert.assertTrue(expected.equals(result));
    }


}