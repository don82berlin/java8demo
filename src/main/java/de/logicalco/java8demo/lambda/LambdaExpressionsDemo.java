package de.logicalco.java8demo.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Dominik Lange <dominik@logiclco.de>
 * @version 19.05.2014
 *
 */
public class LambdaExpressionsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		final ExecutorService threadPool = Executors.newFixedThreadPool(10);
		AtomicInteger val = new AtomicInteger(0);
		for(int i=0; i < 10; i++) {
			final int index = i;
			threadPool.execute(() -> {
				System.out.println("Thread " + index + " updated val to " + val.incrementAndGet());
			});
		}
		Thread.sleep(100);
		threadPool.shutdown();
	}

}
