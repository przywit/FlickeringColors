import javax.swing.*;
import java.awt.*;

/**
 * Class responsible for drawing blocks on the screen and places them in grid layout.
 * Every block is also thread.
 */
public class FlickeringColorsPaintingArea extends JPanel {

    Object manager = new Object();

    /**
     * Constructor creates Blocks and places them in grid layout.
     * Every block is also thread.
     * @param blocksOnX number of blocks on x Axis.
     * @param blocksOnY number of blocks on y Axis.
     * @param frequency frequency of action done by blocks.
     * @param probability parameter keeps information about how often should block change colors.
     */
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

    /**
     * getter for manager/locker. Necessary for synchronization.
     * @return manager/locker
     */
    public Object getManager() {
        return manager;
    }
}