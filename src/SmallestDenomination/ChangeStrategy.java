//Author: Miles Glover
//Purpose of File:

package SmallestDenomination;

//interface for the Strategy Pattern
//defines a method for making change using a certain strategy
public interface ChangeStrategy {

    Purse makeChange(double amount);

}