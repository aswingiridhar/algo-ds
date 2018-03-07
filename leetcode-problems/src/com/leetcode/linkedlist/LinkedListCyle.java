package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 
 * @author agiridhar
 *
 */
public class LinkedListCyle {
	
	public static void main(String []args) {
		ListNode head = new ListNode(1);
		ListNode next1 = new ListNode(2); 
		ListNode next2 = new ListNode(3); 
		ListNode next3 = new ListNode(4);
		
		head.next = next1;
		next1.next = next2;
		next2.next = next3;
		next3.next = next1;
		
		
		System.out.println("hasCycle: " + hasCycle(head));
		printLinkedList(detectCycle(head));
	}
	
	
	public static boolean hasCycle(ListNode head) {
        
		if (head == null) return false;
		
		ListNode walker = head;
		ListNode runner = head;
		
		
		while(runner != null && runner.next !=null) {
			
			walker = walker.next;
			runner = runner.next.next;
			
			if (walker == runner) return true;
		}
		
		return false;
    }
	
	public static ListNode detectCycle(ListNode head) {
        
		if (head == null) return null;
		
		ListNode walker = head;
		ListNode runner = head;
		
		
		while(runner != null && runner.next !=null) {
			
			walker = walker.next;
			runner = runner.next.next;
			
			if (walker == runner) {
				break;
			}
		}
		
		if (runner == null || runner.next == null) return null;
		
		walker = head;
		
		while (walker != runner) {
			walker = walker.next;
			runner = runner.next;
		}
		
		return walker;
		
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
