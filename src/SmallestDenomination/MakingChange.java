//Author: Miles Glover
//Purpose of File: to create and run the gui to make change

package SmallestDenomination;

import javax.swing.*;

public class MakingChange {

    public static void main(String[] args) {

        //default window size
        final int windowDefaultX = 500;
        final int windowDefaultY = 500;

        //create the jframe frame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowDefaultX, windowDefaultY);

        //add the registerPanel to frame
        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        //make the frame visible
        frame.setVisible(true);

    }
}
