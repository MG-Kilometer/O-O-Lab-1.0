//Author: Miles Glover
//Purpose of File: Panel that handles the GUI

package SmallestDenomination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    //register to handle logic
    private Register register;

    //panel that holds the input field which contains the input text field
    private JPanel inputPanel;

    //user input text field
    private JTextField input;

    //panel holds information about purse currency (like the images)
    private PursePanel CashPanel;

    public RegisterPanel() {

        // Initialize the register and GUI components
        this.register = new Register();
        this.setLayout(new BorderLayout());

        //create input panel and sets it's layout
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        //sets up the text box
        JLabel inputLabel = new JLabel("Enter amount: ");
        input = new JTextField(10);

        //adds actionables to the input/inputPanel
        input.addActionListener(new InputListener());
        inputPanel.add(inputLabel);
        inputPanel.add(input);

        //create the pursePanel
        CashPanel = new PursePanel();

        //adds the input and cash panel
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(CashPanel, BorderLayout.CENTER);

    }

    //event listener for inputting text into text box and hitting enter
    private class InputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                //gets the money amount from the text box
                double amount = Double.parseDouble(input.getText());

                //use the register logic to change the amount of coins in the purse visual
                Purse change = register.makeChange(amount);
                CashPanel.setPurse(change);

                // repaint the images when new images need to be displayed
                CashPanel.repaint();

            } catch (NumberFormatException ex) {

                //show an error message for invalid input
                JOptionPane.showMessageDialog(
                        RegisterPanel.this,
                        "Please enter a valid number.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE

                );

            }

        }

    }

}

