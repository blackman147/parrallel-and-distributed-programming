import java.util.Random;

class CoinThread extends Thread{
        Random r = new Random();

    int head = 0;
    int tail = 1;
    int headCounter = 0;
    int tailCounter = 0;

    public void run() {

        for (int i = 0; i < 1000; i++) {
            int rand = r.nextInt(2);
            if (rand == head) {
                headCounter++;
            } else if (rand == tail) {
                tailCounter++;
            }
        }
    }

    public int getHeads() {
        return headCounter;
    }

    public int getTails() {
        return tailCounter;
    }

}


public class CoinTossing{
    public static void main(String[] args) {
        CoinThread coin = new CoinThread();
        coin.start();
        try {
            coin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("heads = "+coin.getHeads());
        System.out.println("tails = "+coin.getTails());
    }
}
