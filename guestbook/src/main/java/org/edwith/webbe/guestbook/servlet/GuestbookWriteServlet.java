package org.edwith.webbe.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name=request.getParameter("name");
        String content=request.getParameter("content");
        Guestbook gb=new Guestbook(name,content);
        GuestbookDao gd=new GuestbookDao();
        gd.addGuestbook(gb);
        response.sendRedirect("http://localhost:9090/guestbooks");
    }

}
