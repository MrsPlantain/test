package com.demo;

public class B extends A {
	
	public void m(){
		super.m();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new B();
		a.m();
	}

}
