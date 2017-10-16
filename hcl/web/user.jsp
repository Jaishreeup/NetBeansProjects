<%-- 
    Document   : user
    Created on : 4 Jun, 2015, 4:12:00 PM
    Author     : JAISHREE UPRETI
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
        <link rel="stylesheet" type="text/css" href="form.css">
    </head>
    <body>
        <h2> hello <%
            HttpSession session1=request.getSession();
  session1.setAttribute("name",(String)request.getAttribute("name1"));%>
        <%=(String)request.getAttribute("name1")%></h2>
    <center>
            OPTIONS:<br>
            <form action="view">
            <input type="submit"  value="VIEW FILES"><br>
            </form>
            <input type="button" onclick="upload()" value="UPLOAD FILES">
          
            <br>
            <form id="form"  hidden="true" action="upload" method="post" enctype="multipart/form-data">
                <input type="file" name="fileName"><br>
            <input type="submit" value="upload">
            </form>
    </center>
            <script>
                function upload()
                {
                  document.getElementById("form").hidden=false;  
                }
            </script>
    </body>
</html>
