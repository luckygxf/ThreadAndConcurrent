package com.gxf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * ʹ��JDBC�������ݿ�
 * @author GXF
 *
 */
public class TestJdbc {

	public static void main(String[] args) {
		TestJdbc testJdbc = new TestJdbc();
		testJdbc.testJdbc();
	}
	
	/**
	 * ����MySQL���ݿ�
	 * test���ݿ�
	 * usertable��
	 */
	public void testJdbc(){
		//��������->ͨ��url�õ����ݿ����Ӷ���->��ȡstatement����prestatment����->ִ��SQL���->��������->�ر����ӣ��ͷ���Դ
		try {
			String userName = "root";
			String passwd = "";
			String dbName = "test";
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Connection con = DriverManager.getConnection(url, userName, passwd);
			//����statement
			Statement st = con.createStatement();
			//ִ��SQL,��ѯ������������
			String sql = "select * from usertable";
			ResultSet rs = st.executeQuery(sql);

			//��������
			while(rs.next()){				
				System.out.println(rs.getString("username") + " " + rs.getString("passwd"));
			}//while
			
			//�ر����ӣ��ͷ���Դ
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
