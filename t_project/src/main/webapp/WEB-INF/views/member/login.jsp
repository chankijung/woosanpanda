<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="wrap">
	<form action="${contextPath }/member/logChk" method="post">
		아이디<input type="text" name="id" palceholder="input id"><br>
		비밀번호<input type="text" name="pw" palceholder="input pwd"><br>
		<input type="submit" value="로그인"><br>
		<a href="registerForm">회원가입</a><br>
		<input type="checkbox" name="autoLogin">자동로그인
	</form>
</div>

</body>
</html>

