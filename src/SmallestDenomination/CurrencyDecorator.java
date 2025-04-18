//Author: Miles Glover
//Purpose of File:

package SmallestDenomination;

//abstract base class for Decorator Pattern
//extends Purse so it can be treated like a Purse
public abstract class CurrencyDecorator extends Purse {
    protected Purse basePurse;

    public CurrencyDecorator(Purse basePurse) {
        this.basePurse = basePurse;
    }

    //subclasses must override toString to add functionality
    public abstract String toString();
}

