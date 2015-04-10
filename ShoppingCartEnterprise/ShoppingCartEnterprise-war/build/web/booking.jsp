<%-- 
    Document   : booking
    Created on : 1-Apr-2015, 8:58:44 PM
    Author     : SamranMalik
--%>

<%@page import="EJB.Roomtype"%>
<%@page import="EJB.RoomBookingRemote"%>
<%@page import="java.util.Iterator"%>
<%@page import="EJB.RoomBookingLocal"%>
<%@page import="EJB.Client"%>
<%@page import="EJB.Room"%>
<%@page import="EJB.AuthenticatorSessionRemote"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="javax.ejb.EJB.*,javax.naming.*"%>

<!DOCTYPE html>
<html>
    <head>
               <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css">
          <link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
    $("#dt").datepicker();
  });
  </script>
           </head>
           <body>
               <%
                   Context ic = new InitialContext();
            Object o = ic.lookup(AuthenticatorSessionRemote.class.getName());
            AuthenticatorSessionRemote authSession = (AuthenticatorSessionRemote) o;
            Object room = ic.lookup(RoomBookingRemote.class.getName());
            RoomBookingRemote roomSession = (RoomBookingRemote) room;
            Client c = new Client();
            c = (Client)authSession.userDetail();
            List<Roomtype> rooms = roomSession.rooms();
                   %>
               <div id="login">
                   <p id="welcome"><label><%= c.getUsername()%></label>&nbsp;&nbsp;&nbsp;Please Give Booking Details</p>
                   </div>
               <%@include file="header.jsp"%>
                   <form method="post" action="makeBookin.jsp">
                   <div  class="book">
                   <label>
                       Reservation:
                   </label>                
                       <h5>Room Type:
<select name="roomType"> 
    <%
    for (Roomtype temp : rooms) {
        %>
        <option value="<%= temp.getName() %>">
            <%=
                    temp.getName()
    %></option>
        <%}%>
        </select>
                           </h5>
                       <h5>Check In: <input type="text" id="datepicker" name="checkin"></h5>
                       <h5>Check Out: <input type="text" id="dt" name="checkout"></h5>
                       <input type="submit" name="submit" id="submit" value="Confirm"> 
                   </div>
                       
                   </form>
    </body>
</html>

