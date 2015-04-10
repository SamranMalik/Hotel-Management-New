<%-- 
    Document   : makeBookin
    Created on : 10-Apr-2015, 11:32:35 AM
    Author     : SamranMalik
--%>

<%@page import="java.util.List"%>
<%@page import="EJB.Room"%>
<%@page import="EJB.Roomtype"%>
<%@page import="EJB.Client"%>
<%@page import="EJB.AuthenticatorSessionRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="EJB.RoomBookingRemote"%>
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
            String room = request.getParameter("roomType");
            String checkin = request.getParameter("checkin");
            String checkout = request.getParameter("checkout");
            Context ic = new InitialContext();
            Object book = ic.lookup(RoomBookingRemote.class.getName());
            RoomBookingRemote roomBooking = (RoomBookingRemote) book;           
            List<Roomtype> r = roomBooking.roomByType(room);
            Roomtype room1 = r.get(0);
            Object o = ic.lookup(AuthenticatorSessionRemote.class.getName());
            AuthenticatorSessionRemote authSession = (AuthenticatorSessionRemote) o;
            Client c = new Client();
            c = (Client)authSession.userDetail();
            roomBooking.bookRoom(room1, c, checkin, checkout);
            
            %>
    </body>
</html>
