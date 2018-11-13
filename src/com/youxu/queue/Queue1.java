package com.youxu.queue;
//利用循环数组的思想实现一个队列
public class Queue1<E> {

	Object[] Elements;
	int front; //对头下标
	int rear;//对尾下标
	
	public Queue1(int capacity) {
		if(capacity <= 0) {
			System.out.println("illegal argument exception");
			return;
		}
		Elements = new Object[capacity];
	}
	
	public void enQueue(E e) {
		if((rear+1)%Elements.length == front) {
			System.out.println("queue is full");
			return;
		}
		Elements[rear] = e;
		if(rear == Elements.length-1) {
			rear = 0;
		}else {
			rear++;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public E deQueue() {
		if(rear == front) {
			System.out.println("queue is empty");
			return null;
		}
		E e = (E) Elements[front];
		Elements[front] = null;
		if(front == Elements.length-1) {
			front = 0;
		}else {
			front++;
		}
		return e;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for(int i = 0; i < Elements.length; i++) {
			str += "Elements["+i+"]="+Elements[i]+"\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Queue1<String> queue1 = new Queue1<>(5);
		queue1.enQueue("1");
		queue1.enQueue("2");
		queue1.enQueue("3");
		System.out.println(queue1.deQueue());
		System.out.println(queue1.deQueue());
		queue1.enQueue("4");
		queue1.enQueue("5");
		queue1.enQueue("6");
		System.out.println(queue1.deQueue());
		System.out.println(queue1.deQueue());
		System.out.println(queue1.deQueue());
		System.out.println(queue1.deQueue());
		System.out.println(queue1);
	}
	
	
}
