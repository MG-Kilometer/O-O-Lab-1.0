//Author: Miles Glover
//Purpose of File:

package SmallestDenomination;

import java.util.Scanner;

//represents a cash register that makes change using a strategy
public class Register {

    private ChangeStrategy strategy;
    private static final double lowerExitThreshholdBound = -99.9;
    private static final double higherExitThreshholdBound = -100.1;

    //default constructor uses Greedy strategy
    public Register() {

        this.strategy = new GreedyChangeStrategy();

    }

    //constructor allows injection of any strategy
    public Register(ChangeStrategy strategy) {

        this.strategy = strategy;

    }

    //allows runtime switching of strategy
    public void setStrategy(ChangeStrategy strategy) {

        this.strategy = strategy;

    }

    //delegates change-making to the current strategy
    public Purse makeChange(double amt) {

        return strategy.makeChange(amt);

    }

    //text-based interface to test the register
    public static void main(String[] args) {

        boolean looping = true;
        Scanner sc = new Scanner(System.in);
        double inputAmt = 0;
        Register regi = new Register();

        while (looping) {

            System.out.print("Enter an amount of money you want exchanged with coins/bills (-100 = EXIT):");

            try {

                inputAmt = sc.nextDouble();

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.nextLine();
                continue;

            }

            //check for exit signal
            if (inputAmt <= lowerExitThreshholdBound && inputAmt >= higherExitThreshholdBound) {

                looping = false;

            } else {

                //make change and print result
                System.out.print(regi.makeChange(inputAmt).toString());

            }
        }

        sc.close();

    }
}


