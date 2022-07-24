<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
	<div>
		User: <input name="username"/>
	</div>
	<div>
		Password: <input type="password" name="password"/>
	</div>
	<div>
		Remember me: <input type="checkbox" name="remember"/>
	</div>
	<div>
		<input type="submit" value="Login"/>
	</div>
	</form>
	${message}
</body>
</html>