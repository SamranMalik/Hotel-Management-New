<%-- 
    Document   : adminroomlist
    Created on : Apr 9, 2015, 5:19:27 PM
    Author     : Ruslan
--%>

<%@page import="EJB.Room"%>
<%@page import="RemoteEJB.RoomBookingRemote"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.util.List"%>
        <%@page import="javax.naming.InitialContext"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%@include file="adminheader.jsp" %>
        <%
            InitialContext ic = new InitialContext();
            Object o = ic.lookup(RoomBookingRemote.class.getName());
            RoomBookingRemote custSession = (RoomBookingRemote) o;

            List<Room> rooms = (List<Room>)custSession.rooms();

            if(rooms!=null){
                %>
               <table>
                   <tr>
                       <th>RoomID</th>
                       <th>Type</th>
                       <th>Number</th>
                       <th>Floor</th>
                       <th>isReserved</th>
                    </tr>
                <%
                for (int i=0;i<rooms.size();i++) {
                    %>
                    <tr>
                        <td><%=rooms.get(i).getRoomid()%></td>
                        <td><%=rooms.get(i).()%></td>
                        <td><%=rooms.get(i).getDescription()%></td>
                        <td><%=rooms.get(i).getPrice()%></td>
                        <td><%=rooms.get(i).getAvailability()%></td>
                    </tr>
                    <%
                }
            }
        %>
    </body>
</html>
