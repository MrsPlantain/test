/**
 * Copyright (C), 2009-2012, 北京华热科技发展有限公司.<BR>
 * ProjectName:Test<BR>
 * File name:  T.java     <BR>
 * Author: chaolijuan  <BR>
 * Project:Test    <BR>
 * Version: v 1.0      <BR>
 * Date: 2015年9月9日 下午3:45:09 <BR>
 * Description:     <BR>
 * Function List:  <BR>
 */ 

package com;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;


/**
 * 功能描述：  .  <BR>
 * 历史版本: <Br>
 * 开发者: chaolijuan  <BR>
 * 时间：2015年9月9日 下午3:45:09  <BR>
 * 变更原因：    <BR>
 * 变化内容 ：<BR>
 * 首次开发时间：2015年9月9日 下午3:45:09 <BR>
 * 描述：   <BR>
 * 版本：V1.0
 */
public class T {
	
	private static String insertsql = "insert into INFO_BUILDINGS (building_num, city, district, road, door_num, uptown_name, build_year, total_floor, unit_num, rights_unit, use_type, build_area, use_area, total_door_num, hot_unit, hotstation, wymc, streetoffice_name, communityoffice_name, code, uptown_other_name, jzmc, address, streetoffice_code, communityoffice_code, original_manage_company, subcompany, relation_code, uptown_code, hotstation_code, is_cal_device, is_cal_charge, swipe_model, uuid, uptown_uuid, hot_unit_id, subcompany_id, grid_reform_date) ";
	
	
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
		File file = new File("D:/buildings.sql");
		File outfile = new File("D:/idcouldntmatch.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile)));
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmp?Unicode=true&characterEncoding=utf8&user=root&password=123456");
		PreparedStatement st = conn.prepareStatement("select * from info_buildings where uuid = ?");
		Pattern pattern = Pattern.compile("[a-z|0-9]{8}-[a-z|0-9]{4}-[a-z|0-9]{4}-[a-z|0-9]{4}-[a-z|0-9]{12}");
		String line = br.readLine();
		int count = 0;
		int k = 0;
		while(line != null){
			Matcher matcher = pattern.matcher(line);
			if(matcher.find()){
				String uuid = matcher.group(0);
				st.setString(1, uuid);
				ResultSet rs = st.executeQuery();
				if(!rs.next()){
					
					StringBuffer sb = new StringBuffer(T.insertsql);
					sb.append(line);
					try{
						int num = conn.createStatement().executeUpdate(sb.toString());
						if(num == 0){
							bw.write(uuid);
							bw.write("\n");
							count++;
						}
					}catch(MySQLSyntaxErrorException e){
						System.err.println(sb.toString());
						System.exit(0);
					}
				}
				k++;
			}
			line = br.readLine();
		}
		bw.close();
		br.close();
		System.out.println("didn't match" + count);
		System.out.println("data count>>" + k);
	}
}
