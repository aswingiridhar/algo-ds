package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are 
being made to the system in chronological order (ie, the timestamp is monotonically increasing). 
You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.
 * 
 * @author agiridhar
 *
 */
public class HitCounter {
	
	private Queue<Integer> queue;
	
	private static final Integer MAX_DURATION = 60 * 5;
	
	public HitCounter() {
		queue = new LinkedList<Integer>();
	}
	
	public void hit(int timestamp) {
		queue.add(timestamp);
	}

	
	public int getHits(int timestamp) {
		
		while (!queue.isEmpty()) {
			if (timestamp - queue.peek() > MAX_DURATION) {
				queue.poll();
			}
		}
		return queue.size();
	}
	
	public static void main(String []args) {
		
	}
}
