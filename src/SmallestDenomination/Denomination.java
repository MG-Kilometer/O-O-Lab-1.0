//Author: Miles Glover
//Purpose of File: to have a record for a certain denomination of currency, ex. (quarter,0.25,coin,images/quarter.png)

package SmallestDenomination;

import java.util.List;

public record Denomination(String name, double amt, String form, String img) {

    // Static list of predefined denominations
    // works based on util.list List.of which just makes a list in this style for future reference
    public static List<Denomination> DEFAULT_DENOMS = List.of(

            //The coins
            new Denomination("Penny", 0.01, "coin", "Penny.png"),
            new Denomination("Nickel", 0.05, "coin", "Nickel.jpg"),
            new Denomination("Dime", 0.10, "coin", "Dime.png"),
            new Denomination("Quarter", 0.25, "coin", "Quarter.png"),

            //the bills
            new Denomination("1 Dollar Bill", 1.00, "bill", "OneDollar.jpg"),
            new Denomination("5 Dollar Bill", 5.00, "bill", "FiveDollar.jpg"),
            new Denomination("10 Dollar Bill", 10.00, "bill", "TenDollar.jpg"),
            new Denomination("20 Dollar Bill", 20.00, "bill", "TwentyDollar.jpg"),
            new Denomination("50 Dollar Bill", 50.00, "bill", "FiftyDollar.jpg"),
            new Denomination("100 Dollar Bill", 100.00, "bill", "HundredDollar.jpg")

    );

}
