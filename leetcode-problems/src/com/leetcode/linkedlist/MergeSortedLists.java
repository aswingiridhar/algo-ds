package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 
 * @author agiridhar
 *
 */
public class MergeSortedLists {

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
		
		printLinkedList(mergeTwoLists(l1, l2));
		
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
