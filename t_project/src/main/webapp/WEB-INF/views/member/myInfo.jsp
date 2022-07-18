<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>내 정보</p>
<table class="table">
		<tr>
		<th>아이디</th><th>비밀번호</th><th>주소</th><th>이름</th>
		<th>이메일</th><th>성별</th><th>핸드폰 번호</th><th>선호 카테고리</th>
		</tr>
		<tr>
		<th>${dto.id }</th><th>${dto.pw }</th><th>${dto.addr }</th><th>${dto.name }</th>
		<th>${dto.email }</th><th>${dto.gender }</th><th>${dto.phNum }</th><th>${dto.per_cate }</th>
		</tr>
		</table>

</body>
</html>