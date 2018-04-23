package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * 
 * @author agiridhar
 *
 */
public class MergeOverlappingIntervals {
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();

		Interval interval = new Interval(10, 14);
		intervals.add(interval);
		Interval interval1 = new Interval(11, 14);
		intervals.add(interval1);
		Interval interval2 = new Interval(13, 16);
		intervals.add(interval2);
		
		List<Interval> result = merge(intervals);
		
		for (Interval i : result) {
			System.out.println(String.format("[%d, %d]", i.start, i.end));
		}
		
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        
		if (intervals == null || intervals.size() < 2) {
			return intervals;
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		List<Interval> overlappedIntervals = new ArrayList<Interval>(); 
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for (int i = 1; i < intervals.size(); i++) {
			
			if (intervals.get(i).start <= end) {
				end = Math.max(end, intervals.get(i).end);
			} else {
				overlappedIntervals.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		
		overlappedIntervals.add(new Interval(start, end));
		
		return overlappedIntervals;
		
    }

}

