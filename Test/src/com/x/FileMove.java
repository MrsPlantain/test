package com.x;

import java.io.File;

public class FileMove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void moveFile(String filePath){
		File file = new File(filePath);
		File[] subFiles = file.listFiles();
		File newFloder = new File("D:\newFloder");
		for(File subFile : subFiles){
			if(subFile.isAbsolute()){
				File[] subSubFiles = subFile.listFiles();
				for(File subSubFile : subSubFiles){
					if(subSubFile.getName().endsWith(".doc")){
					}
				}
			}
		}
	}

}
