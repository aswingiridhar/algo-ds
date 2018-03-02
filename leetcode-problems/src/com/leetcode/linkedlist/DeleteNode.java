package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 
 * @author agiridhar
 *
 */
public class DeleteNode {
	
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
		
		deleteNode(head);
		printLinkedList(head);
		
	}
	
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
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
