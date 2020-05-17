import java.awt.EventQueue;

public class FlickeringColors {
    public static void main(String[] args) {
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
        if((numbersOfBlocksOnX <= 0) || (numbersOfBlocksOnY <= 0)) {
            System.out.println("wrong input!");
            System.exit(-2);
        }
        if(frequency < 0) {
            System.out.println("wrong input!");
            System.exit(-2);
        }
        if((probability > 1) || (probability < 0)) {
            System.out.println("probability is in range of 0-1");
            System.exit(-3);
        }
        EventQueue.invokeLater(() -> {
            var flickeringColorsDisplay = new FlickeringColorsDisplay(numbersOfBlocksOnX, numbersOfBlocksOnY, frequency, probability);
            flickeringColorsDisplay.setVisible(true);
        });
    }
}
