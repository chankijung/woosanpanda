<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<table>
	<tr>
	<th>이미지</th>
	<td><img id="profileImg" src="displayFile?fileName=${image_addr}&directory=thumbnail"></td>
	</tr>
	<tr>
	<th>글 번호</th>
	<td>${write_no }</td>
	<tr>
	<th>제목</th>
	<td>${title }</td>
	</tr>
	<tr>
	<th>내용</th>
	<td>${content }</td>
	</tr>
	<tr>
	<th>주소</th>
	<td>${addr } ${addr2 }</td>
	</tr>
	<tr>
	<th>카테고리</th>
	<td>${cate }</td>
	</tr>
	<tr>
	<th>가격</th>
	<td>${price }</td>
	</tr>
	</table>
	<hr>
	<table>
	<c:forEach var=dto items="${list}">
	<tr>
	<th>글쓴이</th>
	<td>${dto.id }</td>
	</tr>
	<tr>
	<th>별점</th>
	<td>${dto.rate }</td>
	</tr>
	<tr>
	<th>댓글</th>
	<td>${dto.content }</td>
	</tr>
	<tr>
	<th>작성시간</th>
	<td>${dto.date }</td>
	</tr>
	</c:forEach>
	</table>
	
	
  
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