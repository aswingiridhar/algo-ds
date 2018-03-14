package com.leetcode.stack;

import java.util.Stack;

public class QueueUsingStack {
	
	Stack<Integer> queue = new Stack<Integer>();
	
	public void enqueue(Integer data) {
		
		Stack<Integer> temp = new Stack<Integer>();
		
		while (!queue.empty()) {
			temp.push(queue.pop());
		}
		queue.push(data);
		
		while (!temp.empty()) {
			queue.push(temp.pop());
		}
	}
	
	public void printQueue() {
		System.out.println("Queue is:");
		for(int i=0; i<queue.size(); i++) {
			System.out.println(queue.get(i));
		}
	}
	
	public void dequeue() {
		queue.pop();
	}
	
	
	public boolean empty() {
		return queue.empty();
	}
	
	public static void main(String []args) {
		
		QueueUsingStack q = new QueueUsingStack();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.printQueue();
		q.dequeue();
		q.printQueue();
		
		
	}

}
