<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loggedId not eq admin }">
	<script>
	alert("잘못된 접근입니다.");
	window.href.location = "main";
	</script>
	</c:if>
	<h1>관리자 페이지 입니다</h1>
	<table class="board">
	</table>
	<table class="member">
	</table>
	<table class="board2">
	</table>
</body>
</html>