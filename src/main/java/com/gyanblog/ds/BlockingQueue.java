package com.gyanblog.ds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

class BlockingQueue {
	private ReentrantLock lock;
	private Queue<Integer> queue;
	private int size;
	
	public BlockingQueue() {
		this.lock = new ReentrantLock(true);
		this.queue = new LinkedList<Integer>();
		this.size = 2;
	}
	
	private void printQueue() {
		Iterator<Integer> iter = this.queue.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print(" -> ");
		}
		System.out.println();
	}
	
	private void log(String msg) {
		System.out.println(msg + ", Thread: " + Thread.currentThread().getName());
	}
	public void push(int val) {
		this.lock.lock();
		
		try {
			if (this.queue.size() > this.size) {
				this.log("Queue full. Waiting");
				try {
					this.lock.unlock();
					wait();
				} catch(InterruptedException ie) {
					this.log("Thread interruppted...");
					Thread.currentThread().interrupt();
				}
			}
			
			//
			this.queue.add(val);
			this.log("Successfully pushed");
			printQueue();
			
			notifyAll();
		} finally {
			this.lock.unlock();
		}
	}
	
	public void pop() {
		if (this.queue.size() <= 0) {
			this.log("Queue empty. Waiting");
			try {
				wait();
			} catch(InterruptedException ie) {
				this.log("Thread interruppted...");
				Thread.currentThread().interrupt();
			}
		}
		
		this.queue.remove();
		this.log("Successfully Removed from queue");
		printQueue();
	}
	
	public static void sleep(int ms) {
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BlockingQueue q = new BlockingQueue();
		
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<10; i++) {
					q.push(10 * i);
					sleep(500);
					
				}
			}
		});
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				q.pop();
				sleep(1000);
			}
		});
		
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
		
		System.out.println("Ends");
	}
}
