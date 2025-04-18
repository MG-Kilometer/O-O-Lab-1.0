//Author: Miles Glover
//Purpose of File:

package SmallestDenomination;

//this class implements the ChangeStrategy using the greedy algorithm
//it always uses the largest possible denomination first
public class GreedyChangeStrategy implements ChangeStrategy {

    @Override
    public Purse makeChange(double amt) {
        Purse myPurse = new Purse();

        //start from the highest denomination
        for (int i = Denomination.DEFAULT_DENOMS.size() - 1; i >= 0; i--) {
            Denomination d = Denomination.DEFAULT_DENOMS.get(i);
            double denomValue = d.amt();

            //add as many of the current denomination as possible
            while (denomValue <= amt) {
                myPurse.add(d, 1);
                amt -= denomValue;
            }

            //correct for rounding issues
            if (amt <= 0.00499) break;
            if (amt <= 0.01) {
                myPurse.add(Denomination.DEFAULT_DENOMS.getFirst(), 1);
                break;
            }
        }

        return myPurse;
    }
}


