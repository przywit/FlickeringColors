import javax.swing.*;

/**
 * Class responsible for displaying on screen.
 * Creates frame with all blocks.
 */
public class FlickeringColorsDisplay extends JFrame {

    /**
     * Constructor creates frame with blocks.
     * @param blocksOnX number of blocks on x Axis.
     * @param blocksOnY number of blocks on y Axis.
     * @param frequency frequency of action done by blocks.
     * @param probability parameter keeps information about how often should block change colors.
     */
    public FlickeringColorsDisplay(final int blocksOnX, final int blocksOnY, final double frequency, final double probability) {
        setTitle("Flickering Colors");
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlickeringColorsPaintingArea flickeringColorsPaintingArea = new FlickeringColorsPaintingArea(blocksOnX, blocksOnY, frequency, probability);
        add(flickeringColorsPaintingArea);
    }

}
