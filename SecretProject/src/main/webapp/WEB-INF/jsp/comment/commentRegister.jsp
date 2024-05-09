<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 작성</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
<div class="container">
        <form id="registComment" action="insertComment.do" method="post"
			encType="multiplart/form-data">
            <table class="table table-comment">
				<tbody>
					<tr>
						<td><input name="commentUserId"  type="hidden" value="${sessionUserData.userId}"
							class="form-control" /></td>
					</tr>
					<tr>
						<td><input name="commentBoardSn"  type="hidden" value="${sessionBoardData.boardSn}"
							class="form-control" /></td>
					</tr>
					<tr>
						<th>댓글</th>
							<td><textarea name="commentContent" id="commentContent">내용을 입력하세요</textarea>
                    </tr>
				</tbody>
			</table>
        </form>
    </div>
	<div>
		<button onclick="commentRegister()">등록</button>
	</div>
	<br>
</body>
</html>