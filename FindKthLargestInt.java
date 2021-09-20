package test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargestInt {

    public static void main(String[] argv) {
        int[] arr= {7,10, 4,3,20,15};
        int k = 3;

        int kthLargest = getkthLargest(arr, k);
        System.out.println("kthLargest: " + kthLargest);
    }

    private static int getkthLargest(int[] arr, int k) {
        int result = -1;
        Queue <Integer> minHeap = new PriorityQueue<Integer>();
        int currentPoll;

        for(int i =0; i< arr.length; i++) {
            System.out.println("array index: " + i);
            minHeap.add(arr[i]);
            System.out.println("After addition - currentPeak: " + minHeap.peek());
            if (minHeap.size() > k) {
                currentPoll = minHeap.poll();

                System.out.println("currentPoll: " + currentPoll);
                System.out.println("After polling - currentPeak: " + minHeap.peek());
            }
        }
        result = minHeap.poll();
        return result;

    }

}
