<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
    <br/>
    <h1 class="text-center">Login</h1>
    <br/>
    <br/>
    <div class="container">
		<form id="loginForm" name="loginForm" action="login.do" method="post">
			<c:if test="${user == null}">
				<div>
					<label for="userId">아이디</label>
					<input type="text" id="userId" name="userId">
				</div>
				<div>
					<label for="userPw">비밀번호</label>
					<input type="text" id="userPw" name="userPw">
				</div>
				<div>
					<button type="submit">로그인</button>
				</div>

			</c:if>
<%--  			<c:if test="${user ne null }">
				<div>
					<p>${user.userId}님, 환영합니다.</p>
					<button id="logoutBtn" type="button">로그아웃</button>
				</div>
			</c:if> --%>
		</form>
		</div>
			<button onclick="location='UserRegister.do'">회원가입</button>
</body>

</html>