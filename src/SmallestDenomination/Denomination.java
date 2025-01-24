//Author: Miles Glover
//Purpose of File: to have a record for a certain denomination of currency, ex. (quarter,0.25,coin,images/quarter.png)

package SmallestDenomination;

import java.util.List;

public record Denomination(String name, double amt, String form, String img) {

    // Static list of predefined denominations
    // works based on util.list List.of which just makes a list in this style for future reference
    public static List<Denomination> DEFAULT_DENOMS = List.of(

            //The coins
            new Denomination("Penny", 0.01, "coin", "images/Penny.png"),
            new Denomination("Nickel", 0.05, "coin", "images/Nickel.jpg"),
            new Denomination("Dime", 0.10, "coin", "images/Dime.png"),
            new Denomination("Quarter", 0.25, "coin", "images/Quarter.png"),

            //the bills
            new Denomination("1 Dollar Bill", 1.00, "bill", "images/OneDollar.jpg"),
            new Denomination("5 Dollar Bill", 5.00, "bill", "images/FiveDollar.jpg"),
            new Denomination("10 Dollar Bill", 10.00, "bill", "images/TenDollar.jpg"),
            new Denomination("20 Dollar Bill", 20.00, "bill", "images/TwentyDollar.jpg"),
            new Denomination("50 Dollar Bill", 50.00, "bill", "images/FiftyDollar.jpg"),
            new Denomination("100 Dollar Bill", 100.00, "bill", "images/HundredDollar.jpg")

    );

}
