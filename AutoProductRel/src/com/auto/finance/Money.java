package com.auto.finance;

/** This class represents a Money of a certain amount and currency*/
public class Money implements IMoney{
    private int fAmount;
    private String fCurrency;

    /** Initialize the Money with amount and currency*/
    public Money(int amount, String currency) {
        fAmount= amount;
        fCurrency= currency;
    }

    /** Get amount*/
    public int amount() {
        return fAmount;
    }

    /** Get Currency*/
    public String currency() {
        return fCurrency;
    }

    /** Add some Money to this Money*/
    public IMoney add(IMoney m) {
        if (m instanceof Money)
        {
            Money tm = (Money)m;
            if (tm.currency().equals(currency()) )
                return new Money(amount()+tm.amount(), currency());
            return new MoneyBag(this, tm);
        }
        else return ((MoneyBag)m).add(this);
    }

    /** Test equality of this Money*/
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money aMoney= (Money)anObject;
            return aMoney.currency().equals(currency())
                && amount() == aMoney.amount();
        }
        return false;
    }

}
