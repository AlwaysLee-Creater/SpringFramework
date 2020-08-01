package kr.or.connect.namecard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NCardDao2 {
	private String dburl="jdbc:mysql://localhost:3306/namecard";
	private String dbUser="root";
	private String dbpasswd="Pringle!135";
	
	public void setCard(String name,String phone,String companyName) {
		Connection conn=null;
		PreparedStatement ps=null;
		int rs;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql="insert into namecard(name,phone,companyName) values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, companyName);
			rs=ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
