<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:700px">
		<c:forEach var="result" items="${commentList}">
		<tr>
			<td>
				${result.commentUserId}(${result.commentDate})
				<br>
				${result.commentContent}
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
<script>
</script>
</html>