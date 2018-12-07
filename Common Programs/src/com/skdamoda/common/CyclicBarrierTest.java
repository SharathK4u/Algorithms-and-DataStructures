package com.skdamoda.common;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierTest {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException, TimeoutException {
		CyclicBarrier cb = new CyclicBarrier(4);
		System.out.println("Created");
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					cb.await();
					System.out.println("First Awaiting in t1");
					Thread.sleep(1000);
					System.out.println("Awaiting in t1");
					Thread.sleep(1000);
					cb.await();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Awaiting in t2");
					cb.await();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
		t2.start();
		cb.await(5000,TimeUnit.MILLISECONDS);
		System.out.println("Waiting thrice");
		System.out.println("No wait");
		
		
	}

}
