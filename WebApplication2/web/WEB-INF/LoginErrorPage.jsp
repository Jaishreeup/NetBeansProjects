<%@ page isErrorPage="true" %>
<html>
	<body>
		<h3>An exception has occurred</h3>
		<table>
			<tr>
				<td>Exception Class:</td>
				<td><%= exception.getClass() %></td>
			</tr>
			<tr>
				<td>Message:</td>
				<td><%= exception.getMessage() %></td>
			</tr>
		</table>
		<br>
		To go to login page again, click Login Page button
		<form name="f2" action="main.html">
			<input type="submit" name="button1" value="Login Page">
		</form>
	</body>
</html>