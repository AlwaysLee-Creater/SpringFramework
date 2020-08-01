package org.edwith.webbe.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

public class GuestbookDao {
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        Guestbook gb;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	conn=DBUtil.getConnection();
        	String sql="select * from guestbook";
        	ps=conn.prepareStatement(sql);
        	rs=ps.executeQuery();
        	
        	while(rs.next()) {
        		Long id=rs.getLong(1);
        		String name=rs.getString(2);
        		String content=rs.getString(3);
        		java.sql.Date sDate=rs.getDate(4);
        		java.util.Date utilDate = new java.util.Date(sDate.getTime());
        		
        		gb=new Guestbook(id,name,content,utilDate);
        		list.add(gb);
        	}
        }catch(Exception e) {
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
        return list;
    }

    public void addGuestbook(Guestbook guestbook){
        DBUtil du=new DBUtil();
        Connection conn=null;
        PreparedStatement ps=null;
        int rs;
        String name=guestbook.getName();
        String content=guestbook.getContent();
        java.util.Date utilDate = new java.util.Date();
        utilDate=guestbook.getRegdate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
        	conn=DBUtil.getConnection();
            String sql="insert into guestbook(name,content,regdate) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2, content);
            ps.setDate(3, sqlDate);
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
