package lab02;

public class EvenNoCounter implements Runnable {


    private int[] eArr;
    private int lowerBound;
    private int upperBound;
    int freq = 0;
    public EvenNoCounter(int[] eArr) {
        this.eArr = eArr;
        this.freq = 0;
    }

    @Override
    public void run(){
        this.freq = 0;
        for(int k =0 ; k < eArr.length; k++)
            if(k % 2 == 0) freq++;
    }
    public int freq(){return this.freq;}



}
