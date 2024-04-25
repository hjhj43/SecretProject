<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
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

</head>
<body>
    <br />
    <h1 class="text-center">User Detail</h1>
    <br />
    <br />
    <div class="container">
        <form action="updateUser.do" id="viewUser" method="post"
		encType="multiplart/form-data">
            <table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input name="userId" class="form-control" type="text" value="${userList.userId}"
							style="height: 200px;"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input name="userPw" class="form-control" type="text" 
							style="height: 200px;"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input name="userName" class="form-control" type="text" value="${userList.userName}"
							style="height: 200px;"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input name="userEmail" class="form-control" type="text" value="${userList.userEmail}"
							style="height: 200px;"></td>
					</tr>
					<tr>
						<th>핸드폰번호</th>
						<td><input name="userPhone" class="form-control" type="text" value="${userList.userPhone}"
							style="height: 200px;"></td>
					</tr>
					<tr>
						<th>권한</th>
						<td><input name="userAuthName" class="form-control" type="text" value="${userList.authName}"
							style="height: 200px;" readonly></td>
					</tr>
				</tbody>
			</table>
        </form>
    </div>
		<script
		 src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
		 integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
		 crossorigin="anonymous"></script>
	<div>
		<button onclick="location='UserList.do'">이전</button>
		<button onclick="modifyUser()">수정</button>
		<button onclick="deleteUser()">삭제</button>
	</div>
	<br>
</body>
<script>

	function modifyUser(){
	if (confirm("정말 수정하시겠습니까?") == true) {
		$("#viewUser").submit();
		alert("수정되었습니다");
	} else {
		return;
	}
}

	function deleteUser(){
		var userId = '${userList.userId}';
		        
		if (confirm("정말 삭제하시겠습니까 ?") == true) {
			$("#viewUser").attr("action", "deleteUser.do?userId="+userId);
		    $("#viewUser").submit();
			alert("삭제되었습니다");
		} else {
			return;
		}
	}
</script>
</body>
</html>