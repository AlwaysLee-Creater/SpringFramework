package kr.or.connect.namecard.dao;

import java.sql.DriverManager;

public class Connection {
	private static String dburl="jdbc:mysql://localhost:3306/namecard";
	private static String dbUser="root";
	private static String dbpasswd="Pringle!135";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
