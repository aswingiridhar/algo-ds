package com.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find Median from Data Stream
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * Example:
 *   [2,3,4] , the median is 3
 *   [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to DS.
 * double findMedian()  - Return the median of all elements so far.
 * Example:
 *   add(1)
 *   add(2)
 *   findMedian() -> 1.5
 *   add(3)
 *   findMedian() -> 2
 */
public class MedianFinder {
	
	Queue<Long> small;
	Queue<Long> large;
	
	 /** initialize your data structure here. */
    public MedianFinder() {
    		small = new PriorityQueue<Long>();
    		large = new PriorityQueue<Long>();
    }
    
    public void addNum(int num) {
    	 	large.add((long) num);
    	 	small.add(-large.poll());
    	 	if (large.size() < small.size())
             large.add(-small.poll());
    }
    
    public double findMedian() {
    		return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
    
    
    public static void main(String []args) {
    		MedianFinder medianFinder = new MedianFinder();
    		
    		medianFinder.addNum(1);
    		medianFinder.addNum(5);
    		medianFinder.addNum(7);
    		
    		System.out.println("Median for {1,5,7} : " + medianFinder.findMedian()); // expected 5
    		
    		medianFinder.addNum(9);
    		
    		System.out.println("Median for {1,5,7,9} : " + medianFinder.findMedian()); // expected 6
    		
    		medianFinder.addNum(3);
    		
    		System.out.println("Median for {1,3,5,7,9} : " + medianFinder.findMedian()); // expected 5
    		
    		medianFinder.addNum(6);
    		
    		System.out.println("Median for {1,3,5,6,7,9} : " + medianFinder.findMedian()); // expected 5.5
    		
    		
    }
}
