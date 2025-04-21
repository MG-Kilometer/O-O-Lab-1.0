//Author: Miles Glover
//Purpose of File:interface for the Strategy Pattern, defines a method for making change using a certain strategy

package SmallestDenomination;

public interface ChangeStrategy {

    Purse makeChange(double amount);

}