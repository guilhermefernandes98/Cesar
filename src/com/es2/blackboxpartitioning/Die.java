package com.es2.blackboxpartitioning;


import java.util.Random;

public class Die extends Object{

    static int lados = 6;
    int result = 1;

    public Die()
    {

    }

    public Die(int numSides) throws AssertionError
    {
        if(numSides >= 1 && numSides <= 6)
            lados = numSides;
        else
            throw new AssertionError();
    }


    public Die(int numSides, int result) throws AssertionError
    {
        if(numSides >=1 && 1 <= result && result <= numSides)
        {
            lados = numSides;
            result = result;
        }
        else
            throw new AssertionError();
    }

    public int roll()
    {
        Random randomgen = new Random();
        int result = randomgen.nextInt(lados) + 1;
        return result;
    }

    public int getNumSides()
    {
        return lados;
    }

    public int getResult()
    {
        return result;
    }

    public String toString()
    {
        return "O dado tem " + lados + " lados e o resultado foi de " + result;
    }
}
