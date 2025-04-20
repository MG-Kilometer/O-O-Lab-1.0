//Author: Miles Glover
//Purpose of File: handles the visuals of the coins

package SmallestDenomination;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;

public class PursePanel extends JPanel {

    //=== Constants for layout and image dimensions ===//
    private static final int START_X = 20;
    private static final int START_Y = 20;
    private static final int COIN_WIDTH = 50;
    private static final int BILL_WIDTH = 125;
    private static final int IMAGE_HEIGHT = 50;
    private static final int ROW_HEIGHT = 50;
    private static final int MAX_IMAGE_WIDTH = BILL_WIDTH; // used to check for overflow
    private static final int TOTAL_LABEL_X = 10;
    private static final int TOTAL_LABEL_Y_OFFSET = 80;

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
        int y = START_Y;
        int x = START_X;
        boolean isCoin;

        //loop through each coin/bill in the purse
        for (Map.Entry<Denomination, Integer> entry : purse.getContents().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {

                String imagePath = entry.getKey().img();

                try {
                    //load the image
                    Image img = ImageIO.read(new File(imagePath));

                    int imgWidth;
                    isCoin = entry.getKey().form().equals("coin");

                    if (isCoin) {
                        imgWidth = COIN_WIDTH;
                    } else {
                        imgWidth = BILL_WIDTH;
                    }

                    //draw the image
                    g.drawImage(img, x, y, imgWidth, IMAGE_HEIGHT, null);

                    //shift x position to the right
                    x += imgWidth;

                    //wrap to next row if hitting edge
                    if (x + MAX_IMAGE_WIDTH > getWidth()) {
                        x = START_X;
                        y += ROW_HEIGHT;
                    }

                } catch (IOException e) {
                    System.out.println("Error loading image: " + imagePath);
                }
            }
        }

        //draw total value string
        g.drawString("Total Value: $" + purse.getValue(), TOTAL_LABEL_X, y + TOTAL_LABEL_Y_OFFSET);
    }
}
