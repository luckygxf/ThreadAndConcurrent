package com.gxf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 使用JDBC连接数据库
 * @author GXF
 *
 */
public class TestJdbc {

	public static void main(String[] args) {
		TestJdbc testJdbc = new TestJdbc();
		testJdbc.testJdbc();
	}
	
	/**
	 * 连接MySQL数据库
	 * test数据库
	 * usertable表
	 */
	public void testJdbc(){
		//加载驱动->通过url得到数据库连接对象->获取statement或者prestatment对象->执行SQL语句->处理结果集->关闭连接，释放资源
		try {
			String userName = "root";
			String passwd = "";
			String dbName = "test";
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Connection con = DriverManager.getConnection(url, userName, passwd);
			//创建statement
			Statement st = con.createStatement();
			//执行SQL,查询表中所有数据
			String sql = "select * from usertable";
			ResultSet rs = st.executeQuery(sql);

			//处理结果集
			while(rs.next()){				
				System.out.println(rs.getString("username") + " " + rs.getString("passwd"));
			}//while
			
			//关闭连接，释放资源
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
