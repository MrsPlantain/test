package com.demo;

public class A {

	public void m(){
		if(this instanceof A){
			System.out.println("I am a A object");
		}
		if(this instanceof B){
			System.out.println("I am a B object");
		}
	}
}
