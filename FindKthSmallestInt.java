package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthSmallestInt {

    public static void main(String[] argv) {
        int[] arr= {7,10, 4,3,20,15};
        int k = 3;

        int kth_smallest = getkthSmallest(arr, k);
        System.out.println("kth_smallest: " + kth_smallest);
    }

    private static int getkthSmallest(int[] arr, int k) {
        int result = -1;
        Queue <Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int currentPoll;

        for(int i =0; i< arr.length; i++) {
            System.out.println("array index: " + i);
            maxHeap.add(arr[i]);
            System.out.println("After addition - currentPeak: " + maxHeap.peek());
            if (maxHeap.size() > k) {
                currentPoll = maxHeap.poll();
                System.out.println("currentPoll: " + currentPoll);
                System.out.println("After polling - currentPeak: " + maxHeap.peek());
            }
        }
        result = maxHeap.poll();
        return result;

    }

}
