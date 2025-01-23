//Author: Miles Glover
//Purpose of File: idk

package SmallestDenomination;


public class Purse {

    cash: Map<Denomination, Integer>   // represents the money in the purse
    add(type: Denomination, num: int): void  // adds a number of a particular denomination
    remove(type: Denomination, num: int): double //diminishes the money in the purse and returns that amount.
    getValue(): double    // returns the amount of money in the Purse
    toString(): String    // returns a string representation of the Purse and its contents


}
