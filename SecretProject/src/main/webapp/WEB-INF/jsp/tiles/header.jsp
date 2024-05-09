<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body onload="initialize()">
	<br/>
		<div id="welcome"></div>
		<button id="logout" onclick="location='logout.do'">로그아웃</button>
		<button id="userList" onclick="location='UserList.do'">유저리스트</button>
    <br/>
</body>
<script>

	function changeLogoutBtn() {
		document.getElementById("logout").style.display="none";
		
		var userId = "${sessionUserData.userId}";
		
		if (userId != '') {
			var welcomeMessage = userId + "님, 환영합니다!";
            document.getElementById("welcome").innerText = welcomeMessage;
			document.getElementById("logout").style.display="block";
		}
	}

	function removeListBtn() { // 로그인한 유저중 admin만 userList를 볼 수 있게
		document.getElementById("userList").style.display="none";
		
		var userId = "${sessionUserData.userId}";
	    var userAuth = "${sessionUserData.userAuthNum}";
		
		if (userId != '' && userAuth == 1) {
			document.getElementById("userList").style.display="block";
		}
	}
	
	function initialize() {
		changeLogoutBtn();
		removeListBtn();
	}

</script>
</html>