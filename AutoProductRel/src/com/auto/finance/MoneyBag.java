package com.auto.finance;

import java.util.*;

/** This class represents a Bag of Monies with different currencies*/
public class MoneyBag implements IMoney
{
    private Vector fMonies= new Vector();

    /**Initializes the Money Bag with 2 Monies*/
    MoneyBag(Money m1, Money m2)
    {
        appendMoney(m1);
        appendMoney(m2);
    }

    /**Initializes the Money Bag with an array of Monies*/
    MoneyBag(Money bag[])
    {
        for (int i= 0; i < bag.length; i++)
        {
            appendMoney(bag[i]);
        }
    }

    /**Internal method to append a Money to the bag*/
    void appendMoney(Money m)
    {
        boolean found = false;
        for (int i= 0; i < fMonies.size(); i++)
        {
            Money tm = (Money)fMonies.elementAt(i);
            if (m.currency().equals(tm.currency()) )
            {
                found = true;
                tm.add(m);
                break;
            }
        }
        if (!found) fMonies.add(m);
    }

    /** Get the money at the ith location in the Bag*/
    public Money getMoney(int i)
    {
        return (Money)fMonies.elementAt(i);
    }

    /** Add a Money of Money Bag to this Money Bag*/
    public IMoney add(IMoney m)
    {
        if (m instanceof Money)
        {
            appendMoney((Money)m);
            return this;
        }
        else
        {
            MoneyBag bag = (MoneyBag)m;
            for (int i= 0; i < bag.getSize(); i++)
            {
                appendMoney((Money)bag.getMoney(i));
            }
            return this;
        }
    }

    /** Get the size of the Money Bag*/
    public int getSize()
    {
        return fMonies.size();
    }


    /** Test equality to two Money Bags */
    public boolean equals(Object anObject)
    {
       if (anObject instanceof MoneyBag)
       {
           MoneyBag bag = (MoneyBag)anObject;
           for (int i= 0; i < fMonies.size(); i++)
           {
                if (!(bag.getMoney(i).equals((Money)fMonies.elementAt(i))))
                {
                    return false;
                }
           }
          return true;
       }
       return false;

    }
}