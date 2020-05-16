import java.awt.EventQueue;

public class FlickeringColors {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            int numbersOfBlocksOnX = 1;
            int numbersOfBlocksOnY = 1;
            int frequency = 1;
            int probability = 0;
            try {
                numbersOfBlocksOnX = Integer.parseInt(args[0]);
                numbersOfBlocksOnY = Integer.parseInt(args[1]);
                frequency = Integer.parseInt(args[2]);
                probability = Integer.parseInt(args[3]);
            }
            catch (NumberFormatException e) {
                System.out.println("wrong input!");
                System.exit(-2);
            }
            var flickeringColorsDisplay = new FlickeringColorsDisplay(numbersOfBlocksOnX, numbersOfBlocksOnY, frequency, probability);
            flickeringColorsDisplay.setVisible(true);
        });
    }
}
