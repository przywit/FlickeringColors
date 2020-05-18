public class Block {
    int blockSize = 20;
    double time;
    int x;
    int y;
    int R;
    int G;
    int B;

    public Block(){

    }

    public Block(double time,int x, int y, int R, int G, int B) {
        this.time = time;
        this.x = x;
        this.y = y;
        this.R = R;
        this.G = G;
        this.B = B;
    }
    Thread thread = new Thread(() -> {

    });


    public int getBlockSize() {
        return blockSize;
    }
}
