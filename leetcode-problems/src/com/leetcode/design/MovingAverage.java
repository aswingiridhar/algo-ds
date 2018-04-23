package com.leetcode.design;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the
 * moving average of all integers in the sliding window.
 * For example,
 *  MovingAverage m = new MovingAverage(3);
 *  m.next(1)  = 1 / 1            = 1
 *  m.next(10) = (1 + 10) / 2     = 5.50000
 *  m.next(3)  = (1 + 10 + 3) / 3 = 4.66667
 *  m.next(5)  = (10 + 3 + 5) / 3 = 6.00000
 */

public class MovingAverage {
	
	LinkedList<Integer> queue;
	double avg;
	int size;
	
	public MovingAverage(int size) {
		this.size = size;
		this.queue = new LinkedList<Integer>();
	}
	
	public double next(int val) {
		
		if (queue.size() < size) {
			
			queue.offer(val);
			
			int sum = 0;
			
			for (int i : queue) {
				sum += i;
			}
			
			this.avg = (double)sum/queue.size();
			
			return this.avg;
		} else {
			// queue is full.
			
			double minus = (double)queue.poll()/size;
			
			double add = (double)val/size;
			
			queue.offer(val);
			
			this.avg = this.avg - minus + add;
			
			return this.avg;
		}
		
	}
	
	public static void main(String []args) {
		MovingAverage ma = new MovingAverage(5);
		
		System.out.println("Moving Avg after Inserting 5 : " + ma.next(5)); // expect 5
		System.out.println("Moving Avg after Inserting 4 : " + ma.next(4)); // expect 4.5
		System.out.println("Moving Avg after Inserting 3 : " + ma.next(3)); // expect 4
		System.out.println("Moving Avg after Inserting 2 : " + ma.next(2)); // expect 3.5
		System.out.println("Moving Avg after Inserting 1 : " + ma.next(1)); // expect 3
		System.out.println("Moving Avg after Inserting 1 : " + ma.next(10)); // expect 4
	}

}
