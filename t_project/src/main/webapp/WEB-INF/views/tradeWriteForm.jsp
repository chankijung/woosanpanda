<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
<form action="writeAdimt" id="tradeWrite">
<table>
<tr>
<th>제목</th>
<td><input type="text" name="title" id="title" required></td>
</tr>
<tr>
<th>사진 업로드</th>
<td><input type="file" name="image_addr" id="image_addr"></td>
</tr><tr>
<th>내용</th>
<td><textarea form="tradeWrite" required></textarea>
</td></tr><tr>
<th>가격</th>
<td><input type="text" name="price" id="price" required></td>
</tr>
<tr>
<th>카테고리</th>
<td><input type="radio" value="1" id="cate">1. 가전제품
<input type="radio" value="2" id="cate">2. 운동용품
<input type="radio" value="3" id="cate">3. 사무용품
<input type="radio" value="4" id="cate">4. 주방용품
<input type="radio" value="5" id="cate">5. 취미용품</td>

</table>
<input type="hidden" value=${id } name="id" id="id">
</form>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
</body>
</html>