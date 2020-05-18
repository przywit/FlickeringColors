import javax.swing.*;
import java.awt.*;

public class FlickeringColorsDisplay extends JFrame {
    int xSize;
    int ySize;
    double frequency;
    double probability;

    Block block = new Block();
    FlickeringColorsPaintingArea flickeringColorsPaintingArea;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int MaxXSize = ((int) tk.getScreenSize().getWidth());
    int MaxYSize = ((int) tk.getScreenSize().getHeight());

    public FlickeringColorsDisplay(final int blocksOnX, final int blocksOnY, final double frequency, final double probability) {
        this.frequency = frequency;
        this.probability = probability;

        int blockSize = block.getBlockSize();
        xSize = blocksOnX * blockSize;
        ySize = blocksOnY * blockSize;
        if ((xSize > MaxXSize) || (ySize > MaxYSize)) {
            System.out.println("It is not possible to create application window larger than your resolution!");
            System.exit(-1);
        }
        setTitle("Flickering Colors");
        setSize(xSize,ySize);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        flickeringColorsPaintingArea = new FlickeringColorsPaintingArea();
        add(flickeringColorsPaintingArea);
    }
}
