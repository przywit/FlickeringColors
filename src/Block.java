import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 * Class crates Block and has all logic inside(color changing)
 */
public class Block extends JPanel implements Runnable {
    private double probability;
    private int min;
    private int max;

    private boolean blockNotClicked = true;

    private Color color;

    FlickeringColorsPaintingArea flickeringColorsPaintingArea;

    int numberOfNeighbours = 4;
    Block[] neighbours =  new Block[numberOfNeighbours];

    Random random = new Random();

    public Block(double frequency, double probability) {
        min = (int) (0.5 * frequency);
        max = (int) (1.5 * frequency);
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        setBackground(color);
        this.color = color;
        this.probability = probability;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                blockHasBeenClicked();
            }
        });

    }

    /**
     * Method gives information about Block state.
     * @return boolean is Block clicked or not.
     */
    public boolean isBlockNotClicked() {
        return blockNotClicked;
    }

    /**
     * Sets Neighbourhood of this Block.
     * @param westBlock west Block.
     * @param eastBlock east Block.
     * @param northBlock north Block.
     * @param southBlock south Block.
     */
    public void setNeighbours(Block westBlock, Block eastBlock, Block northBlock, Block southBlock) {
        neighbours[0] = northBlock;
        neighbours[1] = eastBlock;
        neighbours[2] = southBlock;
        neighbours[3] = westBlock;
    }

    /**
     * Synchronized method. When someone clicks on block method changes state of variable holding "ClickedState".
     */
    public void blockHasBeenClicked() {
        synchronized (flickeringColorsPaintingArea.getManager()) {
            blockNotClicked = false;
        }
    }

    /**
     * getter for Color
     * @return color of this Block
     */
    public Color getColor() {
        return getBackground();
    }

    /**
     * Synchronized method. Sets random color for this Block.
     */
    public void setNewColor() {
        synchronized (flickeringColorsPaintingArea.getManager()) {
            setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
    }

    /**
     * Synchronized method. Sets color of this block based on active blocks in a neighbourhood.
     */
    public void setNewColorBasedOnNeighbour() {
        synchronized (flickeringColorsPaintingArea.getManager()) {
            int R = 0;
            int G = 0;
            int B = 0;
            int numberOfActiveNeighbours = 0;
            for (int i = 0; i < numberOfNeighbours; i++) {
                if(neighbours[i].isBlockNotClicked()) {
                    numberOfActiveNeighbours ++;
                    R += neighbours[i].getColor().getRed();
                    G += neighbours[i].getColor().getGreen();
                    B += neighbours[i].getColor().getBlue();
                }
            }
            if(numberOfActiveNeighbours == 0) {
                R = this.getColor().getRed();
                G = this.getColor().getGreen();
                B = this.getColor().getBlue();
            }
            else {
                R = R / numberOfActiveNeighbours;
                G = G / numberOfActiveNeighbours;
                B = B / numberOfActiveNeighbours;
            }
            color = new Color(R, G, B);
        }
    }

    /**
     * setter for painting area where are blocks are located in grid layout.
     * @param flickeringColorsPaintingArea Painting area.
     */
    public void setFlickeringColorsPaintingArea(FlickeringColorsPaintingArea flickeringColorsPaintingArea) {
        this.flickeringColorsPaintingArea = flickeringColorsPaintingArea;
    }

    /**
     * method called when thread/block starts working.
     *  Thread/block will stop working if clicked.
     */
    @Override
    public void run() {
        while (true) {
            int time = min + random.nextInt(max - min);
            if(time == 0) {
                time = 1;
            }
            try {
                sleep(time);
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            if (!blockNotClicked) {
                break;
            }
            if(random.nextDouble() <= probability) {
                setNewColor();
            }
            else {
                setNewColorBasedOnNeighbour();
                setBackground(color);
            }
        }
    }
}