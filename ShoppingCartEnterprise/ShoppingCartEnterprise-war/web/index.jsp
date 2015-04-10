<%-- 
    Document   : index
    Created on : 12-Feb-2015, 11:13:11 AM
    Author     : SamranMalik
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="javax.ejb.EJB.*,javax.naming.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css">
        <title>JSP Page</title>
           </head>
           <body>
               <div id="login">
               <form method="post" action="authenticate.jsp">
                   <p><label>Username:</label>&nbsp;&nbsp;&nbsp;<input type="text" name="login" value="" placeholder="Username"></p>
                   <p><label>Password:</label>&nbsp;&nbsp;&nbsp;<input type="password" name="password" value="" placeholder="Password"></p>
        <p class="submit"><input type="submit" name="submit" id="submit" value="Login">
        <input type="submit" name="submit" id="submit" value="Register">       
        </p>
        
      </form>
                   </div>
               <%@include file="header.jsp"%>
    </body>
</html>
