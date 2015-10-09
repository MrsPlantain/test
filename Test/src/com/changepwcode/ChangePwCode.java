/**
 * Copyright (C), 2009-2012, 北京华热科技发展有限公司.<BR>
 * ProjectName:Test<BR>
 * File name:  ChangePwCode.java     <BR>
 * Author: chaolijuan  <BR>
 * Project:Test    <BR>
 * Version: v 1.0      <BR>
 * Date: 2015年10月9日 上午11:43:59 <BR>
 * Description:     <BR>
 * Function List:  <BR>
 */ 

package com.changepwcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.db.DBConnectionUtil;

/**
 * 功能描述：  .  <BR>
 * 历史版本: <Br>
 * 开发者: chaolijuan  <BR>
 * 时间：2015年10月9日 上午11:43:59  <BR>
 * 变更原因：    <BR>
 * 变化内容 ：<BR>
 * 首次开发时间：2015年10月9日 上午11:43:59 <BR>
 * 描述：   <BR>
 * 版本：V1.0
 */
public class ChangePwCode {

	/**
	 * 方法说明： . <BR>
	 * @see com.changepwcode.ChangePwCode <BR>
	 * @param args
	 * @return: void
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @Author: chaolijuan <BR>
	 * @Datetime：2015年10月9日 上午11:43:59 <BR>
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnectionUtil.connection();
		String listsql = "select username,user_id from sys_user";
		String sql = "update sys_user set password = ? where user_id = ?";
		PreparedStatement ps = conn.prepareStatement(listsql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String username = rs.getString("username");
			String user_id = rs.getString("user_id");
			String passwd = new SimpleHash("SHA-1", username, "1").toString();
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1, passwd);
			ps2.setString(2, user_id);
			ps2.executeUpdate();
			ps2.close();
		}
		
		rs.close();
		ps.close();
		conn.close();
	}

}
