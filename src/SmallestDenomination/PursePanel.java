//Author: Miles Glover
//Purpose of File: handles the visuals of the coins

package SmallestDenomination;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PursePanel extends JPanel {

    //current purse's contents
    private Purse purse;

    //constructor
    public PursePanel() {
        this.purse = new Purse();
    }

    //setter for the purse inside pursePanel
    public void setPurse(Purse purse) {
        this.purse = purse;
    }


    //logic of how images get displayed on jpanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //clear the panel
        g.clearRect(0, 0, getWidth(), getHeight());

        //draw the contents of the purse
        int y = 20;
        int x = 20;
        boolean isCoin = false;


        //vertical spacing of images
        int rowHeight = 50;

        //loop through each coin/bill in the purse
        for (Map.Entry<Denomination, Integer> entry : purse.getContents().entrySet()) {

            //repeats printing images for each of that denomination so if you got 3 penny's it prints 3 images of penny's back to back
            for(int i = 0; i < entry.getValue(); i++){

                String imagePath = entry.getKey().img();

                try {
                    //load the image
                    Image img = ImageIO.read(new File(imagePath));

                    //default size for image
                    int imgWidth = 0;
                    int imgHeight = 50;

                    //coins are square, bills are rectangular
                    if (entry.getKey().form().equals("coin")) {

                        isCoin = true;
                        imgWidth = 50;

                    } else if (entry.getKey().form().equals("bill")) {

                        isCoin = false;
                        imgWidth = 125;

                    }

                    //draw the image
                    g.drawImage(img, x, y, imgWidth, imgHeight, null);

                } catch (IOException e) {

                    System.out.println("Error loading image: " + imagePath);

                }

                //make x increment by variable if either coin or bill so no overlapping images
                if(isCoin){

                    x = x + 50;

                }else{

                    x = x + 125;

                }

                //if the image has overlapped with wall of jpanel, then loop around
                if (x + 125 > getWidth()) {

                    x = 20;
                    y = y + rowHeight;

                }

            }

        }

        //total value of purse
        g.drawString("Total Value: $" + purse.getValue(), 10, y+80);

    }
}