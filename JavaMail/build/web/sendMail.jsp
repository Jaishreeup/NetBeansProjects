<%-- 
    Document   : sendMail
    Created on : 1 Nov, 2014, 9:52:34 AM
    Author     : jaishree
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.lang.*"%>
<html>
    <body>
        <jsp:useBean id="mail" scope="session" class="jMail.Mail" />
<jsp:setProperty name="mail" property="to" param="to" />
<jsp:setProperty name="mail" property="from" value="Java.Mail.CA@gmail.com" />
<jsp:setProperty name="mail" property="smtpServ" value="smtp.gmail.com" />
<jsp:setProperty name="mail" property="subject" param="subject" />
<jsp:setProperty name="mail" property="message" param="message" />
<%
String to = mail.getTo();
int result;
result = mail.sendMail();
if(result == 0){
    out.println(" Mail Successfully Sent to "+to);
}
else{
    out.println(" Mail NOT Sent to "+to);
}  
%>

    </body>
</html>
