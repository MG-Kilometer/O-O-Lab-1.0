//Author: Miles Glover
//Purpose of File: implements the ChangeStrategy using the greedy algorithm, it always uses the largest possible denomination first

package SmallestDenomination;

public class GreedyChangeStrategy implements ChangeStrategy {

    //rounding thresholds
    private double pennyThreshold = 0.01;
    private double halfPennyThreshold = 0.00499;

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
            if (amt <= halfPennyThreshold) break;
            if (amt <= pennyThreshold) {

                myPurse.add(Denomination.DEFAULT_DENOMS.getFirst(), 1);
                break;

            }

        }

        return myPurse;

    }

}


