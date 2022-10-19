package lab04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private int x;
    private boolean item;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    public Buffer(){item = false;}
    public int read(){
        lock.lock();
        try{
            while(!item)
                try{full.await();}
                catch(InterruptedException e){}
            item = false;
            empty.signal();
            return x;
        }finally{lock.unlock();}
    }
    public void write(int k){
        lock.lock();
        try{
            while(item)
                try{empty.await();}
                catch(InterruptedException e){}
            x = k; item = true;
            full.signal();
        }finally{lock.unlock();}
    }

}
