import javax.swing.*;
import java.awt.*;


public class FlickeringColorsPaintingArea extends JPanel {

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

