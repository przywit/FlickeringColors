import javax.swing.*;
import java.awt.*;


public class FlickeringColorsPaintingArea extends JPanel {

    Object manager = new Object();

    public FlickeringColorsPaintingArea(final int blocksOnX, final int blocksOnY, final double frequency, final double probability) {
        setLayout(new GridLayout(blocksOnX,blocksOnY));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Block[] blocks = new Block[blocksOnX * blocksOnY];
        Thread[] threads = new Thread[blocksOnX * blocksOnY];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(frequency, probability);
        }
        for (int i = 0; i < blocks.length; i++) {
            Block westBlock;
            Block eastBlock;
            Block northBlock;
            Block southBlock;
            if((i % blocksOnX) == 0) {
                westBlock = blocks[i + (blocksOnX - 1)];
            }
            else {
                westBlock = blocks[i - 1];
            }
            if((i % blocksOnX) == (blocksOnX - 1)) {
                eastBlock = blocks[i - (blocksOnX - 1)];
            }
            else {
                eastBlock = blocks[i + 1];
            }
            if((i - blocksOnX) < 0) {
                northBlock = blocks[i + (blocksOnX * (blocksOnY - 1))];
            }
            else {
                northBlock = blocks[i - blocksOnX];
            }
            if((i + blocksOnX) >= blocksOnX * blocksOnY) {
                southBlock = blocks[i - (blocksOnX * (blocksOnY - 1))];
            }
            else {
                southBlock = blocks[i + blocksOnX];
            }
            blocks[i].setNeighbours(westBlock, eastBlock, northBlock, southBlock);
        }
        for (int i = 0; i < blocks.length; i++) {
            add(blocks[i]);
            blocks[i].setFlickeringColorsPaintingArea(this);
        }
        for (int i = 0; i < blocks.length; i++) {
            threads[i] = new Thread(blocks[i]);
            threads[i].start();
        }
    }

    public Object getManager() {
        return manager;
    }
}

