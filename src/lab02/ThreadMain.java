package lab02;

public class ThreadMain {
    public static void main(String[] args) {
       /* int f[] = new int[1000000];
        for(int j = 0; j < f.length;j++) f[j] = (int)(Math.random()*100000);
        int freq = 0;
        for(int j = 0; j < f.length; j++)
            if(f[j] % 2 == 0) freq++;
        System.out.println(freq);*/

            int n = 1000000;
            int a[] = new int[n];

            for(int j = 0; j < a.length;j++)
                a[j] = (int)(Math.random()*n);

            int nThreads = Runtime.getRuntime().availableProcessors();

            EvenNoCounter workers[] = new EvenNoCounter[nThreads];

            int index[] = new int[nThreads+1];

            for(int j = 0; j <= nThreads; j++)
                index[j] = (j*n)/nThreads;
            long startTime = System.currentTimeMillis();

            for(int j = 0; j < workers.length; j++){
                workers[j] = new EvenNoCounter(a, index[j], index[j+1]);
                workers[j].start();
            }
            //wait for workers to finish
            try{
                for(int j = 0; j < workers.length; j++)
                    workers[j].join();
            }
            catch(InterruptedException e){}
            int freq = 0;
            for(int j = 0; j < workers.length; j++)
                freq = freq + workers[j].freq();
            long endTime = System.currentTimeMillis();
            long runningTime = endTime-startTime;
            System.out.printf("Number of even in range %d to %d = %d\n", 1,n,freq);
            System.out.println(runningTime + " millisecs (" +(runningTime/1000.0) +
                    ")secs");

    }
}
