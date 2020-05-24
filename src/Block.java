import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Block extends JPanel implements Runnable {
    private double probability;
    private int min;
    private int max;

    private Color color;

    FlickeringColorsPaintingArea flickeringColorsPaintingArea;

    Block westBlock;
    Block eastBlock;
    Block northBlock;
    Block southBlock;

    Random random = new Random();

    public Block(double frequency, double probability) {
        min = (int) (0.5 * frequency);
        max = (int) (1.5 * frequency);
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        setBackground(color);
        this.color = color;
        this.probability = probability;
    }

    public void setNeighbours(Block westBlock, Block eastBlock, Block northBlock, Block southBlock) {
        this.westBlock = westBlock;
        this.eastBlock = eastBlock;
        this.northBlock = northBlock;
        this.southBlock = southBlock;
    }

    public Color getColor() {
        return getBackground();
    }

    public void setNewColor() {
        synchronized (flickeringColorsPaintingArea.getManager()) {
            setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
    }
    public void setNewColorBasedOnNeighbour() {
        synchronized (flickeringColorsPaintingArea.getManager()) {
            int R = (northBlock.getColor().getRed() + southBlock.getColor().getRed() + westBlock.getColor().getRed() + eastBlock.getColor().getRed()) / 4;
            int G = (northBlock.getColor().getGreen() + southBlock.getColor().getGreen() + westBlock.getColor().getGreen() + eastBlock.getColor().getGreen()) / 4;
            int B = (northBlock.getColor().getBlue() + southBlock.getColor().getBlue() + westBlock.getColor().getBlue() + eastBlock.getColor().getBlue()) / 4;
            color = new Color(R, G, B);
        }
    }

    public void setFlickeringColorsPaintingArea(FlickeringColorsPaintingArea flickeringColorsPaintingArea) {
        this.flickeringColorsPaintingArea = flickeringColorsPaintingArea;
    }

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
