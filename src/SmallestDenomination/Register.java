//Author: Miles Glover
//Purpose of File: represents a register that gives a purse change for some amount of money

package SmallestDenomination;
import java.util.Scanner;

public class Register {


    // takes an amt and returns a Purse containing that amount in the fewest number of bills and coins.
    public Purse makeChange(double amt){

        Purse myPurse = new Purse();

        //searches default denominations list for denominations in reverse value order so 100$ are first and 50$ and so on until you get to the penny
        for(int i = Denomination.DEFAULT_DENOMS.size()-1; i >= 0; i--){

            Denomination d = Denomination.DEFAULT_DENOMS.get(i);
            double denomValue = d.amt();

            //while your remaining money to be reduced is greater than the current denomination's value
            while (denomValue <= amt) {

                //add that denomination to your purse while removing its value from your remaining money
                myPurse.add(d,1);
                amt = amt - denomValue;

                //repeat until your remaining money is less than a single on of that denomination, thus necessitating it switch to a smaller one

            }

            //if you basically got no money left, exit makeChange loop
            if (amt<=0.00499){

                break;

            }
            if(amt<=0.01){

                //add a penny if value is between 0.00499 and 0.01, rounding if you will
                myPurse.add(Denomination.DEFAULT_DENOMS.getFirst(),1);
                break;

            }

        }

        return myPurse;

    }

    //main for checking if Register works
    public static void main(String[] args) {

        boolean looping = true;
        boolean isDouble = true;
        String input = "";
        Scanner sc = new Scanner(System.in);
        double inputAmt = 0;

        while (looping){

            System.out.print("Enter an amount of money you want exchanged with coins/bills (-100 = EXIT):");

            isDouble = true;

            try {
                inputAmt = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.nextLine(); // Clears the invalid input
                isDouble = false;
            }

            //if the number is a double
            if(isDouble) {

                //if input satisfies exit code then input loop is ended
                if (inputAmt <= -99.9 && inputAmt >= -100.1) {

                    looping = false;

                //makes a register and prints the contents of the register after a makeChange
                } else {

                    //regi the Register
                    Register regi = new Register();
                    System.out.print(regi.makeChange(inputAmt).toString());

                }

            }

        }

        //to make sure scanner closes
        sc.close();


    }


    }
