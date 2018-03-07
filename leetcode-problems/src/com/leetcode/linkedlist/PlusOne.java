package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/** 
 * Given a non-negative number represented as a singly
 * linked list of digits, plus one to the number.
 * The digits are stored such that the most significant
 * digit is at the head of the list.
 * Example:
 * Input: 1->2->3
 * Output:1->2->4
 */
public class PlusOne {
	
	public static void main (String []args) {
		
		ListNode head = new ListNode(1);
		ListNode next1 = new ListNode(2); 
		ListNode next2 = new ListNode(3); 
		ListNode next3 = new ListNode(4);
		
		head.next = next1;
		next1.next = next2;
		next2.next = next3;
		
		printLinkedList(head);
		
		System.out.println("");
		
		printLinkedList(plusOne(head));
		
	}
	
	public static ListNode plusOne(ListNode head) {
		
		if (head == null) return head;
		
		ListNode current = head;
		
		List<Integer> nodes = new ArrayList<Integer>();
		
		while (current != null) {
			
			nodes.add(current.val);
			current = current.next;
		}
		
		// stores the previous value
		ListNode rightDigit = null;
        
		// stores the current values
		ListNode result = null;
		
		int carry = 1;
		
		for (int i=nodes.size()-1;i>=0;i--) {
			Integer addedNumber = nodes.get(i)+carry;
			result = new ListNode(addedNumber%10);
			carry = addedNumber/10;
			result.next = rightDigit;
			rightDigit = result;
		}
		
		if (carry > 0) {
			result = new ListNode(carry);
			result.next = rightDigit;
		}
		
		return result;
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
