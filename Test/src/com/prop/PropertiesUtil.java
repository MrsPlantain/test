/**
 * Copyright (C), 2009-2012, 北京华热科技发展有限公司.<BR>
 * ProjectName:Test<BR>
 * File name:  PropertiesUtil.java     <BR>
 * Author: chaolijuan  <BR>
 * Project:Test    <BR>
 * Version: v 1.0      <BR>
 * Date: 2015年10月9日 下午1:08:52 <BR>
 * Description:     <BR>
 * Function List:  <BR>
 */ 

package com.prop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * 功能描述：  .  <BR>
 * 历史版本: <Br>
 * 开发者: chaolijuan  <BR>
 * 时间：2015年10月9日 下午1:08:52  <BR>
 * 变更原因：    <BR>
 * 变化内容 ：<BR>
 * 首次开发时间：2015年10月9日 下午1:08:52 <BR>
 * 描述：   <BR>
 * 版本：V1.0
 */
public class PropertiesUtil {
	
	private static Properties prop= new Properties();
	private static String filePath = "com/db.properties";
	
	static{
		try {
			prop.load(ClassLoader.getSystemResourceAsStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load(String _filePath){
		try {
			prop.load(ClassLoader.getSystemResourceAsStream(_filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties prop(){
		return prop;
	}
	
	public static String get(String key){
		return prop.getProperty(key);
	}
	
	@Test
	public void test(){
		System.out.println(prop);
	}
}
