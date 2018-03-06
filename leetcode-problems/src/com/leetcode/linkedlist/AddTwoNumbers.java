package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * @author agiridhar
 *
 */
public class AddTwoNumbers {
	
	
	public static void main(String []args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l1next1 = new ListNode(4);
		ListNode l1next2 = new ListNode(8);

		l1.next = l1next1;
		l1next1.next = l1next2;

		ListNode l2 = new ListNode(2);
		ListNode l2next1 = new ListNode(7);
		ListNode l2next2 = new ListNode(9);

		l2.next = l2next1;
		l2next1.next = l2next2;
		
		printLinkedList(addTwoNumbers(l1, l2));
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode current1 = l1;
		ListNode current2 = l2;
		
		ListNode result = new ListNode(0);
		int carry = 0;
		
		ListNode addedNumbers = result;
		
		while (current1 != null || current2 != null || carry != 0) {
			
			int addedNumber = 0;
			
			if (current1 != null) {
				addedNumber += current1.val;
				current1 = current1.next;
			}
			
			if (current2 != null) {
				addedNumber += current2.val;
				current2 = current2.next;
			}
			
			addedNumbers.next = new ListNode( (addedNumber + carry) % 10);
			carry = (addedNumber + carry)/10;
			
			addedNumbers = addedNumbers.next;
			
		}
		
		return result.next;
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
