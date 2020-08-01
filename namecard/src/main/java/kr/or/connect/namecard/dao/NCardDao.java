package kr.or.connect.namecard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.namecard.dto.NCard;

public class NCardDao {
	private static String dburl="jdbc:mysql://localhost:3306/namecard";
	private static String dbUser="root";
	private static String dbpasswd="Pringle!135";
	
	public NCard getNCard(String name) {
		NCard nc=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql="select name,phone,companyName from namecard where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String n=rs.getString(1);
				String phone=rs.getString(2);
				String companyName=rs.getString(3);
				
				nc=new NCard(n,phone,companyName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
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
		
		return nc;
	}
}
