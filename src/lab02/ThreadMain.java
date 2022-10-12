package lab02;

import java.util.Arrays;

public class ThreadMain {


    private static int[] findSlice(int[] arrayToSlice, int startIndex, int endIndex) {
        int[] slicedArray = Arrays.stream(arrayToSlice, startIndex, endIndex).toArray();
        return slicedArray;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int a[] = new int[n];

        for (int j = 0; j < a.length; j++)
            a[j] = (int) (Math.random() * n);

        int nThreads = Runtime.getRuntime().availableProcessors();

        EvenNoCounter workers[] = new EvenNoCounter[nThreads];
        Thread threadArray[]= new Thread[nThreads];

        int index[] = new int[nThreads + 1];

        for (int j = 0; j <= nThreads; j++)
            index[j] = (j * n) / nThreads;

        int[][] slicedArraysToDistribute = new int[nThreads][];
        for (int i = 0; i < index.length; i++) {
            if (i != 0) {
                int[] slicedArray = findSlice(a, index[i-1], index[i]);
                slicedArraysToDistribute[i-1] = slicedArray;
            }
        }

        for (int i = 0; i < slicedArraysToDistribute.length; i++) {
            workers[i]=new EvenNoCounter(slicedArraysToDistribute[i]);
            threadArray[i]= new Thread(workers[i]);
            threadArray[i].start();

        }
//            for each_array in slicedArraysToDistribute
//                pass each_array to thread object

        long startTime = System.currentTimeMillis();

        //wait for workers to finish
        try {
            for (int j = 0; j < workers.length; j++)
                threadArray[j].join();
        } catch (InterruptedException e) {
        }
        int freq = 0;
        for (int j = 0; j < workers.length; j++)
            freq = freq + workers[j].freq();
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;
        System.out.printf("Number of even in range %d to %d = %d\n", 1, n, freq);
        System.out.println(runningTime + " millisecs (" + (runningTime / 1000.0) +
                ")secs");

    }
}
