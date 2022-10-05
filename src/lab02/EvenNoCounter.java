package lab02;

public class EvenNoCounter extends Thread {


    private int[] eArr;
    private int lowerBound;
    private int upperBound;
    int freq = 0;
    public EvenNoCounter(int[] eArr, int a, int b){
        this.eArr = eArr;
        this.lowerBound = a;
        this.upperBound = b;
    }


    public void run(){
        freq = 0;
        for(int k = lowerBound; k < upperBound; k++)
            if(k % 2 == 0) freq++;
    }
    public int freq(){return freq;}



}
