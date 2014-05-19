package de.logicalco.java8demo.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author Dominik Lange <dominik@logicalco.de>
 * @version 18.05.2014
 *
 */
public class FunctionalInterfacesDemo {
	
	private String state = "abc";
	
	public static void main(String[] args) {
		FunctionalInterfacesDemo demo = new FunctionalInterfacesDemo();
		demo.processObject(s -> String.valueOf(s.hashCode()));
		demo.processString(s -> String.valueOf(s.hashCode()));
		Test test = (a, b, c) -> {int var = a + b; return String.valueOf(var) + c;};
		System.out.println(test.test(1, 2, "!"));
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.submit(() -> System.out.println("Parallel code goes here"));
	}
	
	void processString(Processor<String, String> processor) {
		System.out.println(processor.process(state));
		System.out.println(processor.getClass().getSimpleName());
	}
	
	void processObject(ObejctProcessor<String> processor) {
		System.out.println(processor.process(state));
		System.out.println(processor.getClass().getSimpleName());
	}
	
	@FunctionalInterface
	public interface ObejctProcessor<T> {
		T process(Object t);
	}
	
	@FunctionalInterface
	public interface Processor<T,R> {
		R process(T t);
	}
	
	@FunctionalInterface
	public interface Test {
		String test(int x, int y, String z);
	}
}
