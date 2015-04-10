<%-- 
    Document   : authenticate
    Created on : 1-Apr-2015, 11:56:08 PM
    Author     : SamranMalik
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="javax.naming.*"%>
<%@page import="EJB.AuthenticatorSessionRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="EJB.Client"%>
<%@page import="EJB.AuthenticatorSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String submit = request.getParameter("submit");
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            InitialContext ic = new InitialContext();
            Object o = ic.lookup(AuthenticatorSessionRemote.class.getName());
            AuthenticatorSessionRemote authSession = (AuthenticatorSessionRemote) o;
            
            if (submit.equals("Login"))
            {
                Boolean authentic = authSession.authenticate(login, pass);
                if (authentic == true)
                {
                    Client c = new Client();
            c = (Client)authSession.userDetail();
            out.println(c.getFirstname());
            String re = "index.jsp";
            response.sendRedirect(re);
                }
                else
                {
                    out.println("not good");
                }
            }
            %>
    </body>
</html>
