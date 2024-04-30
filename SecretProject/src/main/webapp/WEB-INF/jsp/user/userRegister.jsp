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
						<button class="idCheck" type="button" id="idCheck" name="idCheck" onclick="CheckId();" value="N">
						중복확인</button>
						<input type="hidden" name="idDuplication" value="idUncheck"/>
						
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
		<button id="btnRegister" onclick="userRegister()">가입</button>
		<button onclick="location='UserList.do'">이전</button>
	</div>
	<br>
</body>
<script>
		const button = document.getElementById('btnRegister');
		
		function userRegister(){
			if (confirm("회원가입을 하시겠습니까?") == true) {
				if ($("#idCheck").val()=="N"){
					alert("아이디 중복 검사를 해주세요.");
				} else {
					$("#registUser").submit();
				}
			} else {
				return;
			}
		}
  		
  		$(document).ready(function() {
  		    var errors = "${errors}";
  		    var errorMessages = errors.replace(/^\[|\]$/g, '').split(',');

  		    errorMessages.forEach(function(message) {
  		        alert(message.trim());
  		    });
  		});
		
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
							alert("사용가능한 아이디입니다.");
							$("#idCheck").attr("value", "Y");
						}
					}
				})
		}
			
  			function validation() {
			var userId = document.getElementById("userId")
			var userPw = document.getElementById("userPw")
			var userName = document.getElementById("userName")
			var userEmail = document.getElementById("userEmail")
			var userPhone = document.getElementById("userPhone")
			
			var regIdPw = /^[a-z0-9]{5,20}$/;
			var regName = /^[가-힣a-zA-Z]{2,15}$/;
			var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
			var regPhone = /^\\d{2,3}-\\d{3,4}-\\d{4}$/;
			
			// 아이디 확인
			if(userId.value == ""){
				alert("아이디를 입력하세요.");
				userId.focus();
				return false;
			} else if (!regIdPw.test(userId.value)){
				alert("아이디는 5~20자 영문 소문자, 숫자만 입력하세요.");
				userId.focus();
				return false;
			}
			// 비밀번호 확인
			if(userPw.value == ""){
				alert("비밀번호를 입력하세요.");
				userPw.focus();
				return false;
			} else if (!regIdPw.test(userPw.value)){
				alert("비밀번호는 5~20자 영문 소문자, 숫자만 입력하세요.");
				userPw.focus();
				return false;
			}
			// 이름 확인
			if(userName.value == ""){
				alert("이름을 입력하세요.");
				userName.focus();
				return false;
			} else if (!regName.test(userName.value)){
				alert("이름은 2~15자 한글과 영어만 입력하세요.");
				userName.focus();
				return false;
			}
			// 이메일 확인
			if(userEmail.value == ""){
				alert("이메일을 입력하세요.");
				userEmail.focus();
				return false;
			} else if (!regEmail.test(userEmail.value)){
				alert("잘못된 이메일 형식입니다.");
				userEmail.focus();
				return false;
			}
			// 전화번호 확인
			if(userPhone.value == ""){
				alert("전화번호를 입력하세요.");
				userPhone.focus();
				return false;
			} else if (!regPhone.test(userPhone.value)){
				alert("잘못된 전화번호 형식입니다.");
				userPhone.focus();
				return false;
			}
		}
		
</script>
</html>