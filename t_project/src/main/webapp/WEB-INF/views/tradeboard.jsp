<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<table class="table table-hover">
		<tr>
			<th scope="col">글 번호</th>
			<th scope="col">글 제목</th>
			<th scope="col">조회수</th>
			<th scope="col">작성자</th>
			<th scope="col">글 작성시간</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<th colspan="6">작성된 글이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
			<c:forEach var="dto" items="${list }">
				<tr>
					<td scope="row">${dto.write_no }</td>
					<td><a href="contentView?title=${dto.title}">${dto.title }</a></td>
					<td>${dto.hit }</td>
					<td>${dto.id }</td>
					<td>${dto.saveDate }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<form>
	<input type="text" name="addr" id="addr">
	<input type="text" name="addr2" id="addr2">
	<input type="button" onclick="getAddrs()">
	</form>
	<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ed445263dd16bda07760fb634155a272&libraries=services"></script>
<script>
	function getAddrs(){
		var geocoder = new kakao.maps.services.Geocoder();
		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {
		    
		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
		    navigator.geolocation.getCurrentPosition(function(position) {
		     
		        var lat = position.coords.latitude, // 위도
		        lng = position.coords.longitude; // 경도
		        var coord = new kakao.maps.LatLng(lat, lng);
		        var callback = function(result, status) {
		            if (status === kakao.maps.services.Status.OK) {
		                document.getElementById("addr").value= result[0].region_1depth_name
				        document.getElementById("addr2").value= result[0].region_2depth_name
		            }
		        }
		        geocoder.coord2RegionCode(coord.getLng(), coord.getLat(), callback);
		        window.location.href="write?addr=${addr}&addr2=${addr2}"
		    })
		}
	}
	</script>
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