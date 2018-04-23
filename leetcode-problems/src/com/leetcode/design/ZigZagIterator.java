package com.leetcode.design;

import java.util.Arrays;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their
 * elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,3,2,4,5,6].
 * Follow up: What if you are given k 1d vectors? How well can
 * your code be extended to such cases?
 */
public class ZigZagIterator {
	
	List<Integer> v1;
	List<Integer> v2;
	int i,j;
	
	public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		i = j = 0;
	}
	
	public boolean hasNext() {
		return (i < v1.size() || j < v2.size());  
	}
	
	public int next() {
		
		if (!hasNext()) return -1;
		
		int result = 0;
		
		if ((i <= j && i < v1.size()) || j == v2.size()) {
			result = v1.get(i);
			i++;
		} else {
			result = v2.get(j);
			j++;
		}
		
		return result;
	}
	
	
	public static void main(String []args) {
		Integer[] list1 = {1, 3, 5, 6, 7};
		Integer[] list2 = {2, 4};
		
		ZigZagIterator iter = new ZigZagIterator(Arrays.asList(list1), Arrays.asList(list2));
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}
	
}
