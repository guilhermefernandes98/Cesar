package blackboxpartitioning;

import java.util.Random;

public class Die extends Object
{
    public static int DEFAULT_SIDES;
    private int numSides;
    private int result;

    public Die() {
        DEFAULT_SIDES = 6;
        this.numSides = 6;
        this.result = 1;
    }

    public Die(int numSides) throws AssertionError {
        if (numSides > 1 && numSides <= 6) {
            this.numSides = numSides;
            this.result = 1;
        } else {
            throw new AssertionError();
        }
    }

    public Die(int numSides, int result) {
        if (numSides > 1 && 1 <= result && result <= numSides) {
            this.numSides = numSides;
            this.result = result;
        } else {
            throw new AssertionError();
        }
    }

    public int roll()
    {
        Random ourRandNumGen = new Random();
        int iMyResult = ourRandNumGen.nextInt(this.getNumSides()) + 1;
        return iMyResult;
    }

    public int getNumSides() {
        return numSides;
    }

    public int getResult() {

        return result;

    }
    public String toString()
    {
        return "Numero lados 2 Resultado 1";
    }
}
