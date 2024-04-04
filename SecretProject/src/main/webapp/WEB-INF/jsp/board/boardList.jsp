<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Board List</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- Bootstrap CSS -->
</head>
<body>
    <br/>
    <h1 class="text-center">Board List</h1>
    <br/>
    <br/>
    <div class="container">
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
					<td>${result.boardTitle}</td>
					<td>${result.boardRegisterId}</td>
					<td>${result.boardDate}</td>
				</tr>
            </c:forEach>
			</tbody>
			</table>
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
        </div>
        <a class="btn btn-outline-info" style="float:right">글쓰기</a> -->
    </div>
</body>
</html>
