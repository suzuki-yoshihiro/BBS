<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ログイン</title>
	<link rel = "stylesheet" type = "text/css" href = "stylesheet/style.css">
</head>
<body>
	<div class = "login-screen">

		<h3>掲示板　ログイン</h3>


		<c:if test="${not empty errorMessages }">
			<div class = "errorMessages">
				<ul>
					<c:forEach items = "${errorMessages }" var = "messages">
						<li><c:out value = "${messages }" /><br />
					</c:forEach>
				</ul>
			</div>
			<c:remove var = "errorMessages" scope = "session"/>
		</c:if>

		<form action = "login" method = "post"> <br />
			<label for ="loginId"> ログインID</label>
			<input name = "loginId" id = "loginId" value = "${inputValue }" /> <br />
			<label for = "password">パスワード</label>
			<input name = "password" type = "password" id = "password" /> <br />
			<input type = "submit" value = "ログイン" /> <br />


		</form>
		<div class = "copyright">Copyright(c) Yoshihiro Suzuki</div>
	</div>

</body>
</html>