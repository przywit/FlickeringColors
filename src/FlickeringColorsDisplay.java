import javax.swing.*;
import java.awt.*;

public class FlickeringColorsDisplay extends JFrame {


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
