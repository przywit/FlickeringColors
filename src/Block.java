import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Block extends JPanel implements Runnable {
    private double frequency;
    private double probability;
    private int min;
    private int max;
    private Color color;

    Random random = new Random();

    public Block(double frequency, double probability) {
        min = (int) (0.5 * frequency);
        max = (int) (1.5 * frequency);
        this.frequency = frequency;
        this.probability = probability;
        setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
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
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            if(random.nextDouble() <= probability) {
                setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            }
        }
    }
}
