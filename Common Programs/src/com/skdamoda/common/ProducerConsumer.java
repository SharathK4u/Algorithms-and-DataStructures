package com.skdamoda.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ProducerConsumer {
	public static void main(String [] args) throws InterruptedException {
		List list = new ArrayList();
		Manager tailor = new Manager(list,0,10);
		CountDownLatch latch = new CountDownLatch(10);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					tailor.design(latch);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					tailor.stitch();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					tailor.design(latch);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t3.start();
		latch.await();
		//Stitching starts only after 10 Desings are ready.
		t2.start();
	}
}

class Manager {
	List list;
	int minSize;
	int maxSize;
	public Manager(List list, int minSize, int maxSize){
		this.list=list;
		this.minSize=minSize;
		this.maxSize=maxSize;
	}

	public void design(CountDownLatch latch) {
		synchronized(this) {
			if(list.size()>=maxSize) {
				System.out.println("Designs more than enough. Exceeded "+maxSize);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				list.add("Dress");
				System.out.println("Adding a new Dress Design to the list. List size is "+list.size());
				latch.countDown();
				notifyAll();
			}
		}
	}
	public void stitch() {
		synchronized(this) {
			if(list.size()<minSize) {
				System.out.println("Not enough designs available. Waiting "+minSize);
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!list.isEmpty()) {
				list.remove(0);
				System.out.println("Stitching a dress and removing from List. List size is "+list.size());
				notifyAll();
			}
			else {
				System.out.println("List is empty which is strange. Should not reach this phase.");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}