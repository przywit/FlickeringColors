import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Block extends JPanel implements Runnable {
    private double frequency;
    private double probability;
    private Color color;

    Random random = new Random();


    public Block(double frequency, double probability) {
        this.frequency = frequency;
        this.probability = probability;
        setBackground(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    // private int R;
    // private int G;
    //private int B;

}
