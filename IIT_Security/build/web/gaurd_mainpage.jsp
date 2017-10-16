<%-- 
    Document   : gaurd_mainpage
    Created on : 10 Apr, 2017, 10:57:47 AM
    Author     : JAISHREE UPRETI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
<html>
<head>
<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
.button {
    background-color: #008CBA;
    border-radius: 8px;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 24px;
    margin: 8px 8px;
    cursor: pointer;
}
</style>
</head>
<body>
<div id="backgroundImage"> </div>
<nav class="navbar navbar-default">
        <div class="container-fluid">
            <!--header -->
            <div class="navbar-header">
                <!-- change url here -->
                <a class="navbar-brand" href="gaurd_mainpage.jsp"><p id="title">IIT Security Software</p></a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#topNavBar">
                    <span class="icon-bar"> </span>
                    <span class="icon-bar"> </span>
                    <span class="icon-bar"> </span>
                </button>
            </div>
            <!-- items -->
            <div class="collapse navbar-collapse mymenu" id="topNavBar">

                <ul class="nav navbar-nav navbar-right" >
                         <li class="active">
                             <a href="gaurd_mainpage.jsp">
                                 <span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;Home
                             </a>
                         </li>
                        <li class="">
                             <a href="logout.html">
                                 <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>&nbsp; Logout
                             </a>
                         </li>
                        <li class="">
                             <a href="#" >
                                 <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>&nbsp; ContactUs
                             </a>
                         </li>

                </ul>
            </div>
        </div>

    <br><br><br><br><br><br>
    <center>	
	<div style="text-align:center">
            <a href="errant.html" class="button">Errant Vehicle</a> </div><br>
	<div style="text-align:center">
	<a href="inside.html" class="button">Inside Vehicle Register</a> </div>
    </center>
</body>
</html>

