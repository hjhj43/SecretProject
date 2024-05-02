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
		<button onclick="location='logout.do'">로그아웃</button>
    <br/>
    <div class="container">
		<form id="boardForm" name="boardForm" method="post">
        <table class="table table-hover table-striped text-center" style="border:1px solid;">
			<input type="hidden" name="curPage" value="1" />
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

<!-- TODO:  페이징에 필요한 요소들 파악 후  fn_pagination 분석 후 구현  -->
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item <c:if test="${1 eq boardPagingVO.curPage}">disabled</c:if>">
					<a class="page-link" href="javascript:fn_pagination('1')" tabindex="-1" aria-disabled="true">처음으로</a>
				</li>
				
				<li class="page-item <c:if test="${1 eq boardPagingVO.firstPage}">disabled</c:if>">
					<a class="page-link" href="javascript:fn_pagination('<c:out value="${boardPagingVO.firstPage-1}"/>')" aria-disabled="true">이전</a>
				</li>

				<c:forEach begin="${boardPagingVO.firstPage }" end="${boardPagingVO.lastPage }" var="i">
					<c:if test="${i eq boardPagingVO.curPage }">
						<li class="page-item active"><a class="page-link" href="#">${i }</a></li>
					</c:if>
					<c:if test="${i ne boardPagingVO.curPage }">
						<li class="page-item"><a class="page-link" href="javascript:fn_pagination('${i}')">${i}</a></li>
					</c:if>
				</c:forEach>

				<li class="page-item <c:if test="${boardPagingVO.totalPageCount eq boardPagingVO.lastPage}">disabled</c:if>">
					<a class="page-link" href="javascript:fn_pagination('<c:out value="${boardPagingVO.lastPage+1}"/>')">다음</a>
				</li>
				
				<li class="page-item <c:if test="${boardPagingVO.totalPageCount eq boardPagingVO.curPage}">disabled</c:if>">
					<a class="page-link" href="javascript:fn_pagination('<c:out value="${boardPagingVO.totalPageCount}"/>')">마지막으로</a>
				</li>
			</ul>

		</nav>
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
	
	function fn_pagination(curPage){
		location.href="/BoardList.do?curPage="+curPage;
	}
	
</script>
</html>
