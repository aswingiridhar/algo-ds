package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * 
 * @author agiridhar
 *
 */
public class ReverseLinkedListRange {
	
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
		printLinkedList(reverseBetween(head, 2, 4));
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        
		ListNode newHead = new ListNode(0);
		newHead.next = head; // 0,1,2,3,4,1
		
		ListNode pre = newHead; // 0,1,2,3,4,1
		
		for (int i=0; i< m-1; i++) {
			pre = pre.next; // pre = 1,2,3,4,1
		}
		
		ListNode start = pre.next; // 2,3,4,1
		ListNode then = start.next; // 3,4,1
		
		for (int i=0; i<(n-m); i++) {
			start.next = then.next; 
			then.next = pre.next;  
			pre.next = then;
			then = start.next;
		}
		
		
		
		return newHead.next;
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
