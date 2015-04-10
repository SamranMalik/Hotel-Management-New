<%-- 
    Document   : getdetail
    Created on : 4-Apr-2015, 8:44:10 PM
    Author     : SamranMalik
--%>

<%@page import="java.util.Iterator"%>
<%@page import="EJB.Booking"%>
<%@page import="java.util.List"%>
<%@page import="EJB.BookingListRemote"%>
<%@page import="EJB.Client"%>
<%@page import="EJB.AuthenticatorSessionRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css">
        <title>JSP Page</title>
    </head>
    <body>
      <%@include file="header.jsp"%>
        <div  class="book">
        <%
            Context ic = new InitialContext();
            Object o = ic.lookup(AuthenticatorSessionRemote.class.getName());
            AuthenticatorSessionRemote authSession = (AuthenticatorSessionRemote) o;
            Client c = new Client();
            c = (Client)authSession.userDetail();
            
            Object book = ic.lookup(BookingListRemote.class.getName());
            BookingListRemote bookingSession = (BookingListRemote) book;
            
            List<Booking> bookings = (List<Booking>) bookingSession.getBookings(c);
            Iterator i = bookings.iterator();
                while (i.hasNext()) {
                    Booking booking = (Booking) i.next();
                    out.println("Reservations You made: ");
                    %><h5>Check In: <input type="text" value="<%= booking.getCheckindate() %>"/></h5>
                    <h5>Check Out:<input type="text" value="<%= booking.getCheckoutdate() %>"/></h5>
                    <h5>Room Type: </h5>
                    <h5>Total Price: </h5>
                    <%
            //bookingSession.cancel();
                }
            %>
        </div>
    </body>
</html>
