<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<%
		String userLoggedStr = (String) request.getSession().getAttribute("userLogged");
		if(userLoggedStr!=null && userLoggedStr.length()>0){
			out.print("<h3>Hello "+userLoggedStr.toUpperCase()+ "</h3>");
			out.print("<a href='logout'> Logout </a>");
			
		}else{
			out.print("<h3>Hello Anonymous user</h3>");
			out.print("<a href='login'>Login</a>");
		}
	%>
	
</body>
</html>