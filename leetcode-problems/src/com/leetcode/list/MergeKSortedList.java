package com.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.leetcode.linkedlist.ListNode;

/**
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 *  Given K sorted integer lists, merge them as one sorted list
 * 
 * @author agiridhar
 *
 */
public class MergeKSortedList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l1next1 = new ListNode(4);
		ListNode l1next2 = new ListNode(8);
		ListNode l1next3 = new ListNode(10);
		ListNode l1next4 = new ListNode(12);

		l1.next = l1next1;
		l1next1.next = l1next2;
		l1next2.next = l1next3;
		l1next3.next = l1next4;

		ListNode l2 = new ListNode(2);
		ListNode l2next1 = new ListNode(9);
		ListNode l2next2 = new ListNode(11);

		l2.next = l2next1;
		l2next1.next = l2next2;
		
		ListNode l3 = new ListNode(3);
		ListNode l3next1 = new ListNode(5);
		ListNode l3next2 = new ListNode(7);

		l3.next = l3next1;
		l3next1.next = l3next2;
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		
//		printLinkedList(mergeKListsUsingPriorityQueue(list.toArray(new ListNode[list.size()])));
		printLinkedList(mergeKLists(list.toArray(new ListNode[list.size()])));
		
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		List<ListNode> list = Arrays.asList(lists);
		
		if (list.size() == 0) return null;
		if (list.size() == 1) return lists[0];
		if(list.size() == 2) return mergeTwoLists(lists[0], lists[1]);
		return mergeTwoLists(mergeKLists(list.subList(0, list.size()/2).toArray(new ListNode[list.size()/2])), 
	            mergeKLists(list.subList(list.size()/2, list.size()).toArray(new ListNode[list.size() - list.size()/2])));
		
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		
		if (l2 == null) return l1;
		
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
		
	}
	
	public static ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) {
					return -1;
				} else if (o1.val > o2.val) {
					return 1;
				}
				return 0;
			}
			
		});
		
		ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
		
		for (ListNode node : lists) {
			if (node != null)
				queue.add(node);
		}
		
		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;
			
			if (tail.next != null) {
				queue.add(tail.next);
			}
		}
		
		return dummy.next;
        
    }
	
	public static void printLinkedList(ListNode head) {
		
		while(head != null) {
			System.out.print(head.val);
			if (head.next != null) {
				System.out.print("->");
			}
			
			head = head.next;	
		}
		
	}

}
