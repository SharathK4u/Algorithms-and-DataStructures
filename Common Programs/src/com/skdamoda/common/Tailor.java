package com.skdamoda.common;

import java.util.ArrayList;
import java.util.List;

public class Tailor{
	public static void main(String [] args) {
		List list = new ArrayList();
		int maxSize=10;
		int minSize=0;
		Thread t1 = new Thread(new Design(list,maxSize,minSize));
		Thread t2 = new Thread(new Stitch(list,maxSize,minSize));
		t1.start();
		t2.start();
}
}
class Design implements Runnable{
	List list;
	int maxSize;
	int minSize;
	Design(List list,int maxSize,int minSize){
		this.list=list;
		this.maxSize=maxSize;
		this.minSize=minSize;
	}
	@Override
	public void run() {
		int i=0;
		synchronized(list) {
			while(true) {
			if(list.size()>maxSize) {
				try {
					System.out.println("Total cloth pending to stitch more than "+maxSize);
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				list.notifyAll();
				System.out.println("Designing the cloth number"+i);
				list.add(i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i=i+1;
			}
			}
		}
	}
}

class Stitch implements Runnable {
	List list;
	int maxSize;
	int minSize;
	Stitch(List list,int maxSize,int minSize){
		this.list=list;
		this.maxSize=maxSize;
		this.minSize=minSize;
	}
	public void run() {
	synchronized(list) {
		while(true) {
		if(list.size()<minSize) {
			try {
				System.out.println("The designs available is less than "+minSize);
				list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Stitching the cloth");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.remove(0);
			list.notifyAll();
		}
		}
	}
	}
}