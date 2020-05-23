import java.awt.EventQueue;

public class FlickeringColors {
    public static void main(String[] args) {

        int numbersOfBlocksOnX = 1;
        int numbersOfBlocksOnY = 1;
        double frequency = 1.0;
        double probability = 0.0;
        try {
            numbersOfBlocksOnX = 4;//Integer.parseInt(args[0]);
            numbersOfBlocksOnY = 4;//Integer.parseInt(args[1]);
            frequency = 1000;//Double.parseDouble(args[2]);
            probability = 0.5;//Double.parseDouble(args[3]);
        }
        catch (NumberFormatException e) {
            System.out.println("wrong input!");
            System.exit(-2);
        }
        if((numbersOfBlocksOnX <= 0) || (numbersOfBlocksOnY <= 0)) {
            System.out.println("negative values of blocks count are not allowed!");
            System.exit(-3);
        }
        if(frequency < 0.0) {
            System.out.println("negative value of frequency is not allowed!");
            System.exit(-4);
        }
        if((probability > 1.0) || (probability < 0.0)) {
            System.out.println("probability is in range of 0-1");
            System.exit(-5);
        }
        final int finalNumbersOfBlocksOnX = numbersOfBlocksOnX;
        final int finalNumbersOfBlocksOnY = numbersOfBlocksOnY;
        final double finalFrequency = frequency;
        final double finalProbability = probability;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                var flickeringColorsDisplay = new FlickeringColorsDisplay(finalNumbersOfBlocksOnX, finalNumbersOfBlocksOnY, finalFrequency, finalProbability);
                flickeringColorsDisplay.setVisible(true);
            }
        });
    }
}
