import javax.swing.*;
import java.awt.*;


public class FlickeringColorsPaintingArea extends JPanel {

    double frequency;
    double probability;

    public FlickeringColorsPaintingArea(final int blocksOnX, final int blocksOnY, final double frequency, final double probability) {
        setLayout(new GridLayout(blocksOnX,blocksOnY));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Block[] blocks = new Block[blocksOnX * blocksOnY];
        Thread[] threads = new Thread[blocksOnX * blocksOnY];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(frequency, probability);
            threads[i] = new Thread(blocks[i]);
            add(blocks[i]);
            threads[i].start();
        }
    }


}
/*    public void run() {
        threads = new CustomThread[blocksOnX][blocksOnY];
        for(int i = 0; i < threads.length; i++) {
            for (int j = 0; j < threads[0].length; j++) {
                threads[i][j] = new CustomThread(i,j, new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                repaint();
                threads[i][j].start();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < threads.length; i++) {
            for (int j = 0; j < threads[0].length; j++) {
                threads[i][j].draw(g2d);
            }
        }
    }*/
/*    public void setDisplay(FlickeringColorsDisplay flickeringColorsDisplay) {
        this.flickeringColorsDisplay = flickeringColorsDisplay;
    }*/


