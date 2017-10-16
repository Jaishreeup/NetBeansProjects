<%-- 
    Document   : tab
    Created on : 26 Mar, 2017, 4:03:32 PM
    Author     : JAISHREE UPRETI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "mystyle.css" />
<style>
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>
</head>
<body>


<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Employees')">Employees</button>
  <button class="tablinks" onclick="openCity(event, 'Products')">Products</button>
</div>

<div id="Employees" class="tabcontent">
  <a href="#" class="myButton3" onclick=showDiv()>Get Subordinates</a>
  <a href="#" class="myButton3" onclick=showDiv()>Add Employee</a>
  <a href="#" class="myButton3" onclick=showDiv1()>Fire Employee</a>

<div id="welcomeDiv"  style="display:none;" class="answer_list" >

<form >
<br><br>
EMPID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text">
<br><br>
NAME  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
EMAIL  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
PHONE  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
ADDRESS  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="textarea">
<br><br>
POSITION  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
BOSS  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
<input type="button" value="submit">
</form>
</div>
<br><br><br>
<div id="welcomeDiv1"  style="display:none;" class="answer_list" >
<form>
Empid <input type="text" name="empid"><input type="submit" value="get details">
</form>
<form >
<br><br>
EMPID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text">
<br><br>
NAME  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
EMAIL  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
PHONE  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
ADDRESS  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="textarea">
<br><br>
POSITION  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
BOSS  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
<input type="button" value="submit">
</form>
</div>
</div>

<div id="Products" class="tabcontent">
  <a href="#" class="myButton3" onclick=showDiv2()>Update Price</a>
  <a href="#" class="myButton3" onclick=showDiv3()>Check inventory</a>
  <a href="#" class="myButton3" onclick=showDiv4()>Add product</a>
</div>
<div id="welcomeDiv2"  style="display:none;" class="answer_list" >

<form >
<br><br>
PCODE &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text">
<input type="submit" value="get details">
</form>
<form>
<br><br>
NAME  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
MANUFACTURER  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
MRP  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>

DISCOUNT  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
<input type="button" value="submit">
</form>
</div>
<br><br><br>

<div id="welcomeDiv4"  style="display:none;" class="answer_list" >

<form >
<br><br>
PCODE &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text">
<br><br>
NAME  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
MANUFACTURER  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
MRP  &nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
QUANTITY  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text">
<br><br>
<input type="button" value="submit">
</form>
</div>
<br><br><br>


<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
function showDiv() {
 document.getElementById('welcomeDiv1').style.display = "none";

   document.getElementById('welcomeDiv').style.display = "block";
}
function showDiv1() {
 document.getElementById('welcomeDiv').style.display = "none";

   document.getElementById('welcomeDiv1').style.display = "block";

   }
   function showDiv2() {
 document.getElementById('welcomeDiv4').style.display = "none";

   document.getElementById('welcomeDiv2').style.display = "block";

   }
function showDiv4() {

   document.getElementById('welcomeDiv2').style.display = "none";
document.getElementById('welcomeDiv4').style.display = "block";

   }


</script>
     
</body>
</html> 
