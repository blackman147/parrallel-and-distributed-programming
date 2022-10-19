package lab04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewingStand {

    Lock lock = new ReentrantLock();
    private int max;
    Condition cond = lock.newCondition();
    private int seats[];
    private int available;

    public ViewingStand(int max){
        this.max = max;
//        this.available = max;
        seats = new int[max];
        for (int i = 0; i < max; i++) {
            seats[i] = -1;
        }

    }

    public void findSeat(int number){
        lock.lock();
        try{
            while(available != 0){
                try{
                    cond.await();
                }catch(InterruptedException e){}
            }
            int k = 0;
            while(seats[k] != -1) k++;
            seats[k] = number;
            available--;

        }finally{ lock.unlock(); }


    }
    public void leaveSeat(int number){

        lock.lock();
        try{
            int k = 0;
            while (seats[k] != number) {
                k++;
            }
            seats[k] = -1;
            available++;
            cond.signal();
        } finally{lock.unlock();}
    }

}
