package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 * 
 * @author agiridhar
 *
 */

class Interval {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MeetingRooms {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();

		Interval interval = new Interval(10, 14);
		intervals.add(interval);
		Interval interval1 = new Interval(11, 14);
		intervals.add(interval1);
		Interval interval2 = new Interval(13, 16);
		intervals.add(interval2);

		System.out.println("canAttendMeetings: " + canAttendMeetings(intervals.toArray(new Interval[intervals.size()])));
		
		System.out.println("Rooms needed: " + minMeetingRooms(intervals.toArray(new Interval[intervals.size()])));

	}

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		if (intervals.length == 1)
			return 1;

		// sort by start times
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		
		int count = 1;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.offer(intervals[0].end);
		
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}
			
			queue.offer(intervals[i].end);
		}
		
		
		return count;
		
	}

	public static boolean canAttendMeetings(Interval[] intervals) {

		if (intervals == null || intervals.length == 0)
			return false;

		if (intervals.length == 1)
			return true;

		// sort by start times
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}

		return true;

	}

}
