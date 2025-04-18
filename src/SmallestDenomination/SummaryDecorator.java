//Author: Miles Glover
//Purpose of File:

package SmallestDenomination;

//concrete decorator that appends a strategy summary message to the output
public class SummaryDecorator extends CurrencyDecorator {

    public SummaryDecorator(Purse basePurse) {
        super(basePurse);
    }

    //adds a note about which strategy was used
    @Override
    public String toString() {
        return basePurse.toString() + "\nNote: This change was calculated using a Greedy strategy.\n";
    }
}
