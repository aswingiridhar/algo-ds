package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * 
 * @author agiridhar
 *
 */
public class RemoveElementsLinkedList {
	
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
		
		printLinkedList(removeElements(head, 1));
		
		
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		
		if (head == null) return null;
		
		while (head != null && head.val == val) {
			head = head.next;
		}
		
		ListNode current = head;
		ListNode prev = null;
		
		
		while (current != null) {
			if (current.val == val) {
				prev.next = current.next;
			} else {
				prev = current;
			}
			
			
			current = current.next;
		}
		
		
		return head;
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


