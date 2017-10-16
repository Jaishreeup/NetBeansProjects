<%-- 
    Document   : execute
    Created on : 25 May, 2015, 12:08:57 PM
    Author     : JAISHREE UPRETI
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%
                String st=request.getParameter("txt");
                 String st1=request.getParameter("jscript");
                 String st2=request.getParameter("css");
        System.out.println(st+" hi "+st1+"  jooj  "+st2);
        %>
       <style><%=st2%></style>
    </head>
    <body>
        <script>
            function getit()
{
document.getElementById("1").innerHTML="gotit!!";
}
        </script>
        <% out.print(st);%>
        
</body>
</html>
