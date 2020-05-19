import javax.swing.*;
import java.awt.*;

public class FlickeringColorsPaintingArea extends JPanel {
    int blocksOnX;
    int blocksOnY;
    double frequency;
    double probability;

    FlickeringColorsDisplay flickeringColorsDisplay;

    Block[][] blocks = new Block[blocksOnX][blocksOnY];
    Thread [][] threads =  new Thread[blocksOnY][blocksOnY];

    public FlickeringColorsPaintingArea() {

    }

    public void setDisplay(FlickeringColorsDisplay flickeringColorsDisplay){
        this.flickeringColorsDisplay = flickeringColorsDisplay;
    }

    public void setParameters(int blocksOnX, int blocksOnY, double frequency, double probability) {
        this.blocksOnX = blocksOnX;
        this.blocksOnY = blocksOnY;
        this.frequency = frequency;
        this.probability = probability;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

}
