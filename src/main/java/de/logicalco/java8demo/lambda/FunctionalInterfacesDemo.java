package de.logicalco.java8demo.lambda;


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
	
}
