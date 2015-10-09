package com.test1;

import org.junit.Test;

public class StringController {

	@Test
	public void test(){
		char[] str = "I Love Chinese".toCharArray();
		
		for(int i = 0; i < str.length; i++){
			char p = str[i];
			if(p == ' '){
				for(int j = i; j < str.length; j++){
					
				}
			}
		}
	}
}
