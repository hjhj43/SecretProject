<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
		crossorigin="anonymous">
		<script  src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<style  type="text/css">
</style>
</head>
<body>
    <br/>
    <h1 class="text-center">User List</h1>
    <br/>
    <br/>
    <div class="container">
		<form id="userForm" name="userForm" method="post">
        <table class="table table-hover table-striped text-center" style="border:1px solid;">
			<colgroup>
				<col width="10%"/>
				<col width="50%"/>
				<col width="20%"/>
				<col width="20%"/>
			</colgroup>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="result" items="${userList}">
                <tr>
					<td>${result.userId}</td>
					<td><a href="UserDetail.do?userId=${result.userId}">${result.userName}</a></td>
					<td>${result.userEmail}</td>
					<td>${result.userPhone}</td>
				</tr>
            </c:forEach>
			</tbody>
			</table>
			</form>
        <hr/>
    </div>
	<script
		 src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
		 integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
		 crossorigin="anonymous"></script>
	<div>
		<button onclick="location='UserRegister.do'">회원가입</button>
	</div>
	<br>
</body>
<script type="text/javascript">
	function fn_view(userId) {
		var form = document.getElementById("userForm");
		var url = "<c:url value='/UserDetail.do'/>";
		url = url + "?userId=" + userId;

		form.action = url;
		form.submit();
	}
</script>
</html>
