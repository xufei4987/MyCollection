package com.youxu.queue;

import java.util.Stack;

//利用两个栈实现队列
public class Queue2<E> {
	private Stack<E> mainStack;
	private Stack<E> assistantStack;
	private int capacity;
	public Queue2(int capacity) {
		if(capacity <= 0) {
			System.out.println("illegal argument exception");
			return;
		}
		mainStack = new Stack<E>();
		assistantStack = new Stack<E>();
		this.capacity = capacity;
	}
	public void enQueue(E e) {
		if(capacity == mainStack.size()) {
			System.out.println("queue is full");
			return;
		}
		mainStack.push(e);
	}
	public E deQueue() {
		if(mainStack.size() == 0) {
			System.out.println("queue is empty");
			return null;
		}
		while(mainStack.size() > 0) {
			E e = mainStack.pop();
			assistantStack.push(e);
		}
		E re = assistantStack.pop();
		while(assistantStack.size() > 0) {
			E e = assistantStack.pop();
			mainStack.push(e);
		}
		return re;
	}
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < mainStack.size(); i++) {
			str += "mainStack["+i+"]="+mainStack.get(i)+"\n";
		}
		return str;
	}
	public static void main(String[] args) {
		Queue2<String> queue2 = new Queue2<>(5);
		queue2.enQueue("1");
		queue2.enQueue("2");
		queue2.enQueue("3");
		queue2.enQueue("4");
		queue2.enQueue("5");
		System.out.println(queue2.deQueue());
		System.out.println(queue2);
	}
}
