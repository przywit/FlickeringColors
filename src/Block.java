import java.awt.*;

public class Block implements Runnable {
    private int blockSize = 20;
    private double probability;
    private double time;
    private int x;
    private int y;
    private int R;
    private int G;
    private int B;
    private Graphics2D graphics2D;

    public Block(){
    }

    public Block(double probability,double time,int x, int y, int R, int G, int B) {
        this.probability = probability;
        this.time = time;
        this.x = x;
        this.y = y;
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public void draw(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void setColor(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getBlockSize() {
        return blockSize;
    }

    @Override
    public void run() {
        graphics2D.setColor(new Color(R, G, B));
        graphics2D.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
    }
}
