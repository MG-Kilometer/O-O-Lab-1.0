//Author: Miles Glover
//Purpose of File: handles the Purse class that maintains what money you have in a purse and what denominations of currency---
//---is in that purse as well as the many things you can do to a purse like look inside of it and exchange money with it.

package SmallestDenomination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Purse {

    //cash represents a denomination and int mapped together so quantities of denominations can be tracked
    private Map<Denomination, Integer> cash;

    //constructor of Purse makes empty hashMap
    public Purse(){

        cash = new HashMap<>();

    }

    //adds a denomination onto the cash map
    public void add(Denomination denom, int quantity) {

        // if you are attempting to add a negative quantity of denomination, then just quit action
        if (quantity <= 0) {

            return;

        }

        //updates the count of the given denomination
        cash.put(denom, cash.getOrDefault(denom, 0) + quantity);
        //put just matches the denomination to its slot in cash
        //getOrDefault just makes sure that if it is a new denomination, its default quantity is zero.

    }

    //removes a number of a particular denomination from the purse and returns the amount removed
    public double remove(Denomination denom, int quantity) {

        //nothing to remove if quantity is negative or that particular denomination isn't in the purse
        if (quantity <= 0 || !cash.containsKey(denom)) {

            return 0;

        }

        //get the current count of the denomination
        int currentQuantity = cash.get(denom);

        //finds how many of that denomination we have to remove, capped by the amount in the purse
        int toRemove = Math.min(quantity, currentQuantity);

        //removes that particular denomination of currency from cash in the specified amount withdrawn
        //only happens if you still have some of that denomination afterwards
        if (currentQuantity - toRemove > 0) {

            cash.put(denom, currentQuantity - toRemove);

        //if none of that denomination remain, then just remove that denomination from cash
        } else {

            cash.remove(denom);

        }

        //returns how much money was removed from the purse
        return toRemove * denom.amt();
    }


    //getter for cash in purse
    public double getValue(){

        double total = 0;

        //works by checking the map for each of its denoms and associated quantities
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {

            //each slot's denom's value is multiplied by the quantity of that denom as showed by getValue
            total = total + entry.getKey().amt() * entry.getValue();

        }

        return total;

    }

    // returns a string representation of the Purse and its contents
    public String toString() {

        String returnString = "";
        boolean anyDenoms = false;

        //sorts the cash so that high value items come first
        //basically just takes the cash map and makes it a list that gets sorted based on descending order of the denominations value so higher value denoms like bills come first then coins after
        List<Map.Entry<Denomination, Integer>> sortedEntries = cash.entrySet().stream().sorted((e1, e2) ->
                Double.compare(e2.getKey().amt(), e1.getKey().amt())).toList();


        //just goes through each denomination quantity duo held within cash but references the sorted version instead
        for (Map.Entry<Denomination, Integer> entry : sortedEntries) {

            anyDenoms = true;

            //formatted like "7 Quarters"
            returnString=returnString+entry.getValue()+" - ";
            returnString=returnString+entry.getKey().name();

            //if quantity of denom is multiple, then put an s at end of denom name to represent plurality
            if(entry.getValue()>1.01){

                returnString=returnString+"s";

            }

            //every unique denom has its own line
            returnString=returnString+"\n";

        }

        //if the denomination search loop was never entered, there were no denominations so purse if empty
        if(!anyDenoms){

            return "Empty Purse\n\n";

        }

        //at the end make it tell user total cash within the purse
        returnString=returnString+"\n\nTotal Value: $"+getValue()+"\n\n";

        return returnString;

    }
}
