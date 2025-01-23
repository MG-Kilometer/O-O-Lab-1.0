//Author: Miles Glover
//Purpose of File: idk

package SmallestDenomination;

public record Denomination<name>() {

    // name of the denomination. E.g. Ten Note, Five Note, Dime, Nickle, etc.
    name String;
    // The amount of money this denomination represents
    amt: double;
    // “bill” or “coin”;  This could be an enum, if you know them.
    form: String;
    // The string containing the image name for an image of the type of money
    img: String;


}
