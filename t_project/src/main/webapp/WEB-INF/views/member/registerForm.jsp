<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<p>회원가입 폼</p>
	<form id="fo" action="register" method="post">
	<table>
	<tr>
	<th>아이디 </th><th><input type="text" name="id"></th>
	</tr>
	<tr>
	<th>비밀번호 </th><th><input type="text" name="pw"></th>
	</tr>
	<tr>
	<th>주소 </th><th><input type="text" name="addr"></th>
	</tr>
	<tr>
	<th>이름 </th><th><input type="text" name="name"></th>
	</tr>
	<tr>
	<th>이메일 </th><th><input type="text" name="email"></th>
	</tr>
	<tr>
	<th><label><input type="radio" name="gender" value="1">남자</label></th>
	<th><label><input type="radio" name="gender" value="2">여자</label></th>
	</tr>
	<tr>
	<th>핸드폰번호 </th><th><input type="text" name="phNum"></th>
	</tr>
	<tr>
	<th>선호 카테고리 </th>
	<th><select name="per_cate">
		<option>신발</option>
		<option>옷</option>
		<option>전자제품</option>
		<option>가구</option>
		<option></option>
		
	</select></th>
	</tr>
	<tr><th span="2">
		<input type="submit" value="전송"></th></tr>
	</table>
	</form>
</div>

</body>
</html>