<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>
    <br />
    <h1 class="text-center">Board Detail</h1>
    <br />
    <br />
    <div class="container">
        <form action="updateBoard.do" id="viewBoard" method="post"
		encType="multiplart/form-data">
            <table class="table table-bordered">
				<tbody>
					<tr>
						<th>글번호</th>
						<td><input name="boardSn" type="text" value="${boardList.boardSn}"
							class="form-control" readonly /></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input name="boardTitle" type="text" value="${boardList.boardTitle}"
							class="form-control" readonly /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="boardContent" class="form-control"
							style="height: 200px;">${boardList.boardContent}</textarea></td>
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
		<button onclick="location='BoardList.do'">이전</button>
		<button onclick="modifyBoard()">수정</button>
		<button onclick="deleteBoard()">삭제</button>
	</div>
	<br>
</body>
<script>

	function modifyBoard(){
	if (confirm("정말 수정하시겠습니까?") == true) {
		$("#viewBoard").submit();
		alert("수정되었습니다");
	} else {
		return;
	}
}

	function deleteBoard(){
		var boardSn = ${boardList.boardSn};
		        
		if (confirm("정말 삭제하시겠습니까 ?") == true) {
			$("#viewBoard").attr("action", "deleteBoard.do?boardSn="+boardSn);
		    $("#viewBoard").submit();
			alert("삭제되었습니다");
		} else {
			return;
		}
	}
</script>
</html>