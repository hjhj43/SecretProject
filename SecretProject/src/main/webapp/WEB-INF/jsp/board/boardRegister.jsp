<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
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
    <h1 class="text-center">Board Write</h1>
<br/>
<br/>
<div class="container">
        <form id="registBoard" action="insertBoard.do" method="post"
			encType="multiplart/form-data">
            <table class="table table-bordered">
				<tbody>
					<tr>
						<th>제목</th>
							<td><input name="boardTitle" type="text" id="boardTitle"></td>
					</tr>
					<tr>
						<td><input name="boardRegisterId" type="hidden" value="${sessionUserData.userId}"
							class="form-control" /></td>
					</tr>
					<tr>
						<th>내용</th>
							<td><textarea name="boardContent" id="boardContent">내용을 입력하세요</textarea>
                    </tr>
				</tbody>
			</table>
        </form>
    </div>
	<div>
		<button onclick="boardRegister()">등록</button>
		<button onclick="location='BoardList.do'">이전</button>
	</div>
	<br>
</body>
<script>
		function boardRegister(){
			if (confirm("글을 등록하시겠습니까?") == true) {
				$("#registBoard").submit();
			} else {
				return;
			}
		}
</script>
</html>