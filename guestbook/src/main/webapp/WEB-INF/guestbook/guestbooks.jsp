<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <title>�����</title>
        <style>
            .guestbook {
                padding: 5px 0px 5px 5px;
                margin-bottom: 5px;
                border-bottom: 1px solid #efefef;
                font-size: 12px;
            }
        </style>
    </head>
    <body>
        <div class="guestbooks">
            <c:forEach var="guestbook" items="${list}">
                <div class="guestbook">
                    <div> <label>id : </label> ${guestbook.id}</div>
                    <div> <label>name : </label> ${guestbook.name}</div>
                    <div> <p>${guestbook.content}</p></div>
                    <div> <label>regdate : </label> ${guestbook.regdate}</div>
                </div>
            </c:forEach>
        </div>

        <br><br><br>

        <form method="post" action="guestbooks/write">
            �̸� : <input type="text" name="name"><br>
            ���� :
            <textarea name="content" cols="50" rows="5"></textarea><br>
            <input type="submit" value="Ȯ��">
        </form>
    </body>
</html>