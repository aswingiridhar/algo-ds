package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/rotate-list/description/
 * 
 * @author agiridhar
 *
 */
public class RotateList {
	
	public static void main(String [] args) {
		
		ListNode head = new ListNode(1);
		ListNode next1 = new ListNode(2); 
		ListNode next2 = new ListNode(3); 
		ListNode next3 = new ListNode(4);
		ListNode next4 = new ListNode(5);
		
		head.next = next1;
		next1.next = next2;
		next2.next = next3;
		next3.next = next4;
		
		printLinkedList(head);
		
		System.out.println("");
		
		printLinkedList(rotateRight(head, 2));
		
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		
		if (head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(0);
		
		dummy.next = head;
		
		ListNode slow = dummy, fast = dummy;
		
		// find the length of the list
		int len = 0;
		
		while (fast.next != null) {
			fast = fast.next;
			len++;
		}
		
		// move till (len - (k mod len) spaces)
		int i = 0;
		while (slow.next != null && i < (len - (k%len))) {
			slow = slow.next;
			i++;
		}
		
		// fast (5)
		// slow (3)
		
		// do the rotation
		fast.next = dummy.next;
		dummy.next = slow.next;
		// break the rotation
		slow.next = null;
		
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
