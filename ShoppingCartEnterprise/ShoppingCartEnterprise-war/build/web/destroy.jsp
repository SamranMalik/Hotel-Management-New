<%-- 
    Document   : destroy
    Created on : 4-Apr-2015, 10:26:18 PM
    Author     : SamranMalik
--%>

<%@page import="EJB.BookingListRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Context ic = new InitialContext();
            Object book = ic.lookup(BookingListRemote.class.getName());
            BookingListRemote bookingSession = (BookingListRemote) book;
            bookingSession.destroy();
              
            %>
    </body>
</html>
