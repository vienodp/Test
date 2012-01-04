package com.auto.finance;

import junit.framework.*;

public class MoneyBagTest extends TestCase {
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    protected void setUp() {
        f12CHF= new Money(12, "CHF");
        f14CHF= new Money(14, "CHF");
        f7USD=  new Money( 7, "USD");
        f21USD= new Money(21, "USD");
        fMB1= new MoneyBag(f12CHF, f7USD);
        fMB2= new MoneyBag(f14CHF, f21USD);
    }

    public void testBagEquals() {
        Assert.assertTrue(!fMB1.equals(fMB2));
    }

    public void testBagAdd() {
        Money expected= new Money(26, "CHF");
        IMoney result= f12CHF.add(f14CHF);
        Assert.assertTrue(expected.equals(result));
    }

    public void testMixedSimpleAdd() {
        Assert.assertEquals(fMB1, f12CHF.add(f7USD));
    }
}