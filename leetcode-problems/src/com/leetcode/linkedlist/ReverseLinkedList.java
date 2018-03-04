package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list/description/
 * 
 * @author agiridhar
 *
 */
public class ReverseLinkedList {
	
	public static void main(String [] args) {
		
		ListNode head = new ListNode(1);
		ListNode next1 = new ListNode(2); 
		ListNode next2 = new ListNode(3); 
		ListNode next3 = new ListNode(4);
		ListNode next4 = new ListNode(1);
		
		head.next = next1;
		next1.next = next2;
		next2.next = next3;
		next3.next = next4;
		
		printLinkedList(head);
		
		System.out.println("");
		
//		printLinkedList(reverseListIterative(head));
//		System.out.println("");
		printLinkedList(reverseListRecursive(head));
		
	}
	
	public static ListNode reverseListIterative(ListNode head) {
		
		ListNode newHead = null;
		
		while (head != null) {
			
			ListNode next = head.next;
			
			head.next = newHead;
			
			newHead = head;
			
			head = next;
		}
		
		return newHead;
		
	}
	
	public static ListNode reverseListRecursive(ListNode head) {
		
		return reverseList(head, null);
		
    }
	
	public static ListNode reverseList(ListNode head, ListNode newHead) {
		
		if (head == null) {
			return newHead;
		}
		
		ListNode next = head.next;
		head.next = newHead;
		return reverseList(next, head);
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
