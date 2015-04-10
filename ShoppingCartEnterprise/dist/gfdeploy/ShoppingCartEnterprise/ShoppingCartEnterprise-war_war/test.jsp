<%-- 
    Document   : test
    Created on : 4-Apr-2015, 2:09:31 PM
    Author     : SamranMalik
--%>

<%@page import="javax.naming.Context"%>
<%@page import="EJB.Client"%>
<%@page import="EJB.AuthenticatorSession"%>
<%@page import="EJB.AuthenticatorSessionRemote"%>
<%@page import="javax.naming.InitialContext"%>
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
            Object o = ic.lookup(AuthenticatorSessionRemote.class.getName());
            AuthenticatorSessionRemote authSession = (AuthenticatorSessionRemote) o;
            Client c = new Client();
            c = (Client)authSession.userDetail();
            out.println(c.getPassword()); 
            %>
    </body>
</html>
