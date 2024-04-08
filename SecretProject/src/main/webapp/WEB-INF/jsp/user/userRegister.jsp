<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Write</title>
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
    <h1 class="text-center">User Regist</h1>
<br/>
<br/>
<div class="container">
        <form id="registUser" action="insertUser.do" method="post"
			encType="multiplart/form-data">
            <table class="table table-user">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input class="form-control" name="userId" type="text" id="userId"></td>
						<br />
						<button class="idCheck" type="button" id="idCheck" onclick="CheckId();" value="N">
						중복확인</button>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input class="form-control" name="userPw" type="text" id="userPw"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input class="form-control" name="userName" type="text" id="userName"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input class="form-control" name="userEmail" type="text" id="userEmail"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input class="form-control" name="userPhone" type="text" id="userPhone"></td>
					</tr>


				</tbody>
			</table>
        </form>
    </div>
	<div>
		<button onclick="userRegister()">가입</button>
		<button onclick="location='UserList.do'">이전</button>
	</div>
	<br>
</body>
<script>
		function userRegister(){
			if (confirm("회원가입을 하시겠습니까?") == true) {
				$("#registUser").submit();
			} else {
				return;
			}
		}
		function CheckId(){
				$.ajax({
					url : "/idCheck.do",
					type : "post",
					dataType : "json",
					data : {"userId" : $("#userId").val()},
					success : function(data){
						if(data == 1){
							alert("중복된 아이디입니다.");
						}else if(data == 0){
						//	$("#idCheck").attr("value", "Y");
							alert("사용가능한 아이디입니다.");
						}
					}
				})
		}
		
</script>
</html>