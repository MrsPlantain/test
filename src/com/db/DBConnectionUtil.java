/**
 * Copyright (C), 2009-2012, 北京华热科技发展有限公司.<BR>
 * ProjectName:Test<BR>
 * File name:  DBConnectionUtil.java     <BR>
 * Author: chaolijuan  <BR>
 * Project:Test    <BR>
 * Version: v 1.0      <BR>
 * Date: 2015年10月9日 下午1:30:38 <BR>
 * Description:     <BR>
 * Function List:  <BR>
 */

package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.prop.PropertiesUtil;

/**
 * 功能描述： . <BR>
 * 历史版本: <Br>
 * 开发者: chaolijuan <BR>
 * 时间：2015年10月9日 下午1:30:38 <BR>
 * 变更原因： <BR>
 * 变化内容 ：<BR>
 * 首次开发时间：2015年10月9日 下午1:30:38 <BR>
 * 描述： <BR>
 * 版本：V1.0
 */
public class DBConnectionUtil {

	private static Connection conn;

	static {
		try {
			Class.forName(PropertiesUtil.get("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection connection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(PropertiesUtil.get("url"), PropertiesUtil.get("user"),
						PropertiesUtil.get("password"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
}
