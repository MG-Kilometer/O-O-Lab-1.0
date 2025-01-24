//Author: Miles Glover
//Purpose of File: to create and run the gui to make change

package SmallestDenomination;

import javax.swing.*;

public class MakingChange {

    public static void main(String[] args) {

        //create the jframe frame
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //add the registerPanel to frame
        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        //make the frame visible
        frame.setVisible(true);

    }
}
