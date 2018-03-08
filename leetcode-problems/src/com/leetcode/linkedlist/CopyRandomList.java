package com.leetcode.linkedlist;

/**
 * 
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * 
 * @author agiridhar
 *
 */
public class CopyRandomList {
	
	public static void main(String []args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode next1 = new RandomListNode(2);
		RandomListNode next2 = new RandomListNode(3);
		RandomListNode random1 = next2;
		RandomListNode random2 = next1;
		RandomListNode random3 = null;
		
		head.next = next1;
		head.random = random1;
		next1.next = next2;
		next1.random = random2;
		next2.random = random3;
		
		printRandomListNode(head);
		System.out.println("");
		
		printRandomListNode(copyRandomList(head));
		
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		
		if (head == null) return head;
		
		RandomListNode copyPtr = new RandomListNode(0);
		
		RandomListNode copyHead = copyPtr;
		
		
		while (head != null) {
			
			copyPtr.next = new RandomListNode(head.label);
			if (head.random != null) {
				copyPtr.next.random = new RandomListNode(head.random.label);
			}
			
			copyPtr = copyPtr.next;
			
			head = head.next;
		}
		
        return copyHead.next;
    }
	
	public static void printRandomListNode(RandomListNode head) {
		
		while(head != null) {
			System.out.print(head.label);
			System.out.print("(random:" + (head.random == null ? "null" : head.random.label) + ")");
			if (head.next != null) {
				System.out.print("->");
			}
			
			head = head.next;	
		}
		
	}

}
