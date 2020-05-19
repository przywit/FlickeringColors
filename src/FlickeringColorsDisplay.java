import javax.swing.*;
import java.awt.*;

public class FlickeringColorsDisplay extends JFrame {
    private int blocksOnX;
    private int blocksOnY;
    private int xSize;
    private int ySize;
    private double frequency;
    private double probability;

    FlickeringColorsPaintingArea flickeringColorsPaintingArea;
    Block block = new Block();

    Toolkit tk = Toolkit.getDefaultToolkit();
    int MaxXSize = ((int) tk.getScreenSize().getWidth());
    int MaxYSize = ((int) tk.getScreenSize().getHeight());

    public FlickeringColorsDisplay(final int blocksOnX, final int blocksOnY, final double frequency, final double probability) {
        flickeringColorsPaintingArea =  new FlickeringColorsPaintingArea();
        flickeringColorsPaintingArea.setDisplay(this);
        flickeringColorsPaintingArea.setParameters(blocksOnX, blocksOnY, frequency, probability);
        this.frequency = frequency;
        this.probability = probability;
        this.blocksOnX = blocksOnX;
        this.blocksOnY = blocksOnY;

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
