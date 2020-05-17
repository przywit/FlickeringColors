import javax.swing.*;
import java.awt.*;

public class FlickeringColorsPaintingArea extends JPanel {

    public FlickeringColorsPaintingArea() {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

}
