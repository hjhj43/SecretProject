<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Board List</title>
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
    <h1 class="text-center">Board List</h1>
    <br/>
    <br/>
    <div class="container">
		<form id="boardForm" name="boardForm" method="post">
        <table class="table table-hover table-striped text-center" style="border:1px solid;">
			<colgroup>
				<col width="10%"/>
				<col width="50%"/>
				<col width="20%"/>
				<col width="20%"/>
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일자</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="result" items="${boardList}">
                <tr>
					<td>${result.boardSn}</td>
					<td><a href="BoardDetail.do?boardSn=${result.boardSn}">${result.boardTitle}</a></td>
					<td>${result.boardRegisterId}</td>
					<td>${result.boardDate}</td>
				</tr>
            </c:forEach>
			</tbody>
			</table>
			</form>
        <hr/>
        <!-- <div>
            <ul class="pagination justify-content-center">
                <li><a href="#" style="margin-right:5px;" class="text-secondary">◀</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">1</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">2</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">3</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">4</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">5</a></li>
                <li><a href="#" style="margin-right:5px;" class="text-secondary">▶</a></li>
            </ul>
        </div> -->
    </div>
	<script
		 src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
		 integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
		 crossorigin="anonymous"></script>
	<div>
		<button onclick="location='BoardRegister.do'">글작성</button>
	</div>
	<br>
</body>
<script type="text/javascript">
	function fn_view(boardSn) {
		var form = document.getElementById("boardForm");
		var url = "<c:url value='/BoardDetail.do'/>";
		url = url + "?boardSn=" + boardSn;

		form.action = url;
		form.submit();
	}
</script>
</html>
