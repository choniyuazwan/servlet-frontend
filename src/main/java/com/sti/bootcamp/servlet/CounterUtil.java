package com.sti.bootcamp.servlet;

public class CounterUtil {
	private int counter;
	public CounterUtil() {
		counter = 0;
	}
	
	public int getCounter() {
		return ++counter;
	}
}
